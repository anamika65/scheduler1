package de.scheduler.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.Person;
import de.scheduler.model.Project;
import de.scheduler.model.User;
import de.scheduler.model.UserRole;
import de.scheduler.util.SpecialtySelector;

@Service("userRegistrationService")
@Transactional
public class UserRegistrationService {
		
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	 @Resource(name="specialtyLoader")
     private SpecialtyLoader specialtyLoader;
	 
	 @Resource(name="operationBlockGeneratorService")
     private OperationBlockGenerator operationBlockGeneratorService;
	 
	 @Resource(name="projectService")
     private ProjectService projectService;
	 
	 @Resource(name="personService")
     private PersonService personService;
	 
	 @Resource(name="opCatalogueService")
     private OpCatalogueService opCatalogueService;
	
	protected static Logger logger = Logger.getLogger("service");
	
	public static String CHECK_USERNAME_FOR_NEW = "SELECT count(*) as countUsrId "+
												  "FROM user "+
												   "WHERE username = :usrName";
			                                       
	
	/**
	 * Save User to user Table scheduler_db
	 */
	public void addUser(User user)
	{
		logger.debug("Adding new person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		//save
		session.save(user);
	}
	
	/**
	 * Save User Role to user_roles Table scheduler_db
	 */
	public void addUserRole(UserRole user_Role){
		
		// Retrieve session from Hibernate
				Session session = sessionFactory.getCurrentSession();
				
				//save
				session.save(user_Role);
	}
	

	/**
     * Adds a new person by delegating the processing to PersonService.
     * Adds a new project by delegating the processing to ProjectService.
     * Adds a new dummy opblock and opblocks for all catalgues by delegating the processing to OperationBlockGenerator.
     * 
     * @return  void
     */
	/*
    public String addPersonProject(String cookieSpecialityId,
    				  String title,
    				  String name, 
    				  String firstName,
    				  String nickname, 
    				  String function, 
    				  Date startDate,
    				  Integer duration,
                      Integer capacity,
                      Integer userNewId) {            
                logger.debug("Received request to add new person");
                
                //load the specialty id from the cookie 
            int specialtyId = SpecialtySelector.getSpecialtyId(cookieSpecialityId, specialtyLoader.getFirstSpecialtyID());
            System.out.println("specialityID:"+ userNewId);
                
            if(opCatalogueService.isAddPersonAllowed(specialtyId)) {
                    Person person = new Person();
                    person.setFirstName(firstName);
                    person.setName(name);
                    person.setFunction(function);
                    person.setTitle(title);
                    person.setNickname(nickname);
                    person.setUserID(userNewId);
                    // Call PersonService to do the actual adding of a person
                    personService.add(person);
                    
                    System.out.println("person:"+ person);
                    
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
                    System.out.println("project:"+ project);
                    
                    Integer newProjectID = project.getProjectID();
                    
                    
                    //have to check Pending
                    //delegates the creation of DUMMY opBlock to OperationBlockGenerator
                    //operationBlockGeneratorService.generateDummyOpBlockForProject(newProjectID);
                    
                    //delegates the creation of NORMAL opBlocks to OperationBlockGenerator
                    //operationBlockGeneratorService.generateInitialOpBlocks(newProjectID, specialtyId);
            }
                return null;
        }*/
    
    /**
     * Check the Existing User name
     * 
     * @return String
     */
    @SuppressWarnings("unchecked")
      public Integer checkExistingUsr(String UsrName){
    	  
    	  logger.debug("Retrieving user");
  		
  		// Retrieve session from Hibernate
  		Session session = sessionFactory.getCurrentSession();
  		
  		// Create a Hibernate query
  		Query query = session.createSQLQuery(CHECK_USERNAME_FOR_NEW)
  									.addScalar("countUsrId", Hibernate.STRING)
  									.setParameter("usrName", UsrName);
  		List<String> userNameList = query.list();
  		Integer usrCnt = Integer.parseInt(userNameList.get(0));
  		return usrCnt;
      }
}
