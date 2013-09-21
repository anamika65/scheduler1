package de.scheduler.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.User;
import de.scheduler.model.UserRole;

@Service("userRegistrationService")
@Transactional
public class UserRegistrationService {
		
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	protected static Logger logger = Logger.getLogger("service");
	
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
}
