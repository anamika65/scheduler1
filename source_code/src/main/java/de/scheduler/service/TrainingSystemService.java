package de.scheduler.service;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import de.scheduler.model.TrainingSystem;

@Service("trSystemService")
@Transactional
public class TrainingSystemService {
protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Adds a new Training System
	 * 
	 * @param trSystem		the TrainingSystem
	 */
	public void addTrSystem(TrainingSystem trSystem) {
		logger.debug("Adding new opCatalogue");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(trSystem);
	}
	
}