package com.ethionews.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.User;
import com.ethionews.model.UserRole;
import com.ethionews.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUser(@ModelAttribute User user) {
		logger.info("Creating User. Data: " + user);
		return new ModelAndView("userForm");
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(Model model, @Validated User user, BindingResult result) {
		logger.info("Saving the Media. Data : " + user);
		// if media id is 0 then creating the media other updating the
		// media

		if (result.hasErrors()) {
			return new ModelAndView("userForm");
		}

		if (user.getId() == 0) {
			userService.createUser(user);
		} else {
			userService.updateUser(user);
		}

		userService.autologin(user.getUsername(), user.getPassword());

		return new ModelAndView("userCreated", "username", user.getUsername());
	}

	@RequestMapping(value = "/userCreated", method = RequestMethod.GET)
	public ModelAndView userCreated() {
		return new ModelAndView("userCreated");
	}

	@RequestMapping(value = "/userLoginDisplay", method = RequestMethod.GET)
	public String userLoginDisplay() {
		return "userLogin";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public ModelAndView userLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from ethioNews successfully.");
		}

		model.setViewName("userLogin");
		return model;
	}

	@RequestMapping(value = "/userLogout")
	public String userLogout(Model model, String error, String logout) {
		return "news";
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {
		logger.info("Getting the all Users.");
		List<User> userList = userService.getAllUsers();
		return new ModelAndView("userList", "userList", userList);
	}

}
