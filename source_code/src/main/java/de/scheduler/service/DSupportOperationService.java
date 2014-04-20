package de.scheduler.service;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
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

import de.scheduler.model.DSupportOperation;
import de.scheduler.model.OpCatalogue;
import de.scheduler.model.Operation;
import de.scheduler.model.ProjectCatalogStatus;

/**
 * Service for processing dSupportOperations
 * 
 */
@Service("dSupportOperationService")
@Transactional
public class DSupportOperationService {
	
	protected static Logger logger = Logger.getLogger("dSupportOperationService");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="opCatalogueService")
	private OpCatalogueService opCatalogueService;
	
	public static String GET_ALL_DECISION_SUPPORT_OPERATIONS_FOR_SPECIALTY =  
						" SELECT " +
								" dsop.dSuppOpID" +
								", dsop.OPSC01" +
								", dsop.OPSC02" +
								", dsop.OpDate" +
								", dsop.Op1" +
								", dsop.Op2" +
								", dsop.Ass1" +
								", dsop.EntryDate" +
								", dsop.CatalogID" +
								", dsop.CatalogName" +
								", dsop.OPSC01Difficulty" +
								", dsop.OPSC02Difficulty" +
								", dsop.OP1Credit" +
								", dsop.OP2Credit" +
								", dsop.Ass1Credit" +
								", dsop.OP1ChosenDifficult" +
								", dsop.OP2ChosenDifficult" +
								", dsop.Ass1ChosenDifficult" +
								", dsop.Operation1Op1" +
								", dsop.Operation2Op1" +
								", dsop.Operation1Op2" +
								", dsop.Operation2Op2" +
								", dsop.Operation1Ass1" +
								", dsop.Operation2Ass1" +
								", dsop.Deletable" +
						" FROM " +
								" dSupportOperations dsop inner join project prj ON dsop.Op1 = prj.Nickname" +
						" WHERE " +
								" prj.SpecialtyID = :specialtyID" +
						" ORDER BY " +
								" dsop.OpDate ASC";
	public static String GET_DS_OPERATIONS_OF_MONTH = " SELECT * FROM dsupportoperations WHERE MONTH(OpDate) = :mnth AND YEAR(OpDate) = :yr";
	
	public static String GET_ALL_DECISION_SUPPORT_OPERATIONS_FOR_USER = " SELECT " +
								" dsop.dSuppOpID" +
								", dsop.OPSC01" +
								", dsop.OPSC02" +
								", dsop.OpDate" +
								", dsop.Op1" +
								", dsop.Op2" +
								", dsop.Ass1" +
								", dsop.EntryDate" +
								", dsop.CatalogID" +
								", dsop.CatalogName" +
								", dsop.OPSC01Difficulty" +
								", dsop.OPSC02Difficulty" +
								", dsop.OP1Credit" +
								", dsop.OP2Credit" +
								", dsop.Ass1Credit" +
								", dsop.OP1ChosenDifficult" +
								", dsop.OP2ChosenDifficult" +
								", dsop.Ass1ChosenDifficult" +
								", dsop.Operation1Op1" +
								", dsop.Operation2Op1" +
								", dsop.Operation1Op2" +
								", dsop.Operation2Op2" +
								", dsop.Operation1Ass1" +
								", dsop.Operation2Ass1" +
								", dsop.Deletable" +
						" FROM " +
								" dSupportOperations dsop " +
						" WHERE " +
								" ( dsop.Op1 = :username OR dsop.Op2 = :username OR dsop.Ass1 = :username ) AND " +
								" ( dsop.OPSC01Difficulty = 2 OR dsop.OPSC02Difficulty = 2 )" +
						" ORDER BY " +
								" dsop.OpDate DESC";
	
	public static String GET_DECISION_SUPPORT_OPERATIONS_FOR_OPERATION = " SELECT * FROM " +
						" dSupportOperations dsop " +
						" WHERE " +
						" dsop.Operation1Op1 = :opId OR dsop.Operation2Op1 = :opId OR " + 
						" dsop.Operation1Op2 = :opId OR dsop.Operation2Op2 = :opId OR " +
						" dsop.Operation1Ass1 = :opId OR dsop.Operation2Ass1 = :opId " +
						" ORDER BY " +
						" dsop.OpDate DESC";

	public static String GET_CATALOG_ID_FOR_D_SUPP_OP = " SELECT " +
																" psc.CatalogID as CatalogID " +
									 					 " FROM " +
									 					 		" pscodes psc " +
														 " WHERE " +
														 		" left(:opscode, 5) = PSCode";
	public static String GET_CATALOG_FOR_D_SUPP_OP = " SELECT " +
															" CONCAT(opc.CatalogID, '>>', opc.Name)  as catalogInfo " +
														" FROM " +
																" pscodes psc left outer join opcatalogues opc on (psc.CatalogID = opc.CatalogID) " +
														" WHERE " +
																" left(:opscode, 5) = PSCode";
	/**
	 * Retrieves the number of operations completed for each opCatalogue, for all projects
	 * It uses the imported operations, and the manually added operations for decision support
	 */
	public static String SELECT_ACTIVE_PROJECT_CATALOG_STATUS_FOR_SPECIALTY =   
									" SELECT " +
										" pr.projectID as projectID " +
										", proj.Nickname as nickname " +
										", pr.catalogueID as catalogueID " +
										", oc.Name as catalogueName " +
										", sum(pr.completedOpNumber) as completedOpNumber " +
										", oc.Level1OpNo + oc.Level2OpNo + oc.Level3OpNo  as totalOpNumber " +
										", period_diff(DATE_FORMAT(CURDATE(), '%Y%m'),DATE_FORMAT(proj.StartDate, '%Y%m')) as elapsedMonths " +
										", proj.Duration as duration" +
									" FROM " +
										" (	" +
											" SELECT " +
												" ob.ProjID as projectID " +
												", ob.CatalogID as catalogueID " +
												", sum(ob.ActualSize) as completedOpNumber " +
											" FROM " +
												" opblocks ob " +
												", project proj " +
											" WHERE " +
												" ob.CatalogID > 0 " +
												" AND proj.ProjID = ob.ProjID " +
												" AND proj.SpecialtyID = :specialtyID " +
												" AND proj.Active = 1 " +
											" group by " +
												" ob.CatalogID" +
												" , ob.ProjID " +
											" union all " +
											" SELECT " +
												" proj.ProjID as projectID " +
												", dso.CatalogID as catalogueID	" +
												", count(*) as completedOpNumber " +
											" FROM " +
												" dsupportoperations dso " +
												", project proj " +
											" WHERE " +
												" proj.Nickname = dso.Op1 " +
												" AND proj.SpecialtyID = :specialtyID " +
												" AND dso.CatalogID > 0	" +
												" AND proj.Active = 1 " +
											" group by " +
												" dso.CatalogID " +
												", proj.ProjID " +
										" ) pr" +
										", project proj " +
										", opcatalogues oc " +
									" WHERE " +
										" proj.ProjID = pr.projectID " +
										" AND pr.catalogueID = oc.CatalogID " +
									" group by " +
										" pr.catalogueID " +
										", pr.projectID " +
									" order by 2, 1";

	/**
	 * Retrieves all DSupportOperations
	 * 
	 * @return 		a list of DSupportOperations
	 */
	@SuppressWarnings("unchecked")
	public List<DSupportOperation> getAll() {
		logger.debug("Retrieving all decision support operations");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  DSupportOperation");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves all DSupportOperations for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list of DSupportOperations
	 */
	@SuppressWarnings("unchecked")
	public List<DSupportOperation> getAllForSpecialty(Integer specialtyID) {
		logger.debug("Retrieving all decision support operations for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_ALL_DECISION_SUPPORT_OPERATIONS_FOR_SPECIALTY)
									.addEntity(DSupportOperation.class)
									.setParameter("specialtyID", specialtyID);
		
		List<DSupportOperation> dSupportOperationsForSpecialty = query.list();
		
		// Retrieve all
		return dSupportOperationsForSpecialty;
	}
	

	/**
	 * Retrieves all DSupportOperations for a User (Admin, Resident, Instructor)
	 * 
	 * @param username		the User (Admin, Resident, Instructor)
	 * 
	 * @return 		a list of DSupportOperations
	 */
	@SuppressWarnings("unchecked")
	public List<DSupportOperation> getAllForUser(String username) {
		logger.debug("Retrieving all decision support operations for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_ALL_DECISION_SUPPORT_OPERATIONS_FOR_USER)
									.addEntity(DSupportOperation.class)
									.setParameter("username", username);
		
		List<DSupportOperation> dSupportOperationsForSpecialty = query.list();
		
		// Retrieve all
		return dSupportOperationsForSpecialty;
	}
	

	/**
	 * Retrieve dsupportOperations of a specific month from dsupportoperations table
	 * 
	 * @param month 		
	 * @param year 		
	 */
	public List <DSupportOperation> getDSuppOperationsOfMonthYear(Integer month, Integer year) {
		logger.debug("Getting operations of a specific month from operations table");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		System.out.println("||| Month " + month + " Year ||||"+ year);
		// Create a query (HQL)
		Query query = session.createSQLQuery(GET_DS_OPERATIONS_OF_MONTH)
									.addEntity(DSupportOperation.class)
									.setParameter("mnth", month)
									.setParameter("yr", year);

		List <DSupportOperation> result = query.list();

		if (result.size() > 0) {
			return result;
		}
		
		return null;
	}
	
	
	/**
	 * Retrieves a single DSupportOperation and maps the OPSCode to a Catalogue
	 * 
	 * @param id		the DSupportOperation id
	 * 
	 * @return 		a DSupportOperation
	 */
	public DSupportOperation get(Integer id) {
		logger.debug("Retrieving decision support operation by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing decision support operation first
		DSupportOperation dSupportOperation = (DSupportOperation) session.get(DSupportOperation.class, id);
		
		return dSupportOperation;
	}
	
	/**
	 * Maps the OPSCode to a catalogue and adds the new DSupportOperation
	 * 
	 * @param DSupportOperation		the DSupportOperation to be added
	 */
	public void add(DSupportOperation dSupportOperation) {
		logger.debug("Adding new decision support operation");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Map OPSCode to Catalogue
    	String catalogueInformation = this.getCatalogueForOpscode(dSupportOperation.getOpsc1());
    	String[] catIDName;
    	if (catalogueInformation != null && !catalogueInformation.equals("")){
    		catIDName = catalogueInformation.split(">>");
    		Integer catID = Integer.parseInt(catIDName[0]);
    		if (catID != 0) {
	   			dSupportOperation.setCatalogID (catID);
	   			dSupportOperation.setCatalogName(catIDName[1]);
    		}
   		} else {
   			dSupportOperation.setCatalogID (0);
   			dSupportOperation.setCatalogName("Not mapped");
    	}
		
		// Save
		session.save(dSupportOperation);
	}
	
	/**
	 * Deletes an existing DSupportOperation
	 * 
	 * @param id 		the id of the DSupportOperation
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing decision support operation");
		System.out.println("******* delete " + id);
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing decision support operation first
		DSupportOperation dSupportOperation = (DSupportOperation) session.get(DSupportOperation.class, id);
		
		// Delete 
		session.delete(dSupportOperation);
	}
	
	/**
	 * Edits an existing DSupportOperation
	 * 
	 * @param id 		the id of the DSupportOperation
	 */
	public void edit(DSupportOperation dSupportOperation) {
		logger.debug("Editing existing decision support operation");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing decision support operation via id
		DSupportOperation existingDSupportOperation = (DSupportOperation) session.get(DSupportOperation.class, dSupportOperation.getdSuppOpId());
		
		//System.out.println("++++++"+dSupportOperation.getOpDate());
		
		// Assign updated values to this decision support operation
		existingDSupportOperation.setOpsc1(dSupportOperation.getOpsc1());
		existingDSupportOperation.setOpsc2(dSupportOperation.getOpsc2());
		existingDSupportOperation.setOpDate(dSupportOperation.getOpDate());
		existingDSupportOperation.setOp1(dSupportOperation.getOp1());
		existingDSupportOperation.setOp2(dSupportOperation.getOp2());
		existingDSupportOperation.setAss1(dSupportOperation.getAss1());
		
		//Sakib added later for extra fields of difficulty
		existingDSupportOperation.setOPSC01Difficulty(dSupportOperation.getOPSC01Difficulty());
		existingDSupportOperation.setOPSC02Difficulty(dSupportOperation.getOPSC02Difficulty());
		existingDSupportOperation.setOP1Credit(dSupportOperation.getOP1Credit());
		existingDSupportOperation.setOP2Credit(dSupportOperation.getOP2Credit());
		existingDSupportOperation.setAss1Credit(dSupportOperation.getAss1Credit());
		existingDSupportOperation.setOP1ChosenDifficult(dSupportOperation.getOP1ChosenDifficult());
		existingDSupportOperation.setOP2ChosenDifficult(dSupportOperation.getOP2ChosenDifficult());
		existingDSupportOperation.setAss1ChosenDifficult(dSupportOperation.getAss1ChosenDifficult());

		existingDSupportOperation.setOperation1Op1(dSupportOperation.getOperation1Op1());
		existingDSupportOperation.setOperation2Op1(dSupportOperation.getOperation2Op1());

		existingDSupportOperation.setOperation1Op2(dSupportOperation.getOperation1Op2());
		existingDSupportOperation.setOperation2Op2(dSupportOperation.getOperation2Op2());

		existingDSupportOperation.setOperation1Ass1(dSupportOperation.getOperation1Ass1());
		existingDSupportOperation.setOperation2Ass1(dSupportOperation.getOperation2Ass1());
                
        //existingDSupportOperation.setEntryDate(dSupportOperation.getEntryDate());
		
		// Map OPSCode to Catalogue
    	String catalogueInformation = this.getCatalogueForOpscode(dSupportOperation.getOpsc1());
    	String[] catIDName;
    	if (catalogueInformation != null && !catalogueInformation.equals("")){
    		catIDName = catalogueInformation.split(">>");
    		Integer catID = Integer.parseInt(catIDName[0]);
    		if (catID != 0) {
    			existingDSupportOperation.setCatalogID (catID);
    			existingDSupportOperation.setCatalogName(catIDName[1]);
    		}
   		} else {
   			existingDSupportOperation.setCatalogID (0);
   			existingDSupportOperation.setCatalogName("Not mapped");
    	}
    	
		// Save updates
		session.save(existingDSupportOperation);
	}
	
	/**
	 * Maps for each catalogue the information needed for "Decision Support" View
	 * 
	 * @param persons			the list of persons
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a map with catalogues as key, all info as value = residents sorted by priority
	 * priority = rule that computes which resident should get the operation more urgently
	 */
	public Map<OpCatalogue, List<ProjectCatalogStatus>> getPrioritizedResidents(Integer specialtyID){
		logger.debug("Retrieve prioritized list of residents for all catalogues, for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
    	// Retrieve all in a map containing the catalogID and the catalog
		Map<Integer, OpCatalogue> opCatalogues = opCatalogueService.getCataloguesForMapping(specialtyID);
		
		// Create a query (SQL)
		Query query = session.createSQLQuery(SELECT_ACTIVE_PROJECT_CATALOG_STATUS_FOR_SPECIALTY)
									.addScalar("projectID", Hibernate.INTEGER)
									.addScalar("nickname", Hibernate.STRING)
									.addScalar("catalogueID", Hibernate.INTEGER)
									.addScalar("catalogueName", Hibernate.STRING)
									.addScalar("completedOpNumber", Hibernate.INTEGER)
									.addScalar("totalOpNumber", Hibernate.INTEGER)
									.addScalar("elapsedMonths", Hibernate.INTEGER)
									.addScalar("duration", Hibernate.INTEGER)
									.setResultTransformer( Transformers.aliasToBean(ProjectCatalogStatus.class))
									.setParameter("specialtyID", specialtyID);
		
		List<ProjectCatalogStatus> activeProjectStatuses = query.list();
		
    	Map<OpCatalogue, List<ProjectCatalogStatus>> residentListForCatalogues = new HashMap<OpCatalogue, List<ProjectCatalogStatus>>();
    	
    	//iterate through all activeProjectStatuses to assign the list of projInfo
		for (ProjectCatalogStatus projCatStatus : activeProjectStatuses) {
			projCatStatus.setProgressPercentIs();
			projCatStatus.setProgressPercentShouldBe();
			projCatStatus.setOverdue();
			
			// load the already created Catalog object
			OpCatalogue opCatalog = opCatalogues.get(projCatStatus.getCatalogueID());
			
			// check if the ProjectPersonInfo is already in our map			
			if (residentListForCatalogues.containsKey(opCatalog)) {
				// load the already contained list
				List<ProjectCatalogStatus> infos = residentListForCatalogues.get(opCatalog);
				// add the new info to it
				infos.add(projCatStatus);
			} else {
				// if the key does not exist then add it to the final map, with
				// an empty list
				List<ProjectCatalogStatus> statusList = new LinkedList<ProjectCatalogStatus>();
				statusList.add(projCatStatus);
				residentListForCatalogues.put(opCatalog, statusList);
			}
		}

		residentListForCatalogues = this.sortResidentListsForEachCatalog(residentListForCatalogues, ProjectStatusInfoRule.INSTANCE);

		// Retrieve all
		return residentListForCatalogues;
	}
	
	/**
	 * Sorts the list of residents, for each catalogue following a priority rule
	 * 
	 * @param residentListForCatalogues			the map containing a list of residents for each catalog
	 * 
	 * @return 									updated residentListForCatalogues
	 */
	public Map<OpCatalogue, List<ProjectCatalogStatus>> sortResidentListsForEachCatalog(
			Map<OpCatalogue, List<ProjectCatalogStatus>> residentListForCatalogues,
			Comparator<ProjectCatalogStatus> comparator) {
		logger.debug("Getting Catalogue ID for decision support operation.");
		
		for (Map.Entry<OpCatalogue, List<ProjectCatalogStatus>> entry : residentListForCatalogues.entrySet()) {
			List<ProjectCatalogStatus> projCatInfo = entry.getValue();
			Collections.sort(projCatInfo, comparator);
		}

		// Retrieve the ID
		return residentListForCatalogues;
	}
	
	/**
	 * Maps a OPSCode to a catalogue
	 * 
	 * @param dSupportOperation		the decision support operation to be mapped
	 * 
	 * @return 		updated DSupportOperation
	 */
	@SuppressWarnings("unchecked")
	public String getCatalogueForOpscode(String OPSCode) {
		logger.debug("Getting Catalogue ID for decision support operation.");
		
		String catalogID = new String();
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_CATALOG_FOR_D_SUPP_OP)
									.addScalar("catalogInfo", Hibernate.STRING)
									.setParameter("opscode", OPSCode);
		if (query.list().size() == 1)
			catalogID = (String)query.list().get(0);

		// Retrieve the ID
		return catalogID;
	}


	/**
	 * Get DecisionSupport Operation for operation
	 * 
	 * @param opId		the id of the operation
	 * 
	 * @return 		true or false
	 */
	@SuppressWarnings("unchecked")
	public DSupportOperation getDSuppOpForOp(Integer opId) {
		logger.debug("Getting DecisionSupport Operation for operation");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery(GET_DECISION_SUPPORT_OPERATIONS_FOR_OPERATION)
									.setParameter("opId", opId);
		if (query.list().size() > 0) {
			DSupportOperation dSupportOperation = (DSupportOperation) query.list().get(0);
			return dSupportOperation;
		}

		// Retrieve the ID
		return null;
	}
	
	
}