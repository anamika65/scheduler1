package de.scheduler.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.scheduler.model.Configuration;
import de.scheduler.util.Settings;

@Service("configurationService")
@Transactional
public class ConfigurationService {

	protected static Logger logger = Logger.getLogger("configurationService");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Adds a new configuration
	 * 
	 * @param config		the configuration to be added
	 */
	public void add(Configuration config) {
		logger.debug("Adding a new configuration");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Save
		session.save(config);
	}

	/**
	 * Edits an existing configuration
	 * 
	 * @param config		the configuration to be edited
	 */
	public void edit(Configuration config) {
		logger.debug("Editing existing configuration");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Retrieve existing configuration via id
		Configuration existingConfig = (Configuration) session.get(
				Configuration.class, config.getConfigID());

		// Assign updated values to this configuration
		existingConfig.setName(config.getName());
		existingConfig.setValue(config.getValue());

		// Save updates
		session.save(existingConfig);
	}

	/**
	 * Retrieves all configurations
	 * 
	 * @return 		a list of configuration objects
	 */
	@SuppressWarnings("unchecked")
	public List<Configuration> getAll() {
		logger.debug("Retrieving all configurations");

		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();

		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Configuration");

		// Retrieve all
		return query.list();
	}

	/**
	 * Update a configuration
	 * 
	 * @param keyValue		the configuration name to be updated
	 * @param newValue		the new value of the configuration
	 */
	public void updateSetting(String keyValue, Integer newValue) {
		logger.debug("Editing existing configuration");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery(
				"FROM  Configuration WHERE Name = :name").setParameter("name", keyValue);
		query.setMaxResults(1);
		List<Configuration> res = query.list();
		Configuration config = res.get(0);
		
		// Assign updated values to this configuration
		config.setValue(String.valueOf(newValue));
		
		// Save updates		
		session.save(config);
	}

	/**
	 * Retrieve a configuration value
	 * 
	 * @param s		the configuration name
	 * 
	 * @return 		configuration value
	 */
	public String getConfigurationValue(Settings s) {
		logger.debug("Get value for existing configuration");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery(
				"FROM  Configuration WHERE Name = :name").setParameter("name", s.toString());
		query.setMaxResults(1);
		List<Configuration> res = query.list();
		Configuration config = res.get(0);
		
		return config.getValue();
	}
}
