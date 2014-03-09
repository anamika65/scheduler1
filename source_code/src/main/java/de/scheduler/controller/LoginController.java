package de.scheduler.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
public class LoginController {

	protected static Logger logger = Logger.getLogger("loginController");

	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginAdmin(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model) {
		logger.debug("Received request from login");
		if (error == true) {
			// Assign an error message
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}

		return "users/login";
	}

	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a
	 * regular user tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		logger.debug("Received request to show denied page");

		// This will resolve to /WEB-INF/jsp/users/deniedpage.jsp
		return "users/deniedpage";
	}
	
	@RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
	public String getLogoutSucess() {
		logger.debug("Received request to logout");

		// This will resolve to /WEB-INF/jsp/users/logoutSuccess.jsp
		return "users/logoutSuccess";
	}
	
	
}