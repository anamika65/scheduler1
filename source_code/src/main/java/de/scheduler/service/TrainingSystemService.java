package de.scheduler.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpCatalogue;
import de.scheduler.model.TrainingSystem;

@Service("trSystemService")
@Transactional
public class TrainingSystemService {
protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public static String GET_ALLOW_DELETE = " SELECT count(*) as allowed" +
			" FROM opblocks" +
			" WHERE CatalogID = :catalogID";

	public static String GET_ALL_TRAINING_SYSTEM = " SELECT *" + 
                                                " FROM training_systems ts";
	
	public static String GET_ALL_TRAIN_SYSTEM = " SELECT ts.train_system_id as trainID" + 
            									" FROM training_systems ts";
	
	public static String GET_ALL_TRAIN_SYSTEM_NAME = " SELECT  distinct train_system_name" + 
            									" FROM training_systems";
	
	public static String SELECT_CATALOG_FOR_TRAINSYSTEM = " SELECT * " +
                                                          " FROM opcatalogues" +
                                                          " WHERE SpecialtyID = :specialtyID" + " AND TrainSystemID = :train_Sys"  +
                                                          " ORDER BY opcatalogues.Name ASC";
	public static String GET_ALL_TRAIN_SYSTEM_ID = " SELECT distinct train_system_id as trID" + 
													" FROM training_systems" + 
													" WHERE train_system_name = :trName " ;
	
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
	
	/**
	 * 
	 * @param specialtyID
	 * @return Map of list of Operation according to Training System
	 */
	public Map<Integer, List<OpCatalogue>> getCatalogueInfoByTrainSys(Integer specialtyID){
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query
		Query query1=session.createSQLQuery(GET_ALL_TRAIN_SYSTEM).addScalar("trainID",Hibernate.INTEGER);
		@SuppressWarnings("unchecked")
		List<Integer> train_id = query1.list();
		Map<Integer, List<OpCatalogue>> OpCatalogueByTrainSys = new HashMap<Integer, List<OpCatalogue>>(); 
		for(Integer trSys : train_id){
			Query query = session.createSQLQuery(SELECT_CATALOG_FOR_TRAINSYSTEM)
					.addEntity(OpCatalogue.class)
					.setParameter("specialtyID", specialtyID)
					.setParameter("train_Sys", trSys);			
			        @SuppressWarnings("unchecked")
					List<OpCatalogue> cataloguesForSpecialty = query.list();
			        	for (OpCatalogue opCat : cataloguesForSpecialty) {
			        		this.setAllowDelete(opCat);
                        }
			        	OpCatalogueByTrainSys.put(trSys, cataloguesForSpecialty);
			       	
		}
		
		logger.debug("OpCatalogueByTrainSys");
		// Retrieve all
		//return cataloguesForSpecialty;
		return OpCatalogueByTrainSys;
		
	}

	/**
	 * 
	 * @return List of Training System Name
	 */
	public List<String> getTrainSystemNameForCatalogue(){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query
		Query query1=session.createSQLQuery(GET_ALL_TRAIN_SYSTEM_NAME);
				@SuppressWarnings("unchecked")
				List<String> train_Sys_name = query1.list();
	
	return train_Sys_name;	
	}

	/**
	 * 
	 * @return List of Training System Name
	 */
	public List<TrainingSystem> getAllTrainSystem(){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM TrainingSystem");

		// Retrieve all
		return query.list();	
	}
	/**
	 * 
	 * @return List of Training System Name
	 */
	public List<Integer> getTrainSystemIDForCatalogue(List<String> trSysName){
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		List<Integer> train_Sys_ID = new ArrayList<Integer>();
		// Create a Hibernate query
		for(String trName: trSysName){
		Query query1=session.createSQLQuery(GET_ALL_TRAIN_SYSTEM_ID)
				.addScalar("trID",Hibernate.INTEGER)
				.setParameter("trName", trName)
				;
		Integer tId = new Integer((Integer) query1.list().get(0));
			 //tId = (Integer) query1.list().get(0);
				train_Sys_ID.add(tId);
				System.out.println(tId);
		}
	return train_Sys_ID;	
	}
	/**
	 * Sets if a catalogue can be deleted or not
	 * 
	 * @param opCatalogue		the catalogue
	 */
	public void setAllowDelete(OpCatalogue opCatalogue) {
		logger.debug("Set catalog allow delete field");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing opCatalogue via id
		Query queryAllowDelete = session.createSQLQuery(GET_ALLOW_DELETE)
				.addScalar("allowed", Hibernate.INTEGER)
				.setParameter("catalogID", opCatalogue.getCatalogueID());
		@SuppressWarnings("unchecked")
		List <Integer> result = queryAllowDelete.list();
		if (result.size() > 0 && result.get(0) > 0) {
			opCatalogue.setAllowDelete(false);
		} else {
			opCatalogue.setAllowDelete(true);
		}
	}
	
	
	
}