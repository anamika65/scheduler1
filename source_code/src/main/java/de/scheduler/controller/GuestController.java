package de.scheduler.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.scheduler.model.Specialty;
import de.scheduler.model.User;
import de.scheduler.service.SpecialtyLoader;
import de.scheduler.service.SpecialtyService;
import de.scheduler.service.UsrMngmentCRUDService;
import de.scheduler.service.UsrMngmentCRUDServiceIntrface;
import de.scheduler.util.SpecialtySelector;

@Controller
@RequestMapping(value="/schedule")
public class GuestController {
	protected static Logger logger = Logger.getLogger("guest controller");
	
	@Resource(name="specialtyLoader")
	private SpecialtyLoader specialtyLoader;
	
	@Resource(name="specialtyService")
	private SpecialtyService specService;
		
	@Resource(name="usrMngmentCRUDService")
    private UsrMngmentCRUDServiceIntrface usrMngmentCRUDServiceIntrface;
	
	@Value("#{settings['birtURL']}")  
	private String birtURL;
	public void setBirtURL(String birtURL) {  
       this.birtURL = birtURL;  
	}  
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showGuestHome(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model, Principal principal) {
		logger.debug("Received request to show guest homepage");
		String specialityName = null;
		//load the specialty id from the cookie 
    	int specialtyId = SpecialtySelector.getSpecialtyId(cookie, specialtyLoader.getFirstSpecialtyID());
		// Attach specialties to the Model
    	this.mapSpecialties(model);
    	
    	 // Retrieve current user activity ;first login activitiy =false otherwise true
        String username = getSessionUser();
        boolean activity = usrMngmentCRUDServiceIntrface.getUserActivity(username);
        //Attach by Anamika
        
        if(username.equals("anonymousUser")){
        	specialityName ="No Speciality";
        	System.out.println("Sp:" +specialityName);
			model.addAttribute("specialityName",specialityName);
		}
		else{
			specialityName = specService.getByID(username);
			System.out.println("Sp:" +specialityName);
			model.addAttribute("specialityName",specialityName);
		} //
        //model.addAttribute("activity",activity);
		model.addAttribute("birtURL", birtURL);
		model.addAttribute("specialtyId", specialtyId);
		if(username.equals("anonymousUser") || activity){
			return "guest/GuestHome";
		}
		else{
			// This will resolve to /WEB-INF/jsp/guest/GuestHome.jsp
			return "redirect:changepassword";
		}
		
	}
	
	@RequestMapping(value= "/changepassword", method = RequestMethod.GET)
	public String forceChngePassword(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie, Model model) {
		logger.debug("Force change password");
		return "users/ChangePassword";
		
	}

   public boolean mapSpecialties(Model model){
		logger.debug("Received request to get all specialties");
		
    	// Retrieve all specialties by delegating the call to SpecialtyLoader
    	List<Specialty> specialty = specialtyLoader.getSpecialties();
    	
    	// Attach specialties to the Model
    	model.addAttribute("specialties", specialty);
    	
    	return true;
    }
   
   /**
    * Get the current user information from context
    * @return username
    */
   public static String getSessionUser() {
	    String userName = null;
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    if(securityContext != null) {
	        Authentication authentication = securityContext.getAuthentication();
	        if(authentication != null) {
	            String authenticationName = authentication.getName();
	            if(authenticationName != null) {
	                userName = authenticationName;
	            }
	        }
	    }

	    return userName;
	}
   
   /**
	 * Save password after user changes the password after first successful login
	 * @return redirect to guestPage
	 */
	@RequestMapping(value = "/changepassword/save", method = RequestMethod.POST)
	public String changePassword(@CookieValue(value="selectedSpeciality", defaultValue="") String cookie,
			Model model, Principal principal,
            @RequestParam(value="curPassword", required=true) String curPassword,
            @RequestParam(value="newPassword", required=true) String newPassword,
                @RequestParam(value="repeatPassword", required=true) String repeatPassword){
    	// Retrieve current user activity ;first login activitiy =false otherwise true
        String username = getSessionUser();
      //Find User by user name
        User user = usrMngmentCRUDServiceIntrface.getUserFromUsername(username);
        user.setPassword(newPassword);
        user.setRegular(1);
       usrMngmentCRUDServiceIntrface.updateUsers(user);
		System.out.println("Change user INformation"+user);
		
		return "redirect:../view";
	}
	
	/**
	 * Check current password is same with given password by delegating to check password service
	 * @return true/false
	 */
	@RequestMapping(value = "/changepassword/checkCurrentPass", method = RequestMethod.POST)
	public @ResponseBody String checkCurrentPassword(String currPassValue){
		// Retrieve current user activity ;first login activitiy =false otherwise true
		String res = null;
		
		//System.out.println("cuurent password Check "+currPassValue);
        String username = getSessionUser();
		res = usrMngmentCRUDServiceIntrface.checkCurrentPassword(currPassValue, username);
		//System.out.println("Result: "+res);
		return res;
	}
	/**
	 * Mapping check New password with Repeat Password
	 * @return true/false
	 */
	@RequestMapping(value = "/changepassword/checkNewPass", method = RequestMethod.POST)
	public @ResponseBody String checkRepeatPassword(String newPassValue, String repeatPassValue){
		String s1, s2;
		@SuppressWarnings("unused")
		Integer comp;
		s1 = newPassValue;
		s2 = repeatPassValue;
		comp = s1.compareTo(s2);
		System.out.println("Strinf1: "+comp);
		if (comp==0)
			return "0";
			else
		return "1";
	}
}
