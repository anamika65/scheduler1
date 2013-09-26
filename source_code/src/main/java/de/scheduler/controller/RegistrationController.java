package de.scheduler.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.scheduler.model.User;
import de.scheduler.model.UserRole;
import de.scheduler.service.UserRegistrationService;

/**
 * @author AnamikaChowdhury
 *
 */
@Controller
public class RegistrationController {
	
	@Resource(name = "userRegistrationService")
	private UserRegistrationService userRgistrationService;
	
	
	protected static Logger logger = Logger.getLogger("loginController");
	
	
	/**
	 * User Registration Form
	 * Insert into User Table as well as User_Roles Table
	 * @param username
	 * @param password
	 * @param user_role
	 * @return Redirect to login
	 */
	@RequestMapping(value = "/login/add", method = RequestMethod.POST)
	public String getNewUser(
			@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password,
			@RequestParam(value="user_role", required=true) String user_role
			) {
		logger.debug("Received request for registration");
		
		//Add a new User
		
		User user = new User();
		user.setActive(true);
		user.setUsername(username);
		user.setPassword(password);
		userRgistrationService.addUser(user);
		
		Integer userNewId = user.getId();
		//Add User Roles
		UserRole user_Role = new UserRole();
		user_Role.setRole(user_role);
		user_Role.setUser(user);
		userRgistrationService.addUserRole(user_Role);

		// This will resolve to /WEB-INF/jsp/users/logoutSuccess.jsp
		return "redirect:../administration/crud";
	}
	
	
}
