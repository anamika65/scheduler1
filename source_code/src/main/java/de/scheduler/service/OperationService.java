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

import de.scheduler.model.Configuration;
import de.scheduler.model.DSupportOperation;
import de.scheduler.model.OpBlock;
import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Operation;
import de.scheduler.model.Project;

/**
 * Service for processing Operations
 * 
 */
@Service("operationService")
@Transactional
public class OperationService {
	protected static Logger logger = Logger.getLogger("operationService");
	
	@Resource(name="opsCodeMappingService")
    private OpsCodeMappingServiceInterface opsCodeMappingService;
	
	@Resource(name="projectService")
    private ProjectService projectService;

    @Resource(name="opBlockService")
    private OpBlockService opBlockService;
    
	
	////Sakib added
	public static String GET_LAST_INSERTED_OPERATION_ID = " SELECT MAX(OpID) FROM operations";
	public static String GET_LAST_INSERTED_OPERATION_IDS = " SELECT OpID FROM operations ORDER BY OpID DESC LIMIT :n";
	
	public static String GET_OPERATION_FROM_OPID = " SELECT * FROM operations WHERE OpID = :operationId";
	public static String GET_OPERATIONS_OF_MONTH = " SELECT * FROM operations WHERE MONTH(OpDate) = :mnth AND YEAR(OpDate) = :yr";
	//public static String REMOVE_OPERATION_FROM_OPID = " DELETE FROM operations WHERE OpID = :operationId";
	////
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Performs a batch insert for the operations that are given as input.
	 * 
	 * @param operations 		the operations that are imported by the import module
	 */
	public void performBatchInsert(List<Operation> operations) {
		if (operations.size() == 0) {
			return;
		}
		logger.debug("Adding new operations");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int i = 1;
		for (Operation o : operations) {
			session.save(o);
			if (i % 100 == 0) { 
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
	 * Retrieve last id from operations table
	 * 
	 */
	public Integer getLastId() {
		logger.debug("Getting the last / max OpId from the operations table");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query (HQL)
		Query query = session.createSQLQuery(GET_LAST_INSERTED_OPERATION_ID);

		List <Integer> result = query.list();
		if (result.size() > 0 && result.get(0) > 0) {
			return result.get(0);
		}
		
		return null;
	}

	/**
	 * Retrieve last several ids from operations table
	 * 
	 * @param n 		number of ids to retrieve
	 */
	public List <Integer> getLastIds(Integer n) {
		logger.debug("Getting the last / max n OpIds from the operations table");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query (HQL)
		Query query = session.createSQLQuery(GET_LAST_INSERTED_OPERATION_IDS)
									.setParameter("n", n);

		List <Integer> result = query.list();

		if (result.size() > 0) {
			return result;
		}
		
		return null;
	}

	/**
	 * Retrieve operations of a specific month from operations table
	 * 
	 * @param month 		
	 * @param year 		
	 */
	public List <Operation> getOperationsOfMonthYear(Integer month, Integer year) {
		logger.debug("Getting operations of a specific month from operations table");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		System.out.println("||| Month " + month + " Year ||||"+ year);
		// Create a query (HQL)
		Query query = session.createSQLQuery(GET_OPERATIONS_OF_MONTH)
									.addEntity(Operation.class)
									.setParameter("mnth", month)
									.setParameter("yr", year);

		List <Operation> result = query.list();

		if (result.size() > 0) {
			return result;
		}
		
		return null;
	}
	
	/**
	 * Retrieves a single operation
	 * 
	 * @param id		the operation id
	 * 
	 * @return 		a project
	 */
	public Operation get( Integer id ) {
		logger.debug("Retrieving project by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing project first
		Operation op = (Operation) session.get(Operation.class, id);
		
		return op;
	}
	
	/**
	 * Remove an operation from operations table
	 * 
	 * @param opId 		operation id to delete
	 */
	public void removeOperation(Integer opId) {
		logger.debug("Removing an operation from the operations table");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query (HQL)
		/*Query query = session.createSQLQuery(GET_OPERATION_FROM_OPID)
									.setParameter("operationId", opId);
		
		List <Operation> result = query.list();

		if (result.size() > 0) {*/
		
			Operation selectedOp = get(opId);
			if(selectedOp != null) {
				String opscode = selectedOp.getOpsc1();
				String residentName = selectedOp.getOp1();
				
				Integer catalogueId = opsCodeMappingService.getOpCatalogueIdFor5DigitPsCode(opscode);
				Integer projectId = projectService.getProjectIdForNickname(residentName);
				//System.out.println("***** removing operation catalogue " + catalogueId + " project " + projectId);
				OpBlock block = opBlockService.getOpblockFromPCD(projectId, catalogueId);
				//System.out.println("***** block " + block);
				if(block != null && block.getActualSize() > 0) {
					block.setActualSize(block.getActualSize() - 1);

					// Save updates
					session.save(block);
					
				} 
				
				// Create a query (HQL)
				//Query dq = session.createSQLQuery(REMOVE_OPERATION_FROM_OPID)
				//							.setParameter("operationId", opId);
				
				// Retrieve existing opCatalogue first
				Operation op = (Operation) session.get(Operation.class, opId);
				
				// Delete 
				session.delete(op);
			}
			
		//}
		
		

	}
}