package de.scheduler.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Person;

/**
 * Service for processing Persons
 * 
 */
@Service("personService")
@Transactional
public class PersonService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private  SessionFactory sessionFactory;
	
	public static String GET_ALL_PERSONS_FOR_SPECIALTY =  " SELECT * " +
														  " FROM " +
																" personnel pers inner join project prj ON pers.PersID = prj.PersID" +
														  " WHERE prj.SpecialtyID = :specialtyID";

	public static String GET_ALL_ACTIVE_PERSONS_FOR_SPECIALTY =  " SELECT * " +
															  " FROM " +
																	" personnel pers inner join project prj ON pers.PersID = prj.PersID" +
															  " WHERE prj.SpecialtyID = :specialtyID" +
															  " AND prj.Active = 1";
	public static String SELECT_NICKNAME = " SELECT * " +
			  								" FROM " +
			  								" personnel " +
			  								" WHERE Nickname = :residentName";
	
	public static String GET_PERSON_FOR_USERNAME =  " SELECT * " +
			  " FROM " +
					" personnel " +
			  " WHERE Username = :userName";

	/**
	 * Retrieves all persons
	 * 
	 * @return 		a list of persons
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Person");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves all persons for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list of persons
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getAllForSpecialty(Integer specialtyID) {
		logger.debug("Retrieving all persons for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_ALL_PERSONS_FOR_SPECIALTY)
									.addEntity(Person.class)
									.setParameter("specialtyID", specialtyID);
		
		List<Person> personsForSpecialty = query.list();
		
		// Retrieve all
		return personsForSpecialty;
	}
	
	/**
	 * Retrieves all persons that have an active project assigned, for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list of persons
	 */
	@SuppressWarnings("unchecked")
	public List<Person> getAllActiveForSpecialty(Integer specialtyID) {
		logger.debug("Retrieving all persons that have an active project assigned, for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_ALL_ACTIVE_PERSONS_FOR_SPECIALTY)
									.addEntity(Person.class)
									.setParameter("specialtyID", specialtyID);
		
		List<Person> activePersonsForSpecialty = query.list();
		
		// Retrieve all
		return activePersonsForSpecialty;
	}

	/**
	 * Retrieves a single person
	 * 
	 * @param id		the person id
	 * 
	 * @return 		a person
	 */
	public Person get( Integer id ) {
		logger.debug("Retrieving person by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Person person = (Person) session.get(Person.class, id);
		
		return person;
	}

	/**
	 * Retrieves a single person
	 * 
	 * @param id		the user id
	 * 
	 * @return 		a person
	 */
	public Person getPersonForUserName( String uname ) {
		logger.debug("Retrieving person by user id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_PERSON_FOR_USERNAME)
											.addEntity(Person.class)
											.setParameter("userName", uname);
				
		List<Person> activePersonsForSpecialty = query.list();
		if (activePersonsForSpecialty.isEmpty()) return null;

		return activePersonsForSpecialty.get(0);
	}
	
	/**
	 * Adds a new person
	 * 
	 * @param person		the person to be added
	 */
	public void add(Person person) {
		logger.debug("Adding new person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(person);
	}
	
	/**
	 * Deletes an existing person
	 * 
	 * @param id 		the id of the person
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Person person = (Person) session.get(Person.class, id);
		
		// Delete 
		session.delete(person);
	}
	
	/**
	 * Edits an existing person
	 * 
	 * @param person the person that will be updated
	 */
	public void edit(Person person) {
		logger.debug("Editing existing person");
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Save updates
		session.update(person);
	}
	/**
	 * Check personnels(Resident) whether they are in import excel files.
	 * @param residentName
	 * 
	 */
	
	public String checkNickName(List<String> residentNames){
		logger.debug("Checking Resident's Nick Name");
		boolean isResident = true ;
		String residentNotFound = null;
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		System.out.println("------CheckNickName:");
		// Create a Hibernate query (HQL)
		// Print the name from the list....
        for(String rName : residentNames) {
        	Query query = session.createSQLQuery(SELECT_NICKNAME)
					.setParameter("residentName",rName);
        	if(query.list().size()>0){
        		residentNotFound = "";
    		}
        	else {
        		residentNotFound = rName ;
            			break;
        	}
        }
		
		
		 return residentNotFound;
		
	}


}
