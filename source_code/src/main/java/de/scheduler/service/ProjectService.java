package de.scheduler.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

import de.scheduler.model.Project;
import de.scheduler.model.ProjectPersonInfo;
import de.scheduler.model.ProjectCatalogStatus;

/**
 * Service for processing Projects aka resident training
 * 
 */
@Service("projectService")
@Transactional
public class ProjectService {

	protected static Logger logger = Logger.getLogger("projectService");
	
	public static String DEACTIVATE_RESIDENT_BY_ID = " UPDATE project " +
													 " SET Active = 0 " +
													 " WHERE " +
														 	" ProjID = :projID ";
	
	public static String DEACTIVATE_RESIDENT_UNTIL = " UPDATE project " +
													 " SET Active = 0 " +
												 		", DeactivatedUntil = :untilDate " +
													 " WHERE " +
													 	" ProjID = :projID ";
	
	public static String REACTIVATE_RESIDENTS_FOR_SPECIALTY = " UPDATE project " +
													 " SET Active = 1 " +
												 		", DeactivatedUntil = null " +
													 " WHERE " +
													 	" DATE(DeactivatedUntil) < DATE( :activateDate ) " +
													 	" AND SpecialtyID = :specialtyID";
	
	public static String ACTIVATE_RESIDENT_BY_ID = " UPDATE project " +
												   " SET Active = 1" +
												   		", DeactivatedUntil = null " +
												   " WHERE " +
												   	  	" ProjID = :projID ";
	
	public static String GET_ALL_PROJECTS_FOR_SPECIALTY = " SELECT * " +
														  " FROM project " +
														  " WHERE SpecialtyID = :specialtyID";
	
	public static String GET_ALL_PROJECTS_FOR_CATALOG = " SELECT * " +
														" FROM project " +
														" WHERE " +
															" ProjID = ANY (" +
																" SELECT DISTINCT ProjID " +
																" FROM opblocks " +
																" WHERE CatalogID = :catalogID" +
															" )";
	
	public static String GET_ALL_ACTIVE_PROJECTS_FOR_SPECIALTY = " SELECT * " +
															  " FROM project " +
															  " WHERE SpecialtyID = :specialtyID" +
															  " AND Active = 1";
	
	public static String GET_ALL_NICKNAMES_FOR_SPECIALTY = " SELECT prj.Nickname " +
														  " FROM project prj" +
														  " WHERE prj.SpecialtyID = :specialtyID" +
														  " AND prj.Active = 1" +
														  " ORDER BY 1 ASC";
	/**
	 * Retrieves the number of operations completed for each opCatalogue,
	 * for all projects
	 */
	public static String SELECT_PROJECT_CATALOG_STATUS_FOR_SPECIALTY =   
									" SELECT " +
											"ob.ProjID as projectID" +
											", proj.Nickname as nickname" +
											", ob.CatalogID as catalogueID" +
											", oc.Name as catalogueName" +
											", sum(ob.ActualSize) as completedOpNumber" +
											", sum(ob.DefaultSize) as totalOpNumber" + 
											", period_diff(DATE_FORMAT(CURDATE(), '%Y%m'),DATE_FORMAT(proj.StartDate, '%Y%m')) as elapsedMonths" +
											", proj.Duration as duration" +
									" FROM " +
											"opblocks ob" +
											", opcatalogues oc " +
											", project proj" +
									" WHERE " +
											"ob.CatalogID > 0" +
											" AND ob.CatalogID = oc.CatalogID" +
											" AND proj.ProjID = ob.ProjID" +
											" AND proj.SpecialtyID = :specialtyID" +
									" group by " +
											"ob.ProjID" +
											", ob.CatalogID";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Resource(name="operationBlockGeneratorService")
	private OperationBlockGenerator operationBlockGeneratorService;
	
	@Resource(name="projectPersonInfoService")
	private ProjectPersonInfoService projectPersonInfoService;

	/**
	 * Retrieves all Projects
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getAll() {
		logger.debug("Retrieving all projects");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Project");

		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves all Projects that are active
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getAllActiveProjects() {
		logger.debug("Retrieving all active projects");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Project WHERE Active = 1");

		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves all Projects that have a catalog assigned
	 * 
	 * @param catalogID		the catalog id for which the projects must be returned
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjectsForCatalog(int catalogID) {
		logger.debug("Retrieving all active projects");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a query
		Query query = session.createSQLQuery(GET_ALL_PROJECTS_FOR_CATALOG)
							.addEntity(Project.class)
							.setParameter("catalogID", catalogID);

		// Retrieve all
		return query.list();
	}
	
	/**
	 * Retrieves all Projects for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getAllForSpecialty (Integer specialtyID) {
		logger.debug("Retrieving all Projects for specialty");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession(); 

		// Create a Hibernate query
		Query query = session.createSQLQuery(GET_ALL_PROJECTS_FOR_SPECIALTY)
							.addEntity(Project.class)
							.setParameter("specialtyID", specialtyID);
		
		List<Project> projectsForSpecialty = query.list();
	
		// Retrieve all
		return projectsForSpecialty;
	}
	
	/**
	 * Retrieves all active Projects for a specialty
	 * 
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a list
	 */
	@SuppressWarnings("unchecked")
	public List<Project> getAllActiveForSpecialty (Integer specialtyID) {
		logger.debug("Retrieving all active Projects for specialty");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession(); 

		// Create a Hibernate query
		Query query = session.createSQLQuery(GET_ALL_ACTIVE_PROJECTS_FOR_SPECIALTY)
							.addEntity(Project.class)
							.setParameter("specialtyID", specialtyID);
		
		List<Project> activeProjectsForSpecialty = query.list();
	
		// Retrieve all
		return activeProjectsForSpecialty;
	}
	
	/**
	 * Retrieves a single project
	 * 
	 * @param id		the project id
	 * 
	 * @return 		a project
	 */
	public Project get( Integer id ) {
		logger.debug("Retrieving project by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing project first
		Project project = (Project) session.get(Project.class, id);
		
		return project;
	}
	
	/**
	 * Maps for each project the information needed for "Residents and Training Progress" View
	 * 
	 * @param persons			the list of persons
	 * @param specialtyID		the specialty id
	 * 
	 * @return 		a map with projects as key, all info as value
	 */
	public Map<ProjectPersonInfo, List<ProjectCatalogStatus>> getProjectsInformation(Integer specialtyID){
		logger.debug("Retrieve status for projects, for specialty");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// map containing the personID and the information about resident and person
		Map<Integer, ProjectPersonInfo> projectPersInfos = projectPersonInfoService
				.getProjectPersonInfos(specialtyID);

		// Create a query (SQL)
		Query query = session
				.createSQLQuery(SELECT_PROJECT_CATALOG_STATUS_FOR_SPECIALTY)
				.addScalar("projectID", Hibernate.INTEGER)
				.addScalar("nickname", Hibernate.STRING)
				.addScalar("catalogueID", Hibernate.INTEGER)
				.addScalar("catalogueName", Hibernate.STRING)
				.addScalar("completedOpNumber", Hibernate.INTEGER)
				.addScalar("totalOpNumber", Hibernate.INTEGER)
				.addScalar("elapsedMonths", Hibernate.INTEGER)
				.addScalar("duration", Hibernate.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(ProjectCatalogStatus.class))
				.setParameter("specialtyID", specialtyID);

		List<ProjectCatalogStatus> projectStatuses = query.list();

		Map<ProjectPersonInfo, List<ProjectCatalogStatus>> allProjInfo = new HashMap<ProjectPersonInfo, List<ProjectCatalogStatus>>();
		
		// for each entry retrieved by the sql query
		for (ProjectCatalogStatus projCatStatus : projectStatuses) {
			projCatStatus.setProgressPercentIs();
			projCatStatus.setProgressPercentShouldBe();
			projCatStatus.setOverdue();
			
			// load the already created ProjectPersonInfo object
			ProjectPersonInfo pProjInfo = projectPersInfos.get(projCatStatus.getProjectID());
			
			// check if the ProjectPersonInfo is already in our map
			if (allProjInfo.containsKey(pProjInfo)) {
				// load the already contained list
				List<ProjectCatalogStatus> infos = allProjInfo.get(pProjInfo);
				// add the new info to it
				infos.add(projCatStatus);
			} else {
				// if the key does not exist then add it to the final map, with
				// an empty list
				List<ProjectCatalogStatus> statusList = new LinkedList<ProjectCatalogStatus>();
				statusList.add(projCatStatus);
				allProjInfo.put(pProjInfo, statusList);
			}
		}
		
		// Retrieve all
		return allProjInfo;
	}

	/**
	 * Adds a new project
	 * 
	 * @param project		the project
	 */
	public void add(Project project) {
		logger.debug("Adding new person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(project);
	}
	
	/**
	 * Edits an existing project
	 * 
	 * @param person object that will be updated
	 */
	public void edit(Project project) {
		logger.debug("Editing existing project");
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Save updates
		session.update(project);
	}
	
	/**
	 * Deactivates a project
	 * 
	 * @param projectID		the project id
	 * 
	 * @return 		true, if successful
	 */
	public boolean deactivate(Integer projectID) {
		logger.debug("Deactivate a project");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query deactivateQuery = session.createSQLQuery(DEACTIVATE_RESIDENT_BY_ID)
				.setParameter("projID", Integer.valueOf(projectID));
		
		int success = deactivateQuery.executeUpdate();
		if (success < 0)
			return false;
		return true;
	}

	/**
	 * Activates a project
	 * 
	 * @param projectID		the project id
	 * 
	 * @return 		true, if successful
	 */
	public boolean activate(Integer projectID) {
		logger.debug("Activate a project");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query activateQuery = session.createSQLQuery(ACTIVATE_RESIDENT_BY_ID)
				.setParameter("projID", Integer.valueOf(projectID));
		
		int success = activateQuery.executeUpdate();
		if (success < 0)
			return false;
		return true;		
	}

	/**
	 * Deactivate project until date.
	 *
	 * @param id 			the id
	 * @param untilDate 	the until date
	 * 
	 * @return 		true, if successful
	 */
	public boolean deactivateUntilDate(Integer id, Date untilDate) {
		logger.debug("Deactivate a project until a specific date");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query deactivateQuery = session.createSQLQuery(DEACTIVATE_RESIDENT_UNTIL)
				.setParameter("projID", Integer.valueOf(id))
				.setParameter("untilDate", untilDate);
		
		int success = deactivateQuery.executeUpdate();
		if (success < 0)
			return false;
		return true;
	}
	
	/**
	 * Reactivates the residents that are in vacation. (if DeactivatedUntil < activateDate)
	 *
	 * @param activateDate		 the date of activation
	 * 
	 * @return 		true, if successful
	 */
	public boolean reactivateOnVacationUsers(Date activateDate, Integer specialtyID) {
		logger.debug("Reactivate all projects until a specific date for a specialty");
		
		String format = "yyyy-MM-dd";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query deactivateQuery = session.createSQLQuery(REACTIVATE_RESIDENTS_FOR_SPECIALTY)
				.setParameter("activateDate", dateFormatter.format(activateDate))
				.setParameter("specialtyID", specialtyID);
		
		int success = deactivateQuery.executeUpdate();
		if (success < 0)
			return false;
		return true;
	}
	
	/**
	 * Get all Nicknames for a specialty
	 *
	 * @return 		list of all nicknames
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllNicknamesForSpecialty(Integer specialtyID) {
		logger.debug("Get all project nicknames for a specialty");
		
		List<String> nicknames = new ArrayList<String>(100);
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query nicknamesQuery = session.createSQLQuery(GET_ALL_NICKNAMES_FOR_SPECIALTY)
				.setParameter("specialtyID", specialtyID);
		
		nicknames = nicknamesQuery.list();
		nicknames.add(0, "");

		return nicknames;
	}
}