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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpCatalogue;

/**
 * Service for processing OpCatalogues
 * 
 */
@Service("opCatalogueService")
@Transactional
public class OpCatalogueService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	public static String GET_ALL_CATALOGUES_FOR_SPECIALTY = " SELECT * " +
														  " FROM opcatalogues" +
														  " WHERE SpecialtyID = :specialtyID"  +
														  " ORDER BY opcatalogues.Name ASC";
	
	public static String GET_ALLOW_DELETE = " SELECT count(*) as allowed" +
											" FROM opblocks" +
											" WHERE CatalogID = :catalogID";
	
	public static String ALLOW_ADD_PERSON = " SELECT count(*) as catalogNr" +
											" FROM opcatalogues" +
											" WHERE SpecialtyID = :sprecialtyID and BlockSize > 0";
	
	/**
	 * Retrieves all OpCatalogues
	 * 
	 * @return 		a list
	 */
	public List<OpCatalogue> getAll() {
		logger.debug("Retrieving all opcatalogues");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM OpCatalogue");
		
		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves all OpCatalogues for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list
	 */
	public List<OpCatalogue> getAllForSpecialty(Integer specialtyID) {
		
		logger.debug("Retrieving all opcatalogues for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createSQLQuery(GET_ALL_CATALOGUES_FOR_SPECIALTY)
									.addEntity(OpCatalogue.class)
									.setParameter("specialtyID", specialtyID);
		
		List<OpCatalogue> cataloguesForSpecialty = query.list();
		for (OpCatalogue opCat : cataloguesForSpecialty) {
			this.setAllowDelete(opCat);
		}
		
		// Retrieve all
		return cataloguesForSpecialty;
	}
	
	/**
	 * Retrieves all OpCatalogues for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a map
	 */
	public Map<Integer, OpCatalogue> getCataloguesForMapping(Integer specialtyID) {
		logger.debug("Retrieving all opcatalogues for specialty, mapped");
		
		Map<Integer, OpCatalogue> myCataloguesMap = new HashMap<Integer, OpCatalogue>();
		
		List<OpCatalogue> allCatalogues = this.getAllForSpecialty(specialtyID);
		
		for (OpCatalogue opCat : allCatalogues) {
			myCataloguesMap.put(opCat.getCatalogueID(), opCat);
		}
		
		// Retrieve all
		return myCataloguesMap;
	}
	
	/**
	 * Retrieves a single opCatalogue
	 * 
	 * @param id		the catalogue id
	 * 
	 * @return 		the catalogue
	 */
	public OpCatalogue get( Integer id ) {
		logger.debug("Retrieving a single opcatalogue");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing opCatalogue first
		OpCatalogue opCatalogue = (OpCatalogue) session.get(OpCatalogue.class, id);
		
		return opCatalogue;
	}
	
	/**
	 * Adds a new opCatalogue
	 * 
	 * @param opCatalogue		the catalogue
	 */
	public void add(OpCatalogue opCatalogue) {
		logger.debug("Adding new opCatalogue");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(opCatalogue);
	}
	
	/**
	 * Deletes an existing opCatalogue
	 * 
	 * @param id		the catalogue id
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing opCatalogue");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing opCatalogue first
		OpCatalogue opCatalogue = (OpCatalogue) session.get(OpCatalogue.class, id);
		
		// Delete 
		session.delete(opCatalogue);
	}
	
	/**
	 * Edits an existing OpCatalogue
	 * 
	 * @param opCatalogue		the catalogue to be edited
	 */
	public void edit(OpCatalogue opCatalogue) {
		logger.debug("Editing existing opCatalogue");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing opCatalogue via id
		OpCatalogue existingOpCatalogue = (OpCatalogue) session.get(OpCatalogue.class, opCatalogue.getCatalogueID());
		
		// Assign updated values to this opCatalogue
		existingOpCatalogue.setName(opCatalogue.getName());
		existingOpCatalogue.setDescription(opCatalogue.getDescription());
		existingOpCatalogue.setSpecialTrunk(opCatalogue.getSpecialTrunk());
		existingOpCatalogue.setLeve1OpNo(opCatalogue.getLeve1OpNo());
		existingOpCatalogue.setLeve2OpNo(opCatalogue.getLeve2OpNo());
		existingOpCatalogue.setLeve3OpNo(opCatalogue.getLeve3OpNo());

		// Save updates
		session.save(existingOpCatalogue);
	}
	
	/**
	 * Edits blockSize of an existing OpCatalogue
	 * 
	 * @param opCatalogue		the catalogue
	 */
	public void editBlockSize(OpCatalogue opCatalogue) {
		logger.debug("Editing blockSize of an existing opCatalogue");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing opCatalogue via id
		OpCatalogue existingOpCatalogue = (OpCatalogue) session.get(OpCatalogue.class, opCatalogue.getCatalogueID());
		
		// Assign updated blockSize to this opCatalogue
		existingOpCatalogue.setBlockSize(opCatalogue.getBlockSize());

		// Save updates
		session.save(existingOpCatalogue);
	}
	
	/**
	 * Edits monthly capacity of an existing OpCatalogue
	 * 
	 * @param opCatalogue		the catalogue
	 */
	public void editMonthlyCapacity(OpCatalogue opCatalogue) {
		logger.debug("Editing monthly capacity of an existing opCatalogue");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing opCatalogue via id
		OpCatalogue existingOpCatalogue = (OpCatalogue) session.get(OpCatalogue.class, opCatalogue.getCatalogueID());
		
		// Assign updated blockSize to this opCatalogue
		existingOpCatalogue.setMonthlyCapacity(opCatalogue.getMonthlyCapacity());

		// Save updates
		session.save(existingOpCatalogue);
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
		List <Integer> result = queryAllowDelete.list();
		if (result.size() > 0 && result.get(0) > 0) {
			opCatalogue.setAllowDelete(false);
		} else {
			opCatalogue.setAllowDelete(true);
		}
	}
	
	/**
	 * Checks if a person can be added, when there exist a catalog with a size > 0.
	 *
	 * @param specialtyID the specialty id
	 * @return true, if the person can be added
	 */
	public boolean isAddPersonAllowed(Integer specialtyID) {
		logger.debug("isAddPersonAllowed");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing opCatalogue via id
		Query allowAddPerson = session.createSQLQuery(ALLOW_ADD_PERSON)
				.addScalar("catalogNr", Hibernate.INTEGER)
				.setParameter("sprecialtyID", specialtyID);
		List <Integer> result = allowAddPerson.list();
		if (result.size() > 0 && result.get(0) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
