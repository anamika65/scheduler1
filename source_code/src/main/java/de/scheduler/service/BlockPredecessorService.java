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

import de.scheduler.model.BlockPredecessor;

/**
 * Service for processing BlockPredecessors
 * 
 */
@Service("blockPredecessorsService")
@Transactional
public class BlockPredecessorService {

	protected static Logger logger = Logger.getLogger("blockPredecessors");
	public static String SELECT_OPBLOCK_BY_CATALOG = "SELECT OpBlockID FROM opblocks WHERE CatalogID = :catalogID";
	public static String DELETE_PRED_BY_CATALOG = "delete from blockpredecessors where OpBlockID = ANY ( "
			+ SELECT_OPBLOCK_BY_CATALOG
			+ " ) or PredecessorID = ANY ( "
			+ SELECT_OPBLOCK_BY_CATALOG + " )";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Retrieves all BlockPredecessors
	 * 
	 * @return 		a list of blocks
	 */
	@SuppressWarnings("unchecked")
	public List<BlockPredecessor> getAll() {
		logger.debug("Retrieving all block predecessors");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM BlockPredecessor");

		// Retrieve all
		return query.list();
	}

	/**
	 * Delete op block by catalog id.
	 * 
	 * @param catalogID		the catalog id
	 * 
	 * @return 		true, if successful
	 */
	public boolean deletePredecessorsByCatalogId(int catalogID) {
		logger.debug("Deleting all block predecessors for a catalog id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a SQL query
		Query deleteQuery = session.createSQLQuery(DELETE_PRED_BY_CATALOG)
				.setParameter("catalogID", Integer.valueOf(catalogID));
		
		int row = deleteQuery.executeUpdate();
		if (row < 0)
			return false;
		return true;
	}

	/**
	 * Performs a batch insert for the blockPredecessors that are given as input.
	 * 
	 * @param blockPredecessors		the predecessors
	 */
	public void performBatchInsert(List<BlockPredecessor> blockPredecessors) {
		if (blockPredecessors.size() == 0) 	return;
		
		logger.debug("Adding new blockPredecessors");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		int i = 1;
		for (BlockPredecessor o : blockPredecessors) {
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

}
