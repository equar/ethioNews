package com.ethionews.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.User;
import com.ethionews.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("createUser")
	public ModelAndView createUser(@ModelAttribute User user) {
		logger.info("Creating User. Data: " + user);
		return new ModelAndView("userSignupForm");
	}

	@RequestMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		logger.info("Saving the User. Data : " + user);
		// if User id is 0 then creating the User other updating the
		// User
		if (user.getId() == 0) {
			userService.createUser(user);
		} /*
			 * else { busLevelService.updateBusLevel(busLevel); }
			 */

		return new ModelAndView("userSignupResult", "emailId", user.getEmail());
	}
}
