package de.scheduler.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.Specialty;

/**
 * Service for processing Users
 * 
 */
@Service("specialtyService")
@Transactional
public class SpecialtyService {

	protected static Logger logger = Logger.getLogger("service");
	
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
}
