package de.scheduler.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import de.scheduler.model.Specialty;
import de.scheduler.util.SchedulerConstants;

/**
 * This class loads the specialties from the database only once. It stores them
 * for the entire period when the app is running.
 */
@Service("specialtyLoader")
public class SpecialtyLoader {
	private static Logger logger = Logger.getLogger(SpecialtyLoader.class);
	private List<Specialty> specialty;
	@Resource(name="specialtyService")
	private SpecialtyService specialtyService;
	    
    public List<Specialty> getSpecialties() {
    	return specialty;
    }
    
    public Integer getFirstSpecialtyID() { 
    	int firstSpecialtyID = SchedulerConstants.DEFAULT_SPECIALTY;
    	if(specialty.size() != 0) { 
    		firstSpecialtyID = specialty.get(0).getSpecialtyID();
    	}
    	return firstSpecialtyID;
    }
    
    @PostConstruct
    public void initialize() {
       logger.debug("Initialize the bean in PostConstruct");
       specialty = specialtyService.getAll();
    }

}
