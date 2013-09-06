package de.scheduler.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.scheduler.model.Specialty;
import de.scheduler.service.SpecialtyLoader;
import de.scheduler.util.SpecialtySelector;

@Controller
@RequestMapping(value="/schedule")
public class GuestController {
	protected static Logger logger = Logger.getLogger("guest controller");
	
	@Resource(name="specialtyLoader")
	private SpecialtyLoader specialtyLoader;
	
	@Value("#{settings['birtURL']}")  
	private String birtURL;
	public void setBirtURL(String birtURL) {  
       this.birtURL = birtURL;  
	}  
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showGuestHome(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model) {
		logger.debug("Received request to show guest homepage");
		//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
		// Attach specialties to the Model
    	this.mapSpecialties(model);
    	
		model.addAttribute("birtURL", birtURL);
		model.addAttribute("specialtyId", specialtyId);
		
		// This will resolve to /WEB-INF/jsp/guest/GuestHome.jsp
		return "guest/GuestHome";
	}

   public boolean mapSpecialties(Model model){
		logger.debug("Received request to get all specialties");
		
    	// Retrieve all specialties by delegating the call to SpecialtyLoader
    	List<Specialty> specialty = specialtyLoader.getSpecialties();
    	
    	// Attach specialties to the Model
    	model.addAttribute("specialties", specialty);
    	
    	return true;
    }
}
