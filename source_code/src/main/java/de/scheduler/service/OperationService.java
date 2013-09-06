package de.scheduler.service;
import java.util.List;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.Operation;

/**
 * Service for processing Operations
 * 
 */
@Service("operationService")
@Transactional
public class OperationService {
	protected static Logger logger = Logger.getLogger("operationService");
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
}