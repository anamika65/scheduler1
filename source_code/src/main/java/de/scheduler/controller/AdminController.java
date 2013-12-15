package de.scheduler.controller;

import java.io.Console;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.scheduler.importer.UploadForm;
import de.scheduler.model.Configuration;
import de.scheduler.model.DSupportOperation;
import de.scheduler.model.OpBlock;
import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Person;
import de.scheduler.model.Project;
import de.scheduler.model.ProjectPersonInfo;
import de.scheduler.model.ProjectCatalogStatus;
import de.scheduler.model.Specialty;
import de.scheduler.model.TrainingSystem;
import de.scheduler.model.User;
import de.scheduler.model.UserInfo;
import de.scheduler.model.UserRole;
import de.scheduler.service.ConfigurationService;
import de.scheduler.service.DSupportOperationService;
import de.scheduler.service.OpBlockService;
import de.scheduler.service.OpCatalogueService;
import de.scheduler.service.OperationBlockGenerator;
import de.scheduler.service.OpsCodeMappingService;
import de.scheduler.service.OpsCodeMappingServiceInterface;
import de.scheduler.service.PersonService;
import de.scheduler.service.ProjectPersonInfoCmp;
import de.scheduler.service.SchedulerService;
import de.scheduler.service.SchedulesService;
import de.scheduler.service.SpecialtyLoader;
import de.scheduler.service.ProjectService;
import de.scheduler.service.TrainingSystemService;
import de.scheduler.service.UsrMngmentCRUDService;
import de.scheduler.service.UsrMngmentCRUDServiceIntrface;
import de.scheduler.util.SpecialtySelector;


/**
 * Administration Controller for scheduler project
 */
@Controller
public class AdminController {

	protected static Logger logger = Logger.getLogger("base controller");
	
	@Resource(name="personService")
	private PersonService personService;
	
	@Resource(name="opCatalogueService")
	private OpCatalogueService opCatalogueService;
	
	@Resource(name="operationBlockGeneratorService")
	private OperationBlockGenerator operationBlockGeneratorService;
	
	@Resource(name="opBlockService")
	private OpBlockService opBlockService;
	
	@Resource(name="projectService")
	private ProjectService projectService;
	
	@Resource(name="schedulerService")
	private SchedulerService schedulerService;
	
	@Resource(name="schedulesServices")
	private SchedulesService schedulesServices;
	
	@Resource(name="configurationService")
	private ConfigurationService configurationService;
	
	@Resource(name="specialtyLoader")
	private SpecialtyLoader specialtyLoader;
	
	//** Sakib [
	@Resource(name="opsCodeMappingService")
	private OpsCodeMappingServiceInterface opsCodeMappingService;
	//** Sakib ]
	
	//Anamika Start
	@Resource(name="trSystemService")
	private TrainingSystemService trSystemService;
	//Anamika End
	
	@Value("#{settings['birtURL']}")  
	private String birtURL;
	
	public void setBirtURL(String birtURL) {  
       this.birtURL = birtURL;  
	}  
	
	@Resource(name="dSupportOperationService")
	private DSupportOperationService dSupportOperationService;
	
	@Resource(name="usrMngmentCRUDService")
	private UsrMngmentCRUDServiceIntrface usrMngmentCRUDServiceIntrface;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(
	           dateFormat, false));
	}
	
    /**
	 * Schedules operations for current month.
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/administration/schedule", method = RequestMethod.GET)
    public String scheduleForCurrentMonth(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model) {
    	//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
    	
    	logger.debug("Generating current month schedule for specialty with id: " + specialtyId);
    	
    	// try to reactivate residents that are in vacation.
		projectService.reactivateOnVacationUsers(new Date(), specialtyId);
    	
    	try { 
    		//generate the schedule for the current month
    		Map<Project, List<OpBlock>> sch = schedulerService.generateSchedule(specialtyId);
    		Date currentDate = new Date();
    		//first delete the schedule for the current date and specialtyId
    		schedulesServices.deleteScheduleByDate(currentDate, specialtyId);
    		//insert the new schedule into the db
    		for(Entry<Project, List<OpBlock>> entry : sch.entrySet()) { 
    			schedulesServices.batchInsertOpBlocks(entry.getValue(), currentDate);
    		}
		} catch (HibernateException e) {
			logger.debug("Exception occured while trying to generate the schedule for the current month: "
					+ e.getLocalizedMessage());
			throw e;
		}
    	// Attach success to the Model
    	model.addAttribute("scheduleSuccess", "yes");  
    	
    	// This will redirect the user to administration/home with success message
    	return "redirect:../administration/home";
	}
    
    @RequestMapping(value = "/administration/home", method = RequestMethod.GET)
    public String showAdminHome(@RequestParam(value="scheduleSuccess", required=false) boolean scheduleSuccess, Model model) {
		logger.debug("Received request to show administration homepage");
	
    	if(scheduleSuccess) { 
    		model.addAttribute("scheduleSuccess", "yes");    		
    	}
		
    	// Attach specialties to the Model
    	this.mapSpecialties(model);
    	
    	// This will resolve to /WEB-INF/jsp/admin/AdminHome.jsp
		return "admin/AdminHome";
	}
    
    @RequestMapping(value = "/administration/decisionsupport", method = RequestMethod.GET)
    public String showDecisionSupport(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model) {
		logger.debug("Received request to show decision support operations");

		// Attach specialties to the Model
    	this.mapSpecialties(model);
		
    	//load the specialty id from the cookie 
    	int specialtyID = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
    	
   //Information for List of manually added decision_support_operations  	
    	// Retrieve all project nicknames by delegating the call to ProjectService
    	List<String> nicknames = projectService.getAllNicknamesForSpecialty(specialtyID);
    	
    	// Attach nicknames to the Model
    	model.addAttribute("nicknames", nicknames);
		
    	// Retrieve all decision support operations by delegating the call to DSupportOperationService
    	List<DSupportOperation> dSupportOperationsList = dSupportOperationService.getAllForSpecialty(specialtyID);
    	
    	// Attach specialties to the Model
    	model.addAttribute("dSupportOperationsList", dSupportOperationsList);
    	
    	
    //Information for List of residents
    	
		// Retrieve list of residents for each catalogue, prioritized -> by delegating the call to DSupportOperationService
    	Map<OpCatalogue, List<ProjectCatalogStatus>> residentListByCatalogues = dSupportOperationService.getPrioritizedResidents(specialtyID);
		
    	// Attach status to the Model
		model.addAttribute("residentListForCatalogues", residentListByCatalogues);
    
	//** Sakib [
	//Information for List of OpCatalogues
		// Retrieve all OpCatalogues by delegating the call to OpsCodeMappingService
    	List<OpCatalogue> opCatalogues = opsCodeMappingService.getAllOpCatalogue();
    	
    	List<OpCatalogue> filteredOpCatalogues = opsCodeMappingService.getFilteredOpCatalogue();
    	
    	// Attach OpCatalogues to the Model
    	model.addAttribute("opCatalogues", opCatalogues);
    	model.addAttribute("filteredOpCatalogues", filteredOpCatalogues);
    	
	//** Sakib ]
    	// This will resolve to /WEB-INF/jsp/admin/DecisionSupport.jsp
		return "admin/DecisionSupport";
	}
    
    /**
     * Edits an existing operation by delegating the processing to DSupportOperationService.
     * 	
	 * @param id			the id of the current operation to be modified
	 * @param opsc1			the new value for the operation code1
	 * @param opsc2			the new value for the operation code2
	 * @param opDate		the new value for the operation date
	 * @param op1			the new value for the resident nickname1
	 * @param op2			the new value for the resident nickname2
	 * @param ass1			the new value for the assistant nickname1
     */
    @RequestMapping(value = "/administration/decisionsupport/editOperation", method = RequestMethod.POST)
    public String editOperation(@RequestParam(value="id", required=true) Integer id, 
    						@RequestParam(value="opsc1", required=true) String opsc1,
    						@RequestParam(value="opsc2", required=false) String opsc2,
    						@RequestParam(value="opDate", required=true) Date opDate,
    						@RequestParam(value="op1", required=true) String op1,
    						@RequestParam(value="op2", required=false) String op2,
    						@RequestParam(value="ass1", required=false) String ass1) {
    	logger.debug("Received request to edit decision support operation");

    	// We load the existing operation
    	DSupportOperation dSupportOperation = dSupportOperationService.get(id);
    	
    	//set the values
    	dSupportOperation.setOpsc1(opsc1);
    	dSupportOperation.setOpsc2(opsc2);
    	dSupportOperation.setOpDate(opDate);
    	dSupportOperation.setOp1(op1);
    	dSupportOperation.setOp2(op2);
    	dSupportOperation.setAss1(ass1);
    	
    	// Delegate to DSupportOperationService for editing
    	dSupportOperationService.edit(dSupportOperation);
    	
		// This will redirect to /WEB-INF/jsp/admin/DecisionSupport.jsp
		return "redirect:../decisionsupport";
	}
    
    /**
     * Edits an existing operation by delegating the processing to DSupportOperationService.
     * 	
	 * @param id			the id of the current operation to be added
	 * @param opsc1			the value for the operation code1
	 * @param opsc2			the value for the operation code2
	 * @param opDate		the value for the operation date
	 * @param op1			the value for the resident nickname1
	 * @param op2			the value for the resident nickname2
	 * @param ass1			the value for the assistant nickname1
     */
    @RequestMapping(value = "/administration/decisionsupport/add", method = RequestMethod.POST)
    public String addOperation(@RequestParam(value="opsc1Add", required=true) String opsc1,
    						@RequestParam(value="opsc2Add", required=false) String opsc2,
    						@RequestParam(value="opDateAdd", required=true) Date opDate,
    						@RequestParam(value="op1Add", required=true) String op1,
    						@RequestParam(value="op2Add", required=false) String op2,
    						@RequestParam(value="ass1Add", required=false) String ass1,
    						@RequestParam(value="difficultyForFirstOpscode", required=true) String difficultyForFirstOpscode,
    						@RequestParam(value="difficultyForSecondOpscode", required=false) String difficultyForSecondOpscode,
    						@RequestParam(value="opscToCountForOp1", required=false) String opscToCountForOp1,
    						@RequestParam(value="opscToCountForOp2", required=false) String opscToCountForOp2,
    						@RequestParam(value="opscToCountForAss1", required=false) String opscToCountForAss1
    						) {
    	logger.debug("Received request to add decision support operation");
		
    	// We assign the input fields
    	DSupportOperation dSupportOperation = new DSupportOperation();
    	dSupportOperation.setOpsc1(opsc1);
    	dSupportOperation.setOpsc2(opsc2);
    	dSupportOperation.setOpDate(opDate);
    	dSupportOperation.setOp1(op1);
    	dSupportOperation.setOp2(op2);
    	dSupportOperation.setAss1(ass1);
    	dSupportOperation.setEntryDate(new Date());
    	dSupportOperation.setOPSC01Difficulty(Integer.parseInt(difficultyForFirstOpscode));
    	dSupportOperation.setOP1Credit(opscToCountForOp1);
    	if(!opsc2.isEmpty() ) {
    		dSupportOperation.setOPSC02Difficulty(Integer.parseInt(difficultyForSecondOpscode));
    	}
    	if(!op2.isEmpty() ) {
    		dSupportOperation.setOP2Credit(opscToCountForOp2);
    	}
    	if(!ass1.isEmpty() ) {
    		dSupportOperation.setAss1Credit(opscToCountForAss1);
    	}
    	
    	//System.out.println(opscToCountForOp1);
    	// Delegate to DSupportOperationService to do the mapping of the OPSCode to a catalogue
    	// and the actual add
    	dSupportOperationService.add(dSupportOperation);
    	
		// This will redirect to /WEB-INF/jsp/admin/DecisionSupport.jsp
		return "redirect:../decisionsupport";
	}
    
    /**
     * Deletes an existing decision support operation by delegating the processing 
     * to DSupportOperationService.
     * 
     * @param id		the id of the current decision support operation to be deleted
     */
    @RequestMapping(value = "/administration/decisionsupport/delete", method = RequestMethod.POST)
    public String deleteDSupportOperation(@RequestParam(value="id", required=true) Integer id) {   
		logger.debug("Received request to delete existing decision support operation.");
		
		// Call DSupportOperationService to do the actual deleting
		dSupportOperationService.delete(id);
		
		// This will redirect to /WEB-INF/jsp/admin/DecisionSupport.jsp
		return "redirect:../decisionsupport";
	}
    
    @RequestMapping(value = "/administration/progress", method = RequestMethod.GET)
    public String showTrainingProgress(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model) {
		logger.debug("Received request to show training progress");
    	// Attach specialties to the Model
    	this.mapSpecialties(model);
		
    	//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
    	
		// try to reactivate residents that are in vacation.
		projectService.reactivateOnVacationUsers(new Date(), specialtyId);
		// Retrieve status for projects, for each catalogue by delegating the call to ProjectService
    	Map<ProjectPersonInfo, List<ProjectCatalogStatus>> projectsInfo = projectService.getProjectsInformation(specialtyId);
    	Map<ProjectPersonInfo, List<ProjectCatalogStatus>> activeResidents = new TreeMap<ProjectPersonInfo, List<ProjectCatalogStatus>>(ProjectPersonInfoCmp.INSTANCE);
    	Map<ProjectPersonInfo, List<ProjectCatalogStatus>> inactiveResidents = new TreeMap<ProjectPersonInfo, List<ProjectCatalogStatus>>(ProjectPersonInfoCmp.INSTANCE);
    	
    	for(Entry<ProjectPersonInfo, List<ProjectCatalogStatus>> entry : projectsInfo.entrySet()) {
    		if(entry.getKey().getProject().isActive()) {
    			activeResidents.put(entry.getKey(), entry.getValue());
    		} else {
    			inactiveResidents.put(entry.getKey(), entry.getValue());
    		}
    	}
		// Attach status to the Model
		model.addAttribute("activeProjects", activeResidents);
		model.addAttribute("inactiveProjects", inactiveResidents);
		model.addAttribute("birtURL", birtURL);
		// This will resolve to /WEB-INF/jsp/admin/TrainingProgress.jsp
    	return "admin/TrainingProgress";
	}

    /**
     * Adds a new person by delegating the processing to PersonService.
     * Adds a new project by delegating the processing to ProjectService.
     * Adds a new dummy opblock and opblocks for all catalgues by delegating the processing to OperationBlockGenerator.
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/administration/progress/add", method = RequestMethod.POST)
    public String add(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie,
    				@RequestParam(value="title", required=true) String title,
    				@RequestParam(value="name", required=true) String name,
					@RequestParam(value="firstName", required=true) String firstName,
					@RequestParam(value="nickname", required=true) String nickname,
					@RequestParam(value="function", required=true) String function,
					@RequestParam(value="startDate", required=true) Date startDate,
					@RequestParam(value="duration", required=true) Integer duration,
					@RequestParam(value="capacity", required=true) Integer capacity) {    	
		logger.debug("Received request to add new person");
		
		//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
		
    	if(opCatalogueService.isAddPersonAllowed(specialtyId)) {
    		Person person = new Person();
    		person.setFirstName(firstName);
    		person.setName(name);
    		person.setFunction(function);
    		person.setTitle(title);
    		person.setNickname(nickname);
    		// Call PersonService to do the actual adding of a person
    		personService.add(person);
    		
    		Integer newPersID = person.getPersID();
    		
    		Project project = new Project();
    		project.setStartDate(startDate);
    		project.setDuration(duration);
    		project.setCapacity(capacity);
    		project.setPersID(newPersID);
    		project.setActive(true);
    		project.setNickname(nickname);
    		project.setSpecialtyID(specialtyId);
    		
    		// Call ProjectService to do the actual adding of the project
    		projectService.add(project);
    		
    		Integer newProjectID = project.getProjectID();
    		
    		//delegates the creation of DUMMY opBlock to OperationBlockGenerator
    		operationBlockGeneratorService.generateDummyOpBlockForProject(newProjectID);
    		
    		//delegates the creation of NORMAL opBlocks to OperationBlockGenerator
    		operationBlockGeneratorService.generateInitialOpBlocks(newProjectID, specialtyId);
    	}

    	// This will redirect to /WEB-INF/jsp/admin/TrainingProgress.jsp
		return "redirect:../progress";
	}
    
    /**
     * Deactivates an existing resident by delegating the processing to ProjectService.
     * 
     * @param id		the id of the current resident to be deactivated
     */
    @RequestMapping(value = "/administration/progress/deactivate", method = RequestMethod.POST)
    public String deactivate(@RequestParam(value="id", required=true) Integer id) {   
		logger.debug("Received request to deactivate existing resident");
		
		// Call ProjectService to do the actual deactivation
		projectService.deactivate(id);
		
		// This will redirect to /WEB-INF/jsp/admin/TrainingProgress.jsp
		return "redirect:../progress";
	}
    
    /**
     * Activates an existing resident by delegating the processing to ProjectService.
     * 
     * @param id		the id of the current resident to be activated
     */
    @RequestMapping(value = "/administration/progress/activate", method = RequestMethod.POST)
    public String activate(@RequestParam(value="id", required=true) Integer id) {   
		logger.debug("Received request to activate existing resident");
		
		// Call ProjectService to do the actual activation
		projectService.activate(id);
		
		// This will resolve to /WEB-INF/jsp/admin/TrainingProgress.jsp
		return "redirect:../progress";
	}
    
    /**
     * Edits the information of an existing person.
     * 	
	 * @param id			the id of the current project
	 * @param capacity		the new capacity of the resident, number of operation per month
	 * @param duration		the new training duration of the resident in months
	 * @param firstName		the new firstName
	 * @param name			the new name
	 * @param title			the new title
     */
    @RequestMapping(value = "/administration/progress/editPersonInformation", method = RequestMethod.POST)
    public String editPerson(@RequestParam(value="id", required=true) Integer projectID, 
    						@RequestParam(value="capacity", required=true) Integer capacity,
    						@RequestParam(value="duration", required=true) Integer duration,
    						@RequestParam(value="firstName", required=true) String firstName,
    						@RequestParam(value="function", required=true) String function,
    						@RequestParam(value="name", required=true) String name,
    						@RequestParam(value="title", required=true) String title) {
    	logger.debug("Received request to edit a person");

    	// load the associated project
    	Project project = projectService.get(projectID);
    	
    	// load the person
    	Integer personID = project.getPersID();
    	Person person = personService.get(personID);
    	
    	if(project == null || person == null ) { 
    		logger.error("Problem by retriving person with id:" + personID + " and project with id: " + projectID);
    		throw new IllegalStateException("Problem by retriving person and project.");
    	}
    	
    	project.setCapacity(capacity);
    	project.setDuration(duration);
    	//update the existing project
    	projectService.edit(project);
    	
    	person.setFirstName(firstName);
    	person.setName(name);
    	person.setFunction(function);
    	person.setTitle(title);
    	//update the existing person
    	personService.edit(person);
    	
    	// This will resolve to /WEB-INF/jsp/admin/TrainingProgress.jsp
    	return "redirect:../progress";
	}

	@RequestMapping(value = "/administration/import", method = RequestMethod.GET)
	public String showImport(
			@RequestParam(value = "error.upload.null", required = false) String emptyFile,
			@RequestParam(value = "error.upload.contenttype", required = false) String typeError,
			@RequestParam(value = "error.importer.exception", required = false) String importerError,
			@RequestParam(value = "import.success", required = false) String importerSuccess,
			ModelMap model) {
		logger.debug("Received request to show import");

		if (emptyFile != null) {
			model.addAttribute("error", emptyFile);
		}
		
		if (typeError != null) {
			model.addAttribute("error", typeError);
		}
		
		if (importerError != null) {
			model.addAttribute("error", importerError);
		}
		
		if(importerSuccess != null) { 
			model.addAttribute("success", importerSuccess);
		}

		UploadForm form = new UploadForm();
		model.addAttribute("uploadForm", form);
		return "admin/Import";
	}
    
	/**
	 * Handles and retrieves all catalogues and shows in a JSP page
	 */
    @RequestMapping(value = "/administration/catalogues", method = RequestMethod.GET)
    public String showCatalogues(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model) {
		logger.debug("Received request to show catalogues");
		
    	// Attach specialties to the Model
    	this.mapSpecialties(model);
    	
    	//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
    	
		// Retrieve all catalogues by delegating the call to OpCatalogueService
		List<OpCatalogue> catalogues = opCatalogueService.getAllForSpecialty(specialtyId);
		
		// Attach catalogues to the Model
		model.addAttribute("opCatalogues", catalogues);
		
		// This will resolve to /WEB-INF/jsp/admin/Catalogues.jsp
		return "admin/Catalogues";
	}
    
    /**
     * Edits an existing block size of a catalogue by delegating the processing to OpCatalogueService.
     * 	
	 * @param id		the id of the current catalogue to be modified
	 * @param newBlockSize		the new value for the block size
     */
    @RequestMapping(value = "/administration/catalogues/save", method = RequestMethod.POST)
    public String saveEdit( @RequestParam(value="id", required=true) Integer id, 
    						@RequestParam(value="newBlockSize", required=true) Integer newSize) {
    	logger.debug("Received request to update size of opCatalogue");
    
    	// We assign the id and retrieve the new block size from the input field
    	OpCatalogue opCatalogue = new OpCatalogue();
    	opCatalogue.setCatalogueID(id);
    	opCatalogue.setBlockSize(newSize);
    	
    	//save old size for later use
    	Integer oldSize = new Integer(opCatalogue.getBlockSize()); 
    	
    	// Delegate to OpCatalogueService for editing the actual catalogue
    	opCatalogueService.editBlockSize(opCatalogue);
    	
    	// Delegate to OperationBlockGeneratorService for generating the NORMAL opBlocks
    	if ( oldSize != newSize){
    		operationBlockGeneratorService.generateOpBlockForCatalog(id, newSize);
    		opBlockService.fillInOpBlocksSize(id);   		
    	}
    	
		// This will redirect to /WEB-INF/jsp/admin/Catalogues.jsp
		return "redirect:../catalogues";
	}
    
    /**
     * Edits an existing block size of a catalogue by delegating the processing to OpCatalogueService.
     * 	
	 * @param id		the id of the current catalogue to be modified
	 * @param newMonthlyCapacity		the new value for the block size
     */
    @RequestMapping(value = "/administration/catalogues/configureMonthlyCapacity", method = RequestMethod.POST)
    public String editMonthlyCapacity( @RequestParam(value="id", required=true) Integer id, 
    						@RequestParam(value="newMonthlyCapacity", required=true) Integer newMonthlyCapacity) {
    	logger.debug("Received request to update monthly capacity of opCatalogue");
    
    	// We load the existing OpCatalogue
    	OpCatalogue opCatalogue = opCatalogueService.get(id);
    	//save old size for later use
    	Integer oldSize = new Integer(opCatalogue.getMonthlyCapacity()); 
    	//set the new monthly capacity
    	opCatalogue.setMonthlyCapacity(newMonthlyCapacity);
    	
    	if ( oldSize != newMonthlyCapacity)
        	// update existing op block with new monthly capacity
        	opCatalogueService.editMonthlyCapacity(opCatalogue);
    	
		// This will redirect to /WEB-INF/jsp/admin/Catalogues.jsp
		return "redirect:../catalogues";
	}
    
    /**
     * Deletes an existing catalog by delegating the processing to OpCatalogService.
     * 
     * @param id		the id of the current catalogue to be deleted
     */
    @RequestMapping(value = "/administration/catalogues/delete", method = RequestMethod.POST)
    public String deleteCatalog(@RequestParam(value="id", required=true) Integer id) {   
		logger.debug("Received request to delete existing catalog");
		
		// Call OpCatalogueService to do the actual deleting
		opCatalogueService.delete(id);
		
		// This will redirect to /WEB-INF/jsp/admin/Catalogues.jsp
		return "redirect:../catalogues";
	}

    /**
     * Add a new catalog by delegating the processing to OpCatalogService.
     * 
   	 * @param name		the name of the catalogue to be added
	 * @param description		the description of the catalogue to be added
	 * @param specialTrunk		true if the catalogue to be added is from the special trunk
	 * @param easy 		the value of level1OpNo of the catalogue to be added
	 * @param normal		the value of level2OpNo of the catalogue to be added
	 * @param hard		the value of level3OpNo of the catalogue to be added
     */
    @RequestMapping(value = "/administration/catalogues/add", method = RequestMethod.POST)
    public String add ( @CookieValue(value="selectedSpeciality", defaultValue="") String cookie, 
    					@RequestParam(value="name", required=true) String name,
    					@RequestParam(value="description", required=true) String description,
    					@RequestParam(value="specialTrunk", required=true) Boolean specialTrunk,
    					@RequestParam(value="easy", required=true) Integer easy,
    					@RequestParam(value="normal", required=true) Integer normal,
    					@RequestParam(value="hard", required=true) Integer hard) {    	
		logger.debug("Received request to add new catalog");
		
		//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
    	
    	// We assign the input fields
    	OpCatalogue opCatalogue = new OpCatalogue();
    	opCatalogue.setName(name);
    	opCatalogue.setDescription(description);
    	opCatalogue.setSpecialTrunk(specialTrunk);
    	opCatalogue.setLeve1OpNo(easy);
    	opCatalogue.setLeve2OpNo(normal);
    	opCatalogue.setLeve3OpNo(hard);
    	opCatalogue.setBlockSize(0);
    	opCatalogue.setMonthlyCapacity(0);
    	opCatalogue.setSpecialtyID(specialtyId);
		
		// Call OpCatalogueService to do the actual add
		opCatalogueService.add(opCatalogue);
		
		// This will redirect to /WEB-INF/jsp/admin/Catalogues.jsp
		return "redirect:../catalogues";
	}
    /**
     * Add a new training system by delegating the processing to TrainingSystemService.
     * 
   	 * @param trainSysName		the name of the training system to be added
     */
    @RequestMapping(value = "/administration/catalogues/addTrainSystem", method = RequestMethod.POST)
    public String addTrainSystem (@RequestParam(value="trainSysName", required=true) String trainSysName) {    	
		logger.debug("Received request to add new catalog");
		
    	// We assign the input fields
    	TrainingSystem trSystem = new TrainingSystem();
    	trSystem.setTrain_system_name(trainSysName);
    	
		// Call TrainingSystemService to do the actual add
    	trSystemService.addTrSystem(trSystem);
		
		// This will redirect to /WEB-INF/jsp/admin/Catalogues.jsp
		return "redirect:../catalogues";
	}
    @RequestMapping(value = "/administration/settings", method = RequestMethod.GET)
    public String showSettings(Model model) {
    	logger.debug("Received request to show settings");
    	
    	List<Configuration> configs = configurationService.getAll();
    	for(Configuration config : configs) { 
    		model.addAttribute(config.getName(), config.getValue());
    	}
    	
    	String username = "Dirk"; // This will be fixed after registration process is complete
    	List<DSupportOperation> difficultOperations = dSupportOperationService.getAllForUser(username);
    	model.addAttribute("difficultOperations", difficultOperations);
    	
    	List<String> operatedAs = new ArrayList<String>();
    	for(DSupportOperation difficultOperation : difficultOperations) { 
    		if(difficultOperation.getOp1() == username) {
    			operatedAs.add("Op1");
    		} else if(difficultOperation.getOp2() == username) {
    			operatedAs.add("Op2");
    		} else {
    			operatedAs.add("Ass1");
    		}
    	}
    	
    	model.addAttribute("nameUser", username);
		// This will resolve to /WEB-INF/jsp/admin/Settings.jsp
		return "admin/Settings";
	}
    
    @RequestMapping(value = "/administration/settings/save", method = RequestMethod.POST)
    public String saveNewSettings(@RequestParam(value="TRAINING_DURATION", required=true) Integer trainingDuration,
			@RequestParam(value="RESIDENT_CAPACITY", required=false) Integer residentCapacity) {
    	logger.debug("Received request to update settings");
    	
    	if(trainingDuration != null) { 
    		configurationService.updateSetting("TRAINING_DURATION", trainingDuration);    		
    	}
    	
    	if(residentCapacity != null) { 
    		configurationService.updateSetting("RESIDENT_CAPACITY", residentCapacity);    		
    	}
    	
    	// This will redirect to /WEB-INF/jsp/admin/Settings.jsp
		return "redirect:../settings";
	}
    
    /**
     * Deactivates the resident and sends him/her on vacation until untilDate.
     * 	
	 * @param id		the id of the current project to be modified
	 * @param untilDate		the Date until the project is on vacation
     */
    @RequestMapping(value = "/administration/progress/onVacation", method = RequestMethod.POST)
    public String editOnVacation( @RequestParam(value="id", required=true) Integer id, 
    						@RequestParam(value="untilDate", required=true) Date untilDate) {
    	logger.debug("Received request to send project OnVacation");
    
    	// Call ProjectService to do the actual deactivation until date
    	projectService.deactivateUntilDate(id, untilDate);
    	
		// This will redirect to /progress
		return "redirect:../progress";
	}
    
    /**
     * User Management CRUD(Create,Read,Update,Delete) Operation
     * 
     */
    
    @RequestMapping(value = "/administration/crud", method = RequestMethod.GET)
    public String crudOperation(Model model, Principal principal){
    	final String currentUser = principal.getName();
    	List<UserInfo> userDetail = usrMngmentCRUDServiceIntrface.getAllUsers(currentUser);
    	
    	// Attach specialties to the Model
    	model.addAttribute("userDetail", userDetail);
    	
    	return "admin/UsrMangment";
    }
    
    
    /**
     * Delete an existing User 
     * 
     * @param id		the id of the current resident to be deleted
     */
    @RequestMapping(value = "/administration/crud/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value="id", required=true) Integer id) {   
		logger.debug("Received request to deleting existing user");
		
		usrMngmentCRUDServiceIntrface.deleteUsers(id);
		// This will redirect to /WEB-INF/jsp/admin/crud.jsp
		return "redirect:../crud";
	}
    /**
     * Updating an existing User 
     * 
     * @param id		the id of the current resident to be updated
     */
    @RequestMapping(value = "/administration/crud/updateUserInformation", method = RequestMethod.POST)
    public String updateUser(@RequestParam(value="id", required=true) Integer id,
    						 @RequestParam(value="username" , required=true) String username,
    						 @RequestParam(value="password" , required=true) String password,
    						 @RequestParam(value="activity") Boolean activity,
    						 @RequestParam(value="user_role") String user_role
    		) {   
		logger.debug("Received request to updating existing user");
		
		//Find User by id
		User user = usrMngmentCRUDServiceIntrface.get(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setActive(activity);
			
		//Update User
		usrMngmentCRUDServiceIntrface.updateUsers(user);
		
		//Update User_Role
		Integer role_id=usrMngmentCRUDServiceIntrface.getRoleId(id);	
		UserRole usrRole = usrMngmentCRUDServiceIntrface.getUserRole(role_id);
		usrRole.setRole(user_role);
		usrRole.setUser(user);
		
		//Update User Role
		usrMngmentCRUDServiceIntrface.updateUserRole(usrRole);
		// This will redirect to /WEB-INF/jsp/admin/crud.jsp
		return "redirect:../crud";
	}

	/**
	 * Attach specialties to the Model
	 */   
    public boolean mapSpecialties(Model model){
		logger.debug("Received request to get all specialties");
		
    	// Retrieve all specialties by delegating the call to SpecialtyLoader
		// which caches the specialty's
    	List<Specialty> specialty = specialtyLoader.getSpecialties();
    	
    	// Attach specialties to the Model
    	model.addAttribute("specialties", specialty);
    	
    	return true;
    }

    /**
     * Check if an OpCatalgue exists for the sent pscode 
     * 
     * @param psValue		the pscode to be checked
     */

    @RequestMapping(value = "/administration/decisionsupport/checkmapping", method = RequestMethod.POST)
    public @ResponseBody String checkmapping(String psValue) {
		logger.debug("Received request to check the mapping between OpCatalogue and pscode");
		
		// Get the OpCatalogue for PsCode
		Integer opCatalogueId = opsCodeMappingService.getOpCatalogueIdForPsCode(psValue);
		
		if(opCatalogueId == null) return "-1";
		else return opCatalogueId.toString();
	}

    /**
     * Insert/Update OpCatalgue for the sent pscode 
     * 
     * @param psValue		the pscode to be updated / inserted
     * @param clValue		the OpCatalgue to be mapped with
     */

    @RequestMapping(value = "/administration/decisionsupport/updatemapping", method = RequestMethod.POST)
    public @ResponseBody String updatemapping(String psValue, String clValue) {
		logger.debug("Received request to insert / update the mapping between OpCatalogue and pscode");
		
		if(Integer.parseInt(clValue) <= 0 ) return "-1";
		
		// Get the OpCatalogue for PsCode
		Integer opCatalogueId = opsCodeMappingService.getOpCatalogueIdForPsCode(psValue);
		Boolean updateSuccess = false;
		if(opCatalogueId == null) {
			// Insert the OpCatalogue for PsCode
			updateSuccess = opsCodeMappingService.insertOpCatalogueForPsCode(psValue, clValue, "");
		} else {
			// Update the OpCatalogue for PsCode
			updateSuccess = opsCodeMappingService.updateOpCatalogueForPsCode(psValue,clValue);
		}
				
		if(updateSuccess) return clValue.toString();
		else return "-1";
	}

}

