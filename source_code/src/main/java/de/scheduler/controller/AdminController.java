package de.scheduler.controller;

import java.io.Console;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
import de.scheduler.model.Operation;
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
import de.scheduler.service.OperationService;
import de.scheduler.service.OpsCodeMappingService;
import de.scheduler.service.OpsCodeMappingServiceInterface;
import de.scheduler.service.PersonService;
import de.scheduler.service.ProjectPersonInfoCmp;
import de.scheduler.service.ScheduleService;
import de.scheduler.service.SchedulerService;
import de.scheduler.service.SchedulesService;
import de.scheduler.service.SpecialtyLoader;
import de.scheduler.service.ProjectService;
import de.scheduler.service.SpecialtyService;
import de.scheduler.service.TrainingSystemService;
import de.scheduler.service.UserRegistrationService;
import de.scheduler.service.UsrMngmentCRUDService;
import de.scheduler.service.UsrMngmentCRUDServiceIntrface;
import de.scheduler.util.SpecialtySelector;


/**
 * Administration Controller for scheduler project
 */
@Controller
public class AdminController {
		@Resource(name = "sessionFactory")
		private SessionFactory sessionFactory;
		
        protected static Logger logger = Logger.getLogger("base controller");
        protected static String defaultDifficultOperation = "X-999";
        
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
        
        @Resource(name="trSystemService")
        private TrainingSystemService trSystemService;
        
        //Sakib - For manually added operations
        @Resource(name = "operationService")
    	private OperationService operationService;
        
        
        @Value("#{settings['birtURL']}")  
        private String birtURL;
        
        public void setBirtURL(String birtURL) {  
        	this.birtURL = birtURL;  
        }  
        
        @Resource(name="dSupportOperationService")
        private DSupportOperationService dSupportOperationService;
        
        @Resource(name="usrMngmentCRUDService")
        private UsrMngmentCRUDServiceIntrface usrMngmentCRUDServiceIntrface;
        
        @Resource(name = "userRegistrationService")
        private UserRegistrationService userRgistrationService;
        
        @Resource(name="specialtyService")
        private SpecialtyService specService;
        
        @Resource(name="scheduleService")
        private ScheduleService scheduleService;
        
        @Autowired
        private JavaMailSender mailSender;
        
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
                    //Map<Project, List<OpBlock>> sch = schedulerService.generateSchedule(specialtyId);  // Old version
            	
            		/*This is the scheduling generation function call.In this Operation you have to add your new
            		 * Implementation. The FUnction takes specialityId as Argument */
            	
            		Map<Project, List<OpBlock>> sch = scheduleService.generateScheduleNew(specialtyId);  //New Version
                    Date currentDate = new Date();
                    //first delete the schedule for the current date and specialtyId
                    schedulesServices.deleteScheduleByDate(currentDate, specialtyId);
                    
                    /*insert the new schedule into the db .Here you have to add
                     *    in batchInsertOpBlocks Operation you will add the data that you got from your 
                     *    generateScheduleNew function(this function returns the Map of Project and list of OpBlocks) 
                     *    
                     */
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
         * @param id                        the id of the current operation to be modified
         * @param opsc1                        the new value for the operation code1
         * @param opsc2                        the new value for the operation code2
         * @param opDate                the new value for the operation date
         * @param op1                        the new value for the resident nickname1
         * @param op2                        the new value for the resident nickname2
         * @param ass1                        the new value for the assistant nickname1
     */
    @RequestMapping(value = "/administration/decisionsupport/editOperation", method = RequestMethod.POST)
    public String editOperation(@RequestParam(value="id", required=true) Integer id, 
					    		@RequestParam(value="opsc1Add", required=true) String opsc1,
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
            logger.debug("Received request to edit decision support operation");
            
            // We assign the input fields
            DSupportOperation dSupportOperation = dSupportOperationService.get(id);
            dSupportOperation.setOpsc1(opsc1);
            dSupportOperation.setOpsc2(opsc2);
            dSupportOperation.setOpDate(opDate);
            dSupportOperation.setOp1(op1);
            dSupportOperation.setOp2(op2);
            dSupportOperation.setAss1(ass1);
            //dSupportOperation.setEntryDate(new Date());
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
            
            
            
            /*//System.out.println(opscToCountForOp1);
            // Delegate to DSupportOperationService to do the mapping of the OPSCode to a catalogue
            // and the actual add
            dSupportOperationService.add(dSupportOperation);
            
            // We load the existing operation
            DSupportOperation dSupportOperation = dSupportOperationService.get(id);
            
            //set the values
            dSupportOperation.setOpsc1(opsc1);
            dSupportOperation.setOpsc2(opsc2);
            dSupportOperation.setOpDate(opDate);
            dSupportOperation.setOp1(op1);
            dSupportOperation.setOp2(op2);
            dSupportOperation.setAss1(ass1);
            */
            // Delegate to DSupportOperationService for editing
            dSupportOperationService.edit(dSupportOperation);
            
            // This will redirect to /WEB-INF/jsp/admin/DecisionSupport.jsp
            return "redirect:../decisionsupport";
        }

    /**
     * Edits an existing operation to update the chosen difficult operation for a resident
     *         
         * @param diffSuppOpId                the id of the current operation to be modified
         * @param operatedAs                  the position of the resident in the operation : Op1, Op2, Ass1
         * @param opscToCount                the value indicating if which opsc will be counted as difficult
     */
    @RequestMapping(value = "/administration/decisionsupport/updateChosenDiffOp", method = RequestMethod.POST)
    public String updateChosenDiffOp(@RequestParam(value="diffSuppOpId", required=true) String diffSuppOpId, 
                                                    @RequestParam(value="operatedAs", required=true) String operatedAs,
                                                    @RequestParam(value="opscToCount", required=false) String opscToCount) {
            logger.debug("Received request to update difficult decision support operation");

            // We load the existing operation
            DSupportOperation dSupportOperation = dSupportOperationService.get(Integer.parseInt(diffSuppOpId));
            
            //System.out.println("Update Difficult : " + diffSuppOpId + " : " + operatedAs + " : " + opscToCount);
            
            List<String> itemsForOpscToCount = new ArrayList<String>();
            String resident = "";
            Integer insertedId;
            System.out.println("!!!!"+opscToCount+"!!!!");
            
            if(opscToCount != null) {
            	itemsForOpscToCount = Arrays.asList(opscToCount.split("\\s*,\\s*"));
            	for(int i = 0; i < itemsForOpscToCount.size(); i++) {
            		
            		
            		String o;
            		if(itemsForOpscToCount.get(i).equalsIgnoreCase("OPSC01")) {
            			o = dSupportOperation.getOpsc1();
            		} else {
            			o = dSupportOperation.getOpsc2();
            		}
            		System.out.println("!!!!"+o+"!!!!");
            		Operation operToRemove = new Operation();
            		
		            if(operatedAs.equals("Op1")) {
		            	resident = dSupportOperation.getOp1();
		            	if(dSupportOperation.getOperation1Op1() != null) {
		            		Integer operation1 = dSupportOperation.getOperation1Op1();
		            		operToRemove = operationService.get(operation1);
		            		if(operToRemove.getOpsc1().equalsIgnoreCase(o)) {
		            			insertedId = addDifficultOperation(dSupportOperation,operToRemove,resident);
				                dSupportOperation.setOperation1Op1(insertedId);
		            		}
		            	}
		            	if(dSupportOperation.getOperation2Op1() != null) {
		            		Integer operation2 = dSupportOperation.getOperation2Op1();
		            		operToRemove = operationService.get(operation2);
		            		if(operToRemove.getOpsc1().equalsIgnoreCase(o)) {
		            			insertedId = addDifficultOperation(dSupportOperation,operToRemove,resident);
				                dSupportOperation.setOperation2Op1(insertedId);
		            		}
		            	}
		            }
		            else if(operatedAs.equals("Op2")) {
		            	resident = dSupportOperation.getOp2();
		            	if(dSupportOperation.getOperation1Op2() != null) {
		            		Integer operation1 = dSupportOperation.getOperation1Op2();
		            		operToRemove = operationService.get(operation1);
		            		if(operToRemove.getOpsc1().equalsIgnoreCase(o)) {
		            			insertedId = addDifficultOperation(dSupportOperation,operToRemove,resident);
				                dSupportOperation.setOperation1Op2(insertedId);
		            		}
		            	}
		            	if(dSupportOperation.getOperation2Op2() != null) {
		            		Integer operation2 = dSupportOperation.getOperation2Op2();
		            		operToRemove = operationService.get(operation2);
		            		if(operToRemove.getOpsc1().equalsIgnoreCase(o)) {
		            			insertedId = addDifficultOperation(dSupportOperation,operToRemove,resident);
				                dSupportOperation.setOperation2Op2(insertedId);
		            		}
		            	}
		            }
		            else if(operatedAs.equals("Ass1")) {
		            	resident = dSupportOperation.getAss1();
		            	if(dSupportOperation.getOperation1Ass1() != null) {
		            		Integer operation1 = dSupportOperation.getOperation1Ass1();
		            		operToRemove = operationService.get(operation1);
		            		if(operToRemove.getOpsc1().equalsIgnoreCase(o)) {
		            			insertedId = addDifficultOperation(dSupportOperation,operToRemove,resident);
				                dSupportOperation.setOperation1Ass1(insertedId);
		            		}
		            	}
		            	if(dSupportOperation.getOperation2Ass1() != null) {
		            		Integer operation2 = dSupportOperation.getOperation2Ass1();
		            		operToRemove = operationService.get(operation2);
		            		if(operToRemove.getOpsc1().equalsIgnoreCase(o)) {
		            			insertedId = addDifficultOperation(dSupportOperation,operToRemove,resident);
				                dSupportOperation.setOperation2Ass1(insertedId);
		            		}
		            	}
		            }
            	}
            }
            
            //set the values
            if(operatedAs.equals("Op1")) {
            	if(dSupportOperation.getOP1ChosenDifficult() != null) {
            		dSupportOperation.setOP1ChosenDifficult(dSupportOperation.getOP1ChosenDifficult()+","+opscToCount);
            	} else {
            		dSupportOperation.setOP1ChosenDifficult(opscToCount);
            	}
            }
            if(operatedAs.equals("Op2")) {
            	if(dSupportOperation.getOP2ChosenDifficult() != null) {
            		dSupportOperation.setOP2ChosenDifficult(dSupportOperation.getOP2ChosenDifficult()+","+opscToCount);
            	} else {
            		dSupportOperation.setOP2ChosenDifficult(opscToCount);
            	}
            }
            if(operatedAs.equals("Ass1")) {
            	if(dSupportOperation.getAss1ChosenDifficult() != null) {
            		dSupportOperation.setAss1ChosenDifficult(dSupportOperation.getAss1ChosenDifficult()+","+opscToCount);
            	} else {
            		dSupportOperation.setAss1ChosenDifficult(opscToCount);
            	}
            }
            
            // Delegate to DSupportOperationService for editing
            dSupportOperationService.edit(dSupportOperation);
            
            // This will redirect to /WEB-INF/jsp/admin/DecisionSupport.jsp
            return "redirect:../progress";
    }
    
    public Integer addDifficultOperation(DSupportOperation dsupop, Operation operToRemove, String resident) {

    	System.out.println("!!!!Removing operation : "+operToRemove+"!!!!"+operToRemove.getOpBlockId());
    	operationService.removeOperation(operToRemove.getOpBlockId());
		
    	System.out.println("!!!!Adding Difficult operation...");
        List<Operation> operations = new LinkedList<Operation>();
		Integer lastId;
		
		Operation op_1 = new Operation();
		op_1.setOpsc1(defaultDifficultOperation);
    	op_1.setOpDate(dsupop.getOpDate());
    	op_1.setOp1(resident);
    	op_1.setOpsc2("");
    	op_1.setOp2("");
    	op_1.setAss1("");

    	operations.add(op_1);
        operationService.performBatchInsert(operations);
        opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
        lastId = operationService.getLastId();
        System.out.println("!!!!Added Difficult operation: "+ lastId);
        return lastId;
    }
    /**
     * Adds an decision support operation by delegating the processing to DSupportOperationService.
     *         
         * @param id                        the id of the current operation to be added
         * @param opsc1                        the value for the operation code1
         * @param opsc2                        the value for the operation code2
         * @param opDate                the value for the operation date
         * @param op1                        the value for the resident nickname1
         * @param op2                        the value for the resident nickname2
         * @param ass1                        the value for the assistant nickname1
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
                                                    @RequestParam(value="opscToCountForAss1", required=false) String opscToCountForAss1,
                                                    @RequestParam(value="deletable", required=false) String deletable
                                                    ) {
            logger.debug("Received request to add decision support operation");
            
            ////
            //Sakib - for adding manually adding operations in operations table
            List<Operation> operations = new LinkedList<Operation>();
            Integer lastId;

            DSupportOperation dSupportOperation = new DSupportOperation();
            
            ////Who will get credit for which opsc
            ////According to that we will insert multiple operations in the "operations" table
            List<String> itemsForOp1 = new ArrayList<String>();
            List<String> itemsForOp2 = new ArrayList<String>();;
            List<String> itemsForAss1 = new ArrayList<String>();;
            System.out.println("?????????????????"+opscToCountForOp2+"???????????????");
            if(opscToCountForOp1 != null) {
            	itemsForOp1 = Arrays.asList(opscToCountForOp1.split("\\s*,\\s*"));
            }
            if(opscToCountForOp2 != null) {
            	itemsForOp2 = Arrays.asList(opscToCountForOp2.split("\\s*,\\s*"));
            }
            if(opscToCountForAss1 != null) {
            	itemsForAss1 = Arrays.asList(opscToCountForAss1.split("\\s*,\\s*"));
            } 
            
            //One operation must insert 
            Operation op_1 = new Operation();
        	op_1.setOpsc1(opsc1);
        	op_1.setOpsc2(opsc2);
        	op_1.setOpDate(opDate);
        	op_1.setOp1(op1);
        	op_1.setOp2(op2);
        	op_1.setAss1(ass1);
            
        	operations.add(op_1);
            operationService.performBatchInsert(operations);
            opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
            lastId = operationService.getLastId();
            dSupportOperation.setOperation1Op1(lastId);
			System.out.println("++++++ total operations to be inserted : "+operations.size()+" "+lastId);
			
            
            if(itemsForOp1.size() > 0) {
            	System.out.println("Size check OP1: "+itemsForOp1.size());
            	System.out.println("which : "+itemsForOp1.get(0));
            	//This operation is already inserted
            	
            	if(itemsForOp1.size() > 1) {
                	System.out.println("which : "+itemsForOp1.get(1));
                	Operation op_2 = new Operation();
                	if(itemsForOp1.get(1).equalsIgnoreCase("OPSC01")) op_2.setOpsc1(opsc1);
                	else op_2.setOpsc1(opsc2);
                	op_2.setOpDate(opDate);
                	op_2.setOp1(op1);
                	
                	op_2.setOpsc2("");
                	op_2.setOp2("");
                	op_2.setAss1("");
                	
                	operations = new LinkedList<Operation>();
                    operations.add(op_2);
                    operationService.performBatchInsert(operations);
                    opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
                    lastId = operationService.getLastId();
                    dSupportOperation.setOperation2Op1(lastId);
        			System.out.println("++++++ total operations to be inserted : "+operations.size()+" "+lastId);
        			
                }
            }
            if(itemsForOp2.size() > 0) {
            	System.out.println("Size check OP2: "+itemsForOp2.size());
            	System.out.println("which : "+itemsForOp2.get(0));
            	
            	Operation op_3 = new Operation();
            	if(itemsForOp2.get(0).equalsIgnoreCase("OPSC01")) op_3.setOpsc1(opsc1);
            	else op_3.setOpsc1(opsc2);
            	op_3.setOpDate(opDate);
            	op_3.setOp1(op2);

            	op_3.setOpsc2("");
            	op_3.setOp2("");
            	op_3.setAss1("");
            	
            	operations = new LinkedList<Operation>();
                operations.add(op_3);
                operationService.performBatchInsert(operations);
                opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
                lastId = operationService.getLastId();
                dSupportOperation.setOperation1Op2(lastId);
    			System.out.println("++++++ total operations to be inserted : "+operations.size()+" "+lastId);
    			
            	if(itemsForOp2.size() > 1) {
                	System.out.println("which : "+itemsForOp2.get(1));
                	
                	Operation op_4 = new Operation();
                	if(itemsForOp2.get(1).equalsIgnoreCase("OPSC01")) op_4.setOpsc1(opsc1);
                	else op_4.setOpsc1(opsc2);
                	op_4.setOpDate(opDate);
                	op_4.setOp1(op2);

                	op_4.setOpsc2("");
                	op_4.setOp2("");
                	op_4.setAss1("");
                	
                	operations = new LinkedList<Operation>();
                    operations.add(op_4);
                    operationService.performBatchInsert(operations);
                    opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
                    lastId = operationService.getLastId();
                    dSupportOperation.setOperation2Op2(lastId);
        			System.out.println("++++++ total operations to be inserted : "+operations.size()+" "+lastId);
        			
                }
            }
            if(itemsForAss1.size() > 0) {
            	System.out.println("Size check Ass1: "+itemsForAss1.size());
            	System.out.println("which : "+itemsForAss1.get(0));
            	
            	Operation op_5 = new Operation();
            	if(itemsForAss1.get(0).equalsIgnoreCase("OPSC01")) op_5.setOpsc1(opsc1);
            	else op_5.setOpsc1(opsc2);
            	op_5.setOpDate(opDate);
            	op_5.setOp1(ass1);

            	op_5.setOpsc2("");
            	op_5.setOp2("");
            	op_5.setAss1("");
            	
            	operations = new LinkedList<Operation>();
                operations.add(op_5);
                operationService.performBatchInsert(operations);
                opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
                lastId = operationService.getLastId();
                dSupportOperation.setOperation1Ass1(lastId);
    			System.out.println("++++++ total operations to be inserted : "+operations.size()+" "+lastId);
    			
            	
            	if(itemsForAss1.size() > 1) {
                	System.out.println("which : "+itemsForAss1.get(1));
                	
                	Operation op_6 = new Operation();
                	if(itemsForAss1.get(1).equalsIgnoreCase("OPSC01")) op_6.setOpsc1(opsc1);
                	else op_6.setOpsc1(opsc2);
                	op_6.setOpDate(opDate);
                	op_6.setOp1(ass1);

                	op_6.setOpsc2("");
                	op_6.setOp2("");
                	op_6.setAss1("");
                	
                	operations = new LinkedList<Operation>();
                    operations.add(op_6);
                    operationService.performBatchInsert(operations);
                    opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
                    lastId = operationService.getLastId();
                    dSupportOperation.setOperation2Ass1(lastId);
        			System.out.println("++++++ total operations to be inserted : "+operations.size()+" "+lastId);
        			
                }
            }
            
            /*operationService.performBatchInsert(operations);
            //update opblocks with the imported operations
			if (operations.size() >= 2) {
				opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(operations.size()-1).getOpBlockId());
				//Sakib Anamika
				//opBlockService.deleteDSuppOperationsAfterImport(operations.get(0).getOpBlockId(), operations.get(operations.size()-1).getOpBlockId());
			} else {
				//Should always go in this block
				opBlockService.updateOpBlocksSize(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
				//Sakib Anamika
				//opBlockService.deleteDSuppOperationsAfterImport(operations.get(0).getOpBlockId(), operations.get(0).getOpBlockId());
			}
            Integer lastId = operationService.getLastId();
			System.out.println("++++++ total operations to be inserted : "+operations.size());
			*/
            ////
            
            
            // We assign the input fields
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
            dSupportOperation.setDeletable(Integer.parseInt(deletable));
            
            
            //Add operation ids to decisionsupport table
            /*String operationIds  = "";
            int f=0;
            for (Integer oid : lastIds) {
            	if (f== 0)	operationIds += oid.toString();
            	else	operationIds += ","+oid.toString();
            	f++;
			}
            dSupportOperation.setOperationIds(operationIds.toString());
            */
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
     * @param id                the id of the current decision support operation to be deleted
     */
    @RequestMapping(value = "/administration/decisionsupport/delete", method = RequestMethod.POST)
    public String deleteDSupportOperation(@RequestParam(value="id", required=true) Integer id) {   
                logger.debug("Received request to delete existing decision support operation.");
                
                DSupportOperation dsop = dSupportOperationService.get(id);
                if (dsop.getOperation1Op1() != null) {
                	if (dsop.getOperation1Op1() > 0) operationService.removeOperation(dsop.getOperation1Op1());
                }
                if (dsop.getOperation2Op1() != null) {
                	if (dsop.getOperation2Op1() > 0) operationService.removeOperation(dsop.getOperation2Op1());
                }
                if (dsop.getOperation1Op2() != null) {
                	if (dsop.getOperation1Op2() > 0) operationService.removeOperation(dsop.getOperation1Op2());
                }
                if (dsop.getOperation2Op2() != null) {
                	if (dsop.getOperation2Op2() > 0) operationService.removeOperation(dsop.getOperation2Op2());
                }
                if (dsop.getOperation1Ass1() != null) {
                	if (dsop.getOperation1Ass1() > 0) operationService.removeOperation(dsop.getOperation1Ass1());
                }
                if (dsop.getOperation2Ass1() != null) {
                	if (dsop.getOperation2Ass1() > 0) operationService.removeOperation(dsop.getOperation2Ass1());
                }
                
                // Call DSupportOperationService to do the actual deleting
                dSupportOperationService.delete(id);
                
                // This will redirect to /WEB-INF/jsp/admin/DecisionSupport.jsp
                return "redirect:../decisionsupport";
        }
    
    @RequestMapping(value = "/administration/progress", method = RequestMethod.GET)
    public String showTrainingProgress(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model, Principal principal) {
            logger.debug("Received request to show training progress");
            // Attach specialties to the Model
            this.mapSpecialties(model);
                
            //load the specialty id from the cookie 
            int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
            
            // try to reactivate residents that are in vacation.
            projectService.reactivateOnVacationUsers(new Date(), specialtyId);
            // Retrieve status for projects, for each catalogue by delegating the call to ProjectService
            
            Map<ProjectPersonInfo, List<ProjectCatalogStatus>> projectsInfo = projectService.getProjectsInformation(specialtyId);
            
            // Retrieve current user and role
            String username = principal.getName(); //"Dirk"; // This will be fixed after registration process is complete
            User currentUser = usrMngmentCRUDServiceIntrface.getUserFromUsername(username);
            UserRole currentUserRole = usrMngmentCRUDServiceIntrface.getUserRole(usrMngmentCRUDServiceIntrface.getRoleId(currentUser.getId()));
            String loggedUserRole = currentUserRole.getRole();
            
            //User ur = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //String nme = ur.getUsername(); //get logged in username
            
            //System.out.println("currentUsr = " + username);
            //System.out.println("USer_id = " + currentUser.getId());
            //System.out.println("USer_role_id = " + usrMngmentCRUDServiceIntrface.getRoleId(currentUser.getId()));
            //System.out.println("USer_role = " + loggedUserRole);
            if(loggedUserRole.equals("ROLE_ADMIN") ) {
            
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
	            //System.out.println("Total number of active projects = " + activeResidents.size());
	            //System.out.println("Total number of inactive projects = " + inactiveResidents.size());
	            
            } else { //ROLE_RESIDENT :resident
            	Map<ProjectPersonInfo, List<ProjectCatalogStatus>> thisResident = new TreeMap<ProjectPersonInfo, List<ProjectCatalogStatus>>(ProjectPersonInfoCmp.INSTANCE);
            	
	            for(Entry<ProjectPersonInfo, List<ProjectCatalogStatus>> entry : projectsInfo.entrySet()) {
	            	//System.out.println("a = " + entry.getKey().getProject().getNickname() + " b = " + personService.getPersonForUserId(currentUser.getId()).getNickname());
	            	if(entry.getKey().getProject().getNickname().equals(personService.getPersonForUserName(currentUser.getUsername()).getNickname()) && entry.getKey().getProject().isActive()) {
	            		thisResident.put(entry.getKey(), entry.getValue());
	            		System.out.println("equal!");
	                } 
	            }
            
	            // Attach status to the Model
	            model.addAttribute("thisProject", thisResident);
	            //System.out.println("Total number of projects = " + thisProject.size());
	            
	            //For difficult operations
	            List<DSupportOperation> difficultOperations = dSupportOperationService.getAllForUser(username);
	            model.addAttribute("difficultOperations", difficultOperations);
	            System.out.println("operation count " + difficultOperations.size());
	            
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
            }
            List<Specialty> specialityID = specService.getAll();    
            List<TrainingSystem> trainSystems = trSystemService.getAllTrainSystem();
            model.addAttribute("trainSystems", trainSystems); 
            //System.out.println(specialityID);
            //Attach specialities to the Model 
            model.addAttribute("specIality", specialityID);  
            model.addAttribute("userRole", loggedUserRole);
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
                                        @RequestParam(value="username", required=true) String username,
                                        @RequestParam(value="password", required=true) String password,
                                        @RequestParam(value="specialityID", required=true) Integer specialityID,
                                        @RequestParam(value="trainSysId", required=true) Integer trainSysId,
                                        @RequestParam(value="emailAdd", required=true) final String emailID,
                                        @RequestParam(value="function", required=true) String function,
                                        @RequestParam(value="startDate", required=true) Date startDate,
                                        @RequestParam(value="duration", required=true) Integer duration,
                                        @RequestParam(value="capacity", required=true) Integer capacity) {            
                logger.debug("Received request to add new person");
                
                //load the specialty id from the cookie 
                //int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
                int specialtyId = specialityID;
    		    
            if(opCatalogueService.isAddPersonAllowed(specialtyId)) {
		          //Add a new User
		            User user = new User();
		            user.setActive(true); //sets false on registration;Updates on first login
		            user.setUsername(username);
		            user.setPassword(password);
		            user.setSpecialityID(specialityID);
		            user.setTrainingSystemID(trainSysId);
		            user.setEmailID(emailID);
		            user.setRegular(0);//added later
		            userRgistrationService.addUser(user);
		            
		            Integer userNewId = user.getId();
		            //Add User Roles
		            UserRole user_Role = new UserRole();
		            user_Role.setRole("ROLE_RESIDENT");
		            user_Role.setUser(user);
		            userRgistrationService.addUserRole(user_Role);
		            
            
                    Person person = new Person();
                    person.setFirstName(firstName);
                    person.setName(name);
                    person.setFunction(function);
                    person.setTitle(title);
                    person.setNickname(username);
                    person.setUsername(username);
                    // Call PersonService to do the actual adding of a person
                    personService.add(person);
                    
                    Integer newPersID = person.getPersID();
                    
                    Project project = new Project();
                    project.setPersID(newPersID);
                    project.setStartDate(startDate);
                    project.setDuration(duration);
                    project.setCapacity(capacity);
                    project.setActive(true);
                    project.setNickname(username);
                    project.setSpecialtyID(specialityID);
                    
                    // Call ProjectService to do the actual adding of the project
                    projectService.add(project);
                    
                    Integer newProjectID = project.getProjectID();
                    
                    //delegates the creation of DUMMY opBlock to OperationBlockGenerator
                    operationBlockGeneratorService.generateDummyOpBlockForProject(newProjectID);
                    
                    
                    //delegates the creation of NORMAL opBlocks to OperationBlockGenerator
                    operationBlockGeneratorService.generateInitialOpBlocks(newProjectID, specialtyId, trainSysId);
                    
                    
                  //Create a simple Email Object
                    SimpleMailMessage email = new SimpleMailMessage();
                    email.setTo(emailID);
                    email.setSubject("Welcome TO MRI");
                    email.setText("Welcome User....You are now Registered.Thank you for your Consideration");
                    
                    //sends the email
                    //mailSender.send(email);
                    //////
                    mailSender.send(new MimeMessagePreparator() {

                    	@Override
                    	public void prepare(MimeMessage mimeMessage) throws Exception {
                    	MimeMessageHelper messageHelper = new MimeMessageHelper(
                    	mimeMessage, true, "UTF-8");
                    	messageHelper.setTo(emailID);
                    	messageHelper.setSubject("Welcome TO MRI");
                    	messageHelper.setText("Welcome User....You are now Registered.Thank you for your Consideration");
                    	}

                    });
            } else {
            	logger.debug("Could not add resident. Either the specialty had no catalogue or the catalogue has block size 0");
            	System.out.println("Could not add resident. Either the specialty had no catalogue or the catalogue has block size 0");
            }
            
          
             
            // This will redirect to /WEB-INF/jsp/admin/TrainingProgress.jsp
                return "redirect:../progress";
        }
    
    /**
     * Deactivates an existing resident by delegating the processing to ProjectService.
     * 
     * @param id                the id of the current resident to be deactivated
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
     * @param id                the id of the current resident to be activated
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
         * @param id                        the id of the current project
         * @param capacity                the new capacity of the resident, number of operation per month
         * @param duration                the new training duration of the resident in months
         * @param firstName                the new firstName
         * @param name                        the new name
         * @param title                        the new title
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
                List<OpCatalogue> catalogues = opCatalogueService.getAllForSpecialty(specialtyId);//Anamika 
            //Map<Integer, List<OpCatalogue>> catalogues = opCatalogueService.getAllForSpecialty(specialtyId);
                
                //Retrieve all Catalogue according to the Training System Added by Anamika
                
            List<String> TrainSysNameCatalogue = trSystemService.getTrainSystemNameForCatalogue();
                //List<TrainingSystem> TrainSysNameCatalogue = trSystemService.getTrainSystemNameForCatalogue();
            List<Integer> TrainSysIDCatalogue = trSystemService.getTrainSystemIDForCatalogue(TrainSysNameCatalogue);
            //System.out.println(TrainSysNameCatalogue);
            Map<Integer, List<OpCatalogue>> catalogueByTrainSystem = trSystemService.getCatalogueInfoByTrainSys(specialtyId);
                // Attach catalogues by TrainSystem to the Model 
                model.addAttribute("opCataloguesByTrain_ID", catalogueByTrainSystem);
                
                //Attach Train System Name to the Model 
                model.addAttribute("trainSysName", TrainSysNameCatalogue);
                model.addAttribute("trainSysID", TrainSysIDCatalogue);
                
                // This will resolve to /WEB-INF/jsp/admin/Catalogues.jsp
                return "admin/Catalogues";
        }
    
    /**
     * Edits an existing block size of a catalogue by delegating the processing to OpCatalogueService.
     *         
         * @param id                the id of the current catalogue to be modified
         * @param newBlockSize                the new value for the block size
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
         * @param id                the id of the current catalogue to be modified
         * @param newMonthlyCapacity                the new value for the block size
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
     * @param id                the id of the current catalogue to be deleted
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
     *  a new catalog by delegating the processing to OpCatalogService.
     * 
            * @param name                the name of the catalogue to be added
         * @param description                the description of the catalogue to be added
         * @param specialTrunk                true if the catalogue to be added is from the special trunk
         * @param easy                 the value of level1OpNo of the catalogue to be added
         * @param normal                the value of level2OpNo of the catalogue to be added
         * @param hard                the value of level3OpNo of the catalogue to be added
     */
    @RequestMapping(value = "/administration/catalogues/add", method = RequestMethod.POST)
    public String add ( @CookieValue(value="selectedSpeciality", defaultValue="") String cookie, 
                                            @RequestParam(value="name", required=true) String name,
                                            @RequestParam(value="description", required=true) String description,
                                            @RequestParam(value="specialTrunk", required=true) Boolean specialTrunk,
                                            @RequestParam(value="easy", required=true) Integer easy,
                                            @RequestParam(value="normal", required=true) Integer normal,
                                            @RequestParam(value="hard", required=true) Integer hard,
                                            @RequestParam(value="blockSize", required=true) Integer blockSize,
                                            @RequestParam(value="capacity", required=true) Integer capacity,
                                            @RequestParam(value="id", required=true)Integer id) {            
                logger.debug("Received request to add new catalog");
                
                //load the specialty id from the cookie 
            int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
            System.out.println(id);
            // We assign the input fields
            OpCatalogue opCatalogue = new OpCatalogue();
            opCatalogue.setName(name);
            opCatalogue.setDescription(description);
            opCatalogue.setSpecialTrunk(specialTrunk);
            opCatalogue.setLeve1OpNo(easy);
            opCatalogue.setLeve2OpNo(normal);
            opCatalogue.setLeve3OpNo(hard);
            opCatalogue.setBlockSize(blockSize);
            opCatalogue.setMonthlyCapacity(capacity);
            opCatalogue.setSpecialtyID(specialtyId);
            opCatalogue.setTrainSystemID(id);
                
                // Call OpCatalogueService to do the actual add
                opCatalogueService.add(opCatalogue);
                
                // This will redirect to /WEB-INF/jsp/admin/Catalogues.jsp
                return "redirect:../catalogues";
        }
    /**
     * Add a new training system by delegating the processing to TrainingSystemService.
     * 
            * @param trainSysName                the name of the training system to be added
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
         * @param id                the id of the current project to be modified
         * @param untilDate                the Date until the project is on vacation
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
            //Sakib on 13 march
            //List<UserInfo> userDetail = usrMngmentCRUDServiceIntrface.getAllUsers(currentUser);
            List<UserInfo> userDetail = usrMngmentCRUDServiceIntrface.getAllAdminsAndInstructors(currentUser);
            
            List<Specialty> specialityID = specService.getAll();
            
            
            List<TrainingSystem> trainSystems = trSystemService.getAllTrainSystem();
            model.addAttribute("trainSystems", trainSystems); 
            //Attach specialities to the Model 
            model.addAttribute("specIality", specialityID);
            // Attach Users to the Model
            model.addAttribute("userDetail", userDetail);
            
            return "admin/UsrMangment";
    }
    
    
    /**
     * Delete an existing User 
     * 
     * @param id                the id of the current resident to be deleted
     */
    @RequestMapping(value = "/administration/crud/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value="id", required=true) Integer id) {   
                logger.debug("Received request to deleting existing user");
                
                usrMngmentCRUDServiceIntrface.deleteUsers(id);
                // This will redirect to /WEB-INF/jsp/admin/crud.jsp
                return "redirect:../crud";
        }
    
    
    /**
         * User Registration Form
         * Insert into User Table as well as User_Roles Table
         * @param username
         * @param password
         * @param user_role
         * @return Redirect to login
         */
        @RequestMapping(value = "/administration/crud/add", method = RequestMethod.POST)
        public String getNewUser(
                        @RequestParam(value="username", required=true) String username,
                        @RequestParam(value="password", required=true) String password,
                        @RequestParam(value="user_role", required=true) String user_role,
                        @RequestParam(value="specialityID", required=true)Integer specialityID,
                        @RequestParam(value="trainSysId", required=true)Integer trainSysId,
                        @RequestParam(value="emailAdd", required=true,defaultValue="") final String emailID
                        ) {
                logger.debug("Received request for registration");
                
                System.out.println("SpecialityId"+specialityID);
                //Add a new User
                User user = new User();
                user.setActive(true); //sets false on registration;Updates on first login
                user.setUsername(username);
                user.setPassword(password);
                user.setSpecialityID(specialityID);
                user.setTrainingSystemID(trainSysId);
                user.setEmailID(emailID);
                user.setRegular(0);//added later
                userRgistrationService.addUser(user);
                
                Integer userNewId = user.getId();
                //Add User Roles
                UserRole user_Role = new UserRole();
                user_Role.setRole(user_role);
                user_Role.setUser(user);
                userRgistrationService.addUserRole(user_Role);
                
                
                //Create a simple Email Object
                SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(emailID);
                email.setSubject("Welcome TO MRI");
                email.setText("Welcome User....You are now Registered.Thank you for your Consideration");
                
                //sends the email
                //mailSender.send(email);
                //////
                mailSender.send(new MimeMessagePreparator() {

                	@Override
                	public void prepare(MimeMessage mimeMessage) throws Exception {
                	MimeMessageHelper messageHelper = new MimeMessageHelper(
                	mimeMessage, true, "UTF-8");
                	messageHelper.setTo(emailID);
                	messageHelper.setSubject("Welcome TO MRI");
                	messageHelper.setText("Welcome User....You are now Registered.Thank you for your Consideration");
                	}

                	});
                
                
                
                ///////
                // This will resolve to /WEB-INF/jsp/users/logoutSuccess.jsp
                return "redirect:../crud";
        }
    
    
    /**
     * Updating an existing User 
     * 
     * @param id                the id of the current resident to be updated
     */
    @RequestMapping(value = "/administration/crud/updateUserInformation", method = RequestMethod.POST)
    public String updateUser(@RequestParam(value="id", required=true) Integer id,
                                                     @RequestParam(value="password" , required=true) String password,
                                                     @RequestParam(value="activity") Boolean activity,
                                                     @RequestParam(value="user_role") String user_role
                    ) {   
                logger.debug("Received request to updating existing user");
                
                //Find User by id
                User user = usrMngmentCRUDServiceIntrface.get(id);
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
     * Updating an existing User 
     * 
     * @param id                the id of the current resident to be updated
     */
    @RequestMapping(value = "/administration/crud/updatePassword", method = RequestMethod.POST)
    public String updateUser(@RequestParam(value="id", required=true) Integer id,
    						 @RequestParam(value="fromPage", required=true) String fromPage,
                             @RequestParam(value="curr_password" ) String currPass,
                             @RequestParam(value="newPassword" , required=true) String password) {   
                logger.debug("Received request to updating existing user");   
                
                System.out.println("frompage : "+fromPage);
                System.out.println("id : "+id);
                User user;
                if(fromPage.equals("residentProgress")) {
                	// load the associated project
                    Project project = projectService.get(id);
                    
                    // load the person
                    Integer personID = project.getPersID();
                    Person person = personService.get(personID);
                    user = usrMngmentCRUDServiceIntrface.getUserFromUsername(person.getUsername());
                } else {
                	//Find User by id
                    user = usrMngmentCRUDServiceIntrface.get(id);
                }

                user.setPassword(password);       
                
                //Update User
                usrMngmentCRUDServiceIntrface.updateUsers(user);
                // This will redirect to /WEB-INF/jsp/admin/crud.jsp
                if(fromPage.equals("residentProgress")) {
                	return "redirect:../progress";
                }
                
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
     * @param psValue                the pscode to be checked
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
     * @param psValue                the pscode to be updated / inserted
     * @param clValue                the OpCatalgue to be mapped with
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
    /**
     * Check Existing User Name
     * @param userName
     * @return
     */
    @RequestMapping(value = "/administration/crud/checkUser", method = RequestMethod.POST)
    public @ResponseBody String checkExistingUser(String usrNameValue) { 	
    	String exists = usrMngmentCRUDServiceIntrface.getIdFromUserName(usrNameValue);
    	//System.out.println("Existing"+ exists);
    	return exists;	
    }
    
    /**
     * Check Existing Password for new Password
     * @param newPassValue
     * @param userName
     * @return
     */
    @RequestMapping(value = "/administration/crud/checkNewPassword", method = RequestMethod.POST)
    public @ResponseBody String checkNewPassword(String newPassValue, String userNameValue) { 	
    	String matches = usrMngmentCRUDServiceIntrface.passwordMapping(newPassValue, userNameValue);
    	System.out.println("Matches"+ matches);
    	return matches;	
    }
    /**
	 * Check current password is same with given password by delegating to check password service
	 * @return true/false
	 */
	@RequestMapping(value = "/administration/crud/checkCurrentPassWithUserName", method = RequestMethod.POST)
	public @ResponseBody String checkCurrentPassword(String currPassValue, String upid, String pageType){
		// Retrieve current user activity ;first login activitiy =false otherwise true
		System.out.println("Inside java" + currPassValue + " " + upid + " " + pageType);
		String res = null;
		User user;
        if(pageType.equals("residentProgress")) {
        	// load the associated project
            Project project = projectService.get(Integer.parseInt(upid));
            
            // load the person
            Integer personID = project.getPersID();
            Person person = personService.get(personID);
            user = usrMngmentCRUDServiceIntrface.getUserFromUsername(person.getUsername());
        } else {
        	//Find User by id
            user = usrMngmentCRUDServiceIntrface.get(Integer.parseInt(upid));
        }
		res = usrMngmentCRUDServiceIntrface.checkCurrentPassword(currPassValue, user.getUsername());
		//System.out.println("Result: "+res);
		return res;
	}
    /**
     * Get the current user information from context
     * @return username
     */
    public static String getSessionUser() {
 	    String userName = null;
 	    SecurityContext securityContext = SecurityContextHolder.getContext();
 	    if(securityContext != null) {
 	        Authentication authentication = securityContext.getAuthentication();
 	        if(authentication != null) {
 	            String authenticationName = authentication.getName();
 	            if(authenticationName != null) {
 	                userName = authenticationName;
 	            }
 	        }
 	    }

 	    return userName;
 	}

}