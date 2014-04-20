/**
 * 
 */
package de.scheduler.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpBlock;
import de.scheduler.model.Project;
import de.scheduler.model.SurgeryType;
import de.scheduler.model.TrainingRequirements;

/**
 * @author AnamikaChowdhury
 *
 */

@Service("scheduleService")
@Transactional
public class ScheduleService {
	
	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	private Integer noResidents = 8;
	
	private Integer surgeryTypes = 14;
	
	private Integer planningHorizon = 20;
	
	private Integer noModes = 3;
	
	private Integer[] periodLength = new Integer[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}; //period length in months
	
	private Integer[] modeRequirements = new Integer[]{50, 50};
	
	
	/**
	 * 
	 * @return Map of Project and List of Operation Blocks
	 */
	public Map<Project, List<OpBlock>> generateScheduleNew(Integer specialtyID) {
		logger.debug("Retrieving all Surgerytypes");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM SurgeryType");
		
		List<SurgeryType> surgeryTypeAll = query.list(); // All Surgery Types
		
		System.out.println("Surgerytype table size: "+query.list().size());
		
		// Create a Hibernate query (HQL)
		Query query1 = session.createQuery("FROM TrainingRequirements");
		
		List<TrainingRequirements> trainingRequirements = query1.list();
		
		System.out.println("Trainning Requirement table size: "+query1.list().size());
				
		return null;
		
	}
	
}
