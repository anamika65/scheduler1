package de.scheduler.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Specialty;

/**
 * Service for processing Users
 * 
 */
@Service("specialtyService")
@Transactional
public class SpecialtyService {

	protected static Logger logger = Logger.getLogger("service");
	
	public static String SELECT_SPECIALITY_ID = "SELECT "+ "specialties.Name  as specialityName FROM "+ "user, specialties "+"WHERE USERNAME = :username "+ "AND "+ "specialties.SpecialtyID = user.SpecialtyID";
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all Specialties
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<Specialty> getAll() {
		logger.debug("Retrieving all Specialties");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Specialty");

		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves a single specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a specialty
	 */
	public Specialty get( Integer id ) {
		logger.debug("Retrieving specialty by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing project first
		Specialty specialty = (Specialty) session.get(Specialty.class, id);
		
		return specialty;
	}
	/**
	 * Get the speciality for logged on user
	 * @param username
	 * 
	 * @return specialityID
	 */
	public String getByID(String username){
		String specIalityName = null;
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(SELECT_SPECIALITY_ID)
				.addScalar("specialityName", Hibernate.STRING)
				.setParameter("username", username);
		if(query.list().size()==1)
			specIalityName = (String) query.list().get(0);
		System.out.println("Speciality name: "+specIalityName);
		return specIalityName;
		
	}
	
}
