package de.scheduler.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
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
import de.scheduler.model.Schedule;

@Service("schedulesServices")
@Transactional
public class SchedulesService {
	protected static Logger logger = Logger.getLogger("schedulesServices");
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public static String DELETE_SCHEDULE_BY_DATE_FOR_SPECIALTY= " delete " +
																" from " +
															  		" schedules " +
															    " where " +
															  		" ScheduleDate = :byDate " +
															  		" and projectID = any " +
															  						" (select projID from project where specialtyID = :specialtyID)"; 

	/**
	 * Prepare insert of the OpBlocks
	 * 
	 * @param opBlocks			list of blocks
	 * @param currentDate		date of generation
	 *          
	 * @return 		true, if successful
	 */
	public boolean batchInsertOpBlocks(List<OpBlock> opBlocks, Date currentDate) {
		if (opBlocks.size() == 0)
			return false;
		List<Schedule> schedules = new LinkedList<Schedule>();
		for (OpBlock o : opBlocks) {
			Schedule sch = new Schedule();
			sch.setOpBlockID(o.getOpBlockId());
			sch.setProjectID(o.getProjectID());
			sch.setScheduleDate(currentDate);
			schedules.add(sch);
		}
		performBatchInsert(schedules);
		return true;
	}

	/**
	 * Perform insert of the OpBlocks
	 * 
	 * @param schedules			list of schedules to be inserted
	 */
	public void performBatchInsert(List<Schedule> schedules) {
		if (schedules == null || schedules.size() == 0) {
			return;
		}
		logger.debug("Adding new schedules");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int i = 1;
		for (Schedule o : schedules) {
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
	 * Deletes the old generated schedule for a date
	 * 
	 * @param date				the date for which the schedule will be deleted
	 * @param specialtyID		the specialty for which the schedule will be deleted
	 *          
	 * @return 		true, if successful
	 */
	public boolean deleteScheduleByDate(Date date, Integer specialtyID) {
		logger.debug("Deleting schedule for date, for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
		
		// Create a query (SQL)
		Query deleteQuery = session.createSQLQuery(DELETE_SCHEDULE_BY_DATE_FOR_SPECIALTY)
				.setParameter("byDate", dateFormatter.format(date))
				.setParameter("specialtyID", specialtyID);
		
		int row = deleteQuery.executeUpdate();
		if (row < 0)
			return false;
		return true;	
	}
}
