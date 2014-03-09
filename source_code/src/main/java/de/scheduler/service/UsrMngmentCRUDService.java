package de.scheduler.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.scheduler.model.Person;
import de.scheduler.model.Project;
import de.scheduler.model.User;
import de.scheduler.model.UserInfo;
import de.scheduler.model.UserRole;
import de.scheduler.util.SpecialtySelector;

@Service("usrMngmentCRUDService")
@Transactional
public class UsrMngmentCRUDService implements UsrMngmentCRUDServiceIntrface{
	
	protected static Logger logger = Logger.getLogger("CRUD Service");

	public static String SELECT_ALL_USER="SELECT "+ "US.ID AS usrId"+" ,US.ACTIVE AS active"+" ,US.USERNAME AS userName"+" ,US.PASSWORD AS password"+" ,USR.ROLE AS userRole "+
			"FROM "+ "USER US"+", USER_ROLES USR "+" WHERE "+" US.ID = USR.USER_ID"+" AND US.USERNAME <> :cUsrName ";
	
	public static String UPDATE_USER_ROLE = "UPDATE "+ "USER_ROLES "+ " SET ROLE = :user_role "+" WHERE USER_ID = :id";
	
	public static String USER_FROM_USERNAME = "SELECT "+ "ID FROM "+ " USER "+" WHERE USERNAME = :username";
	
	public static String ACTIVITY_FROM_USERNAME = "SELECT "+ "regular FROM "+ " USER "+" WHERE USERNAME = :username";
	
	public static String UPDATE_USER_PASSWORD = "UPDATE "+ "user"+ " SET regular = :regular "+",password = :password" +" WHERE USERNAME = :username"+ "and "+ "SpecialtyID = :specialityID";
	
	public static String SELECT_FROM_USERNAME = "SELECT "+ "id FROM "+ "user "+"WHERE USERNAME = :username "+ "AND "+ "password = :password";
	
	public static String SELECT_ID_FROM_USERNAME = "SELECT "+ "id FROM "+ "user "+"WHERE USERNAME = :username ";
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UserInfo> getAllUsers(String cUsrName) {
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query query = session.createSQLQuery(SELECT_ALL_USER)
				.addScalar("usrId",Hibernate.INTEGER)
				.addScalar("active",Hibernate.BOOLEAN)
				.addScalar("userName",Hibernate.STRING)
				.addScalar("password",Hibernate.STRING)
				.addScalar("userRole",Hibernate.STRING)
				.setParameter("cUsrName", cUsrName)
				.setResultTransformer(Transformers.aliasToBean(UserInfo.class))
				;
		List<UserInfo> usrDetail = query.list();
		logger.debug("Retrieving project by id");
		return usrDetail;
	}

	@Override
	public void deleteUsers(Integer usrId) {
		
		// Retrieve session from Hibernate		
				Session session = sessionFactory.getCurrentSession();
				User user = get(usrId);
				
				//Delete
				session.delete(user);
		
	}

	@Override
	public void updateUsers(User user) {
		
		// Retrieve session from Hibernate		
		Session session = sessionFactory.getCurrentSession();
		// Save updates
		session.update(user);
	}
	
	@Override
	public void updateUserRole(UserRole usrRole) {
		logger.debug("Retrieving user by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save updates
				session.update(usrRole);
	}
	/**
	 * Retrieves a single User
	 * 
	 * @param id		the user id
	 * 
	 * @return 		a User
	 */
	public User get( Integer id ) {
		logger.debug("Retrieving user by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing project first
		User user = (User) session.get(User.class, id);
		
		return user;
	}
	
	/**
	 * Retrieves a single User
	 * 
	 * @param username		the username
	 * 
	 * @return 		a User
	 */
	public User getUserFromUsername( String username ) {
		logger.debug("Retrieving user by username");
		Integer id = 0;
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
		Query query = session.createSQLQuery(USER_FROM_USERNAME)
				.addScalar("id", Hibernate.INTEGER)
				.setParameter("username",username)
				;
		if(query.list().size()==1)
			id = (Integer)query.list().get(0);
		
		User user = (User) session.get(User.class, id);
		
		return user;
	}
	
	public Integer getRoleId( Integer uId ) {
		logger.debug("Retrieving user by id");
		Integer roleId = 0;
		/// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query (SQL)
				Query query = session.createSQLQuery("select id from user_roles where user_id = :uId")
						.addScalar("id", Hibernate.INTEGER)
						.setParameter("uId",uId)
						;
		if(query.list().size()==1)
			roleId = (Integer)query.list().get(0);
		return roleId;
		
	}
	 /* Retrieves a single UserRole
	 * 
	 * @param id		the user id
	 * 
	 * @return 		a UserRole
	 */
	public UserRole getUserRole( Integer id ) {
		logger.debug("Retrieving user by id");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing project first
		UserRole userRole = (UserRole) session.get(UserRole.class, id);
		
		return userRole;
	}
	
	/**
	 * Retrieve activity of Current logged in user
	 * @param userName
	 * @return active
	 */
	public boolean getUserActivity(String userName) {
		boolean activity = false;
		logger.debug("Retrieving user activity");
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a query (SQL)
		Query query = session.createSQLQuery(ACTIVITY_FROM_USERNAME)
					.addScalar("regular", Hibernate.BOOLEAN)
					.setParameter("username",userName)
						;
		if(query.list().size()==1)
			activity = (Boolean) query.list().get(0);
		System.out.println("Activity: "+activity);
		System.out.println("Username: "+userName);
		return activity;
	}

	/**
	 * Check current password with saved paswword to match
	 */
	public String checkCurrentPassword(String currPassValue, String userName) {
		Integer pass = 0;
		String count = "-1";
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();	
		
		Query query = session.createSQLQuery(SELECT_FROM_USERNAME)
											.addScalar("id",Hibernate.INTEGER)
											.setParameter("username", userName)
											.setParameter("password", currPassValue)
											;
		if(query.list().size()==1){	
			count ="1";
		return count;
		}
		else  return "-1";
	}

	
	public String getIdFromUserName(String userName) {
		String count = "-1";
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();	
		//System.out.println("Username"+ userName);
		
		Query query = session.createSQLQuery(SELECT_ID_FROM_USERNAME)
											.addScalar("id",Hibernate.INTEGER)
											.setParameter("username", userName)
											;
		if(query.list().size()==1){	
			count ="1";
		return count;
		}
		else  return "0";
	}
	

}
