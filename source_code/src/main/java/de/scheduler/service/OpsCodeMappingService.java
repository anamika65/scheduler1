package de.scheduler.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpCatalogue;
import de.scheduler.model.PsCode;

@Service("opsCodeMappingService")
@Transactional
public class OpsCodeMappingService implements OpsCodeMappingServiceInterface {
	protected static Logger logger = Logger.getLogger("OpsCode Mapping Service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public static String GET_ALL_CATALOGUE = " SELECT * " +
											  " FROM opcatalogues" +
											  " ORDER BY opcatalogues.Name ASC";
	
	public static String GET_FILTERED_CATALOGUE = " SELECT * " +
			  										" FROM opcatalogues" +
			  										" WHERE CatalogID != 4" +
			  										" ORDER BY opcatalogues.Name ASC";
	
	public static String GET_CATALOGUE_FOR_PSCODE = " SELECT CatalogID " +
													" FROM pscodes" +
													" WHERE PSCode = :psCode";
	
	public static String UPDATE_CATALOGUE_FOR_PSCODE = " UPDATE pscodes " +
													" SET CatalogID = :catalogueId" +
													" WHERE PSCode = :psCode";

	/**
	 * Retrieves all OpCatalogues
	 * 
	 * @return 		a list
	 */
	public List<OpCatalogue> getAllOpCatalogue() {
		logger.debug("Retrieving all opcatalogue for mapping with pscode");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createSQLQuery(GET_ALL_CATALOGUE)
									.addEntity(OpCatalogue.class);
		
		List<OpCatalogue> catalogues = query.list();
		
		// Retrieve all
		return catalogues;
	}
	
	/**
	 * Retrieves filtered OpCatalogues without the difficulty
	 * 
	 * @return 		a list
	 */
	public List<OpCatalogue> getFilteredOpCatalogue() {
		logger.debug("Retrieving filterd opcatalogue  without the 'difficulty'");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createSQLQuery(GET_FILTERED_CATALOGUE)
									.addEntity(OpCatalogue.class);
		
		List<OpCatalogue> catalogues = query.list();
		
		// Retrieve all
		return catalogues;
	}
	
	/**
	 * Retrieves OpCatalogue for a single pscode
	 * 
	 * @return 		a OpCatalogueId (an Integer)
	 */
	@SuppressWarnings("unchecked")
	public Integer getOpCatalogueIdForPsCode( String psCode ) {
		logger.debug("Retrieving opcatalogue for pscode");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createSQLQuery(GET_CATALOGUE_FOR_PSCODE)
									.addScalar("CatalogID", Hibernate.STRING)
									.setParameter("psCode", psCode);
		
		List<String> cataloguesForPscode = query.list();
		
		if(cataloguesForPscode.isEmpty()) return null;
		Integer ctlgId = Integer.parseInt(cataloguesForPscode.get(0));
		return ctlgId;

	}
	
	/**
	 * Update OpCatalogue for a single pscode
	 * 
	 * @return 		Boolean value indicating success or failure
	 */
	public Boolean updateOpCatalogueForPsCode( String psCode , String opCatalogueId ) {
		logger.debug("Updating opcatalogue for pscode");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createSQLQuery(UPDATE_CATALOGUE_FOR_PSCODE)
									.setParameter("catalogueId", opCatalogueId)
									.setParameter("psCode", psCode);
		
		int success = query.executeUpdate();
		if (success < 0)
			return false;
		return true;
	}
	
	/**
	 * Insert OpCatalogue for a single pscode
	 * 
	 * @return 		Boolean value indicating success or failure
	 */
	public Boolean insertOpCatalogueForPsCode( String psCode , String opCatalogueId , String description ) {
		logger.debug("Inserting opcatalogue for pscode");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		PsCode psc = new PsCode();
		psc.setPsCode(psCode);
		psc.setCatalogueID(opCatalogueId);
		psc.setDescription(description);
		
		session.save(psc);
		
		return true;
	}
	
}
