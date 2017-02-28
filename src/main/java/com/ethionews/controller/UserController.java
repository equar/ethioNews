package com.ethionews.controller;

import java.util.List;

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

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping("createUser")
	public ModelAndView createUser(@ModelAttribute User user) {
		logger.info("Creating User. Data: " + user);
		return new ModelAndView("userForm");
	}

	@RequestMapping("saveUser")
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

		// userDetailsService.autologin(user.getUsername(), user.getPassword());

		return new ModelAndView("userCreated", "username", user.getUsername());
	}

	@RequestMapping("userLogin")
	public ModelAndView userLogin(@ModelAttribute User user) {
		logger.info("Creating User. Data: " + user);
		return new ModelAndView("userLogin");
	}

	@RequestMapping("login")
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}

		if (logout != null) {
			model.addAttribute("message", "You have been logged out successfully.");
		}

		return "userLogin";
	}

	@RequestMapping("getAllUsers")
	public ModelAndView getAllUsers() {
		logger.info("Getting the all Users.");
		List<User> userList = userService.getAllUsers();
		return new ModelAndView("userList", "userList", userList);
	}

}
