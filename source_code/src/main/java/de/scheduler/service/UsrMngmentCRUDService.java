package de.scheduler.service;

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

import de.scheduler.model.User;
import de.scheduler.model.UserInfo;
import de.scheduler.model.UserRole;

@Service("usrMngmentCRUDService")
@Transactional
public class UsrMngmentCRUDService implements UsrMngmentCRUDServiceIntrface{
	
	protected static Logger logger = Logger.getLogger("CRUD Service");

	public static String SELECT_ALL_USER="SELECT "+ "US.ID AS usrId"+" ,US.ACTIVE AS active"+" ,US.USERNAME AS userName"+" ,US.PASSWORD AS password"+" ,USR.ROLE AS userRole "+
			"FROM "+ "USER US"+", USER_ROLES USR "+" WHERE "+" US.ID = USR.USER_ID"+" AND US.USERNAME <> :cUsrName ";
	
	public static String UPDATE_USER_ROLE = "UPDATE "+ "USER_ROLES "+ " SET ROLE = :user_role "+" WHERE USER_ID = :id";
	
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

	
	
	

}
