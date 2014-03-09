package de.scheduler.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.OpBlock;
import de.scheduler.util.OpBlockType;

/**
 * Service for processing Op Blocks
 */
@Service("opBlockService")
@Transactional
public class OpBlockService {

	protected static Logger logger = Logger.getLogger("opBlockService");
	public static String DELETE_OPBLOCK_BY_CATALOG = " DELETE " +
												 " FROM " +
												 	" opblocks " +
												 " WHERE " +
												 	" CatalogID = :catalogID ";
	public static String SELECT_ALL_OPBLOCK_ACTIVE_PROJECTS_FOR_SPECIALTY = " SELECT " +
													" opb.OpBlockID " +
													", opb.CatalogID " +
													", opb.ProjID " +
													", opb.DifficultyLevel " +
													", opb.Type " +
													", opb.DefaultSize " +
													", opb.ActualSize " +
													", opb.EarliestStartDate " +
													", opb.LatestStartDate " +
												" FROM " +
													" opblocks opb inner join project prj ON opb.ProjID = prj.ProjID" +
												" WHERE " +
													" (prj.active = 1 " +
													" or (prj.active = 0 " +
													" and prj.DeactivatedUntil is not null)) " +
													" and opb.DefaultSize <> ActualSize " +
													" and prj.SpecialtyID = :specialtyID";
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all BlockPredecessors
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<OpBlock> getAll() {
		logger.debug("Retrieving all opblocks");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM OpBlock");

		// Retrieve all
		return query.list();
	}

	/**
	 * Retrieves all operations blocks that are not finished yet, for a specialty
	 * i.e. and for which the residents are active: DefaultSize != ActualSize
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<OpBlock> getIncompleteOpBlocksForSpecialty(Integer specialtyID) {
		logger.debug("Retrieving all incomplete opblocks");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query query = session.createSQLQuery(SELECT_ALL_OPBLOCK_ACTIVE_PROJECTS_FOR_SPECIALTY)
				.addEntity(OpBlock.class)
				.setParameter("specialtyID", specialtyID);
		
		// Retrieve all
		return query.list();
	}

	/**
	 * Delete opblock by catalog id.
	 * 
	 * @param catalogID		the catalog id
	 * 
	 * @return 		true, if successful
	 */
	public boolean deleteOpBlockByCatalogId(int catalogID) {
		logger.debug("Deleting all opblocks by catalog id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query deleteQuery = session.createSQLQuery(DELETE_OPBLOCK_BY_CATALOG)
				.setParameter("catalogID", Integer.valueOf(catalogID));
		
		int row = deleteQuery.executeUpdate();
		if (row < 0)
			return false;
		return true;
	}

	/**
	 * Performs a batch insert for the opBlocks that are given as input.
	 * 
	 * @param opBlocks		the opblocks
	 */
	public void performBatchInsert(List<OpBlock> opBlocks) {
		if (opBlocks.size() == 0) return;
		logger.debug("Adding new opBlocks");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		int i = 1;
		for (OpBlock o : opBlocks) {
			session.save(o);
			if (i % 20 == 0) { // 20, same as the JDBC batch size
				// flush a batch of inserts and release memory:
				session.flush();
				session.clear();
			}
			i++;
		}
		tx.commit();
		session.close();
	}

	/**
	 * Gets the OpBlock identified by Project id.
	 * 
	 * @param projectID 		the project id
	 * @param blockType 		the block type
	 * 
	 * @return		 the dummy operation by project id
	 */
	@SuppressWarnings("unchecked")
	public OpBlock getOperationByProjID(Integer projectID, OpBlockType blockType) {
		logger.debug("Getting the opBlocks identified by project id");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		System.out.println("Project ID:"+projectID);
		// Create a query (HQL)
		Query query = session
				.createQuery("FROM  OpBlock WHERE ProjID = :projectID AND Type like :type");
		query.setParameter("projectID", projectID);
		query.setParameter("type", "%" + blockType + "%");		
		query.setMaxResults(1);
		
		List<OpBlock> res = query.list();
		if (res.size() == 1) {
			return res.get(0);
		} else
			return null;
	}

	/**
	 * Updates the actual size of opblocks for the residents that had operations just imported
	 * 
	 * @param startID 		the operation id from which we will compute
	 * @param endID 		the operation id to which we will compute
	 */
	@SuppressWarnings("unchecked")
	public void updateOpBlocksSize(Integer startID, Integer endID) {
		logger.debug("Updating the opBlocks with the imported information");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query
		Query updateOpBlockSize = session.createSQLQuery("call updateOpBlockActualSize(:startID, :endID);")
						.setParameter("startID", startID)
						.setParameter("endID", endID);

		updateOpBlockSize.executeUpdate();		
	}
	
	/**
	 * Fills in the actual size of opblocks for the residents, after confuguring the block size of a catalog
	 * 
	 * @param catalogID 		the catalog id for which the opblocks were regenerated
	 */
	@SuppressWarnings("unchecked")
	public void fillInOpBlocksSize(Integer catalogID) {
		logger.debug("Filling in the opBlocks with the number of performed operations");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query
		Query updateOpBlockSize = session.createSQLQuery("call fillInOpBlockActualSize(:catalogID);")
						.setParameter("catalogID", catalogID);

		updateOpBlockSize.executeUpdate();		
	}
	
	/**
	 * Deletes the decision support operations for the residents that just had those operations imported
	 * 
	 * @param startID 		the operation id from which we will compute
	 * @param endID 		the operation id to which we will compute
	 */
	@SuppressWarnings("unchecked")
	public void deleteDSuppOperationsAfterImport(Integer startID, Integer endID) {
		logger.debug("Deleting the decision support operations that are the same as the operations imported");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query
		Query deleteDSuppOp = session.createSQLQuery("call deleteDSuppOperationsAfterImport(:startID, :endID);")
						.setParameter("startID", startID)
						.setParameter("endID", endID);

		deleteDSuppOp.executeUpdate();		
	}
}
