package com.ethionews.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Mail;
import com.ethionews.model.User;
import com.ethionews.service.MailService;
import com.ethionews.service.UserService;
import com.ethionews.util.EthioUtil;
import com.ethionews.validator.UserPasswordChangeValidator;
import com.ethionews.validator.UserPasswordResetValidator;
import com.ethionews.validator.UserRegistrationValidator;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserRegistrationValidator userRegistrationValidator;
	@Autowired
	private UserPasswordResetValidator userPasswordResetValidator;
	@Autowired
	private UserPasswordChangeValidator userPasswordChangeValidator;

	@Autowired
	private MailService mailService;

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
		userRegistrationValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("userForm");
		}

		if (user.getId() == 0) {
			userService.createUser(user);
		} else {
			userService.updateUser(user);
		}

		// userService.autologin(user.getUsername(), user.getPassword());

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

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("accessDenied");
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {
		logger.info("Getting all Users.");
		List<User> userList = userService.getAllUsers();
		return new ModelAndView("userList", "userList", userList);
	}

	@RequestMapping(value = "/getEnabledUsers", method = RequestMethod.GET)
	public ModelAndView getEnabledUsers() {
		logger.info("Getting  all enabled Users.");
		List<User> userList = userService.getAllUsers();
		List<User> filteredUserList = userList.stream().filter(user -> user.isEnabled() == true)
				.collect(Collectors.toList());
		return new ModelAndView("userList", "userList", filteredUserList);
	}

	@RequestMapping(value = "/getDisabledUsers", method = RequestMethod.GET)
	public ModelAndView getDisabledUsers() {
		logger.info("Getting all disabled Users.");
		List<User> userList = userService.getAllUsers();
		List<User> filteredUserList = userList.stream().filter(user -> user.isEnabled() == false)
				.collect(Collectors.toList());
		return new ModelAndView("userList", "userList", filteredUserList);
	}

	@RequestMapping(value = "/enableUser", method = RequestMethod.GET)
	public String enableUser(@RequestParam String id, @RequestParam boolean action) {
		logger.info("Getting all Users.");
		User user = userService.findByUsername(id);
		user.setEnabled(action);
		userService.enableOrDisableUser(user);

		return "redirect:getAllUsers";
	}

	@RequestMapping(value = "/disableUser", method = RequestMethod.GET)
	public String disableUser(@RequestParam String id, @RequestParam boolean action) {
		logger.info("Getting all Users.");
		User user = userService.findByUsername(id);
		user.setEnabled(action);
		userService.enableOrDisableUser(user);

		return "redirect:getAllUsers";
	}

	@RequestMapping("searchUser")
	public ModelAndView searchUser(@RequestParam("username") String username) {
		logger.info("Searching the User. User Names: " + username);
		List<User> userList = userService.getAllUsers(username);
		return new ModelAndView("userList", "userList", userList);
	}

	@RequestMapping(value = "/sessionExpired", method = RequestMethod.GET)
	public ModelAndView sessionExpired() {
		return new ModelAndView("sessionExpired");
	}

	@RequestMapping(value = "/invalidSession", method = RequestMethod.GET)
	public ModelAndView invalidSession() {
		return new ModelAndView("invalidSession");
	}

	@RequestMapping(value = "/passwordReset", method = RequestMethod.GET)
	public ModelAndView passwordEmailVerify(@ModelAttribute User user) {
		return new ModelAndView("passwordReset");
	}

	@RequestMapping(value = "/passwordReset", method = RequestMethod.POST)
	public ModelAndView passwordEmailVerify(Model model, @Validated User user, BindingResult result) {
		userPasswordResetValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("passwordReset");
		}

		// update the user with the new password
		String newPassword = EthioUtil.generatePassword();
		// update old password with the new one
		User updatedUser = userService.findByUsername(user.getUsername());
		updatedUser.setPassword(newPassword);
		userService.updateUser(updatedUser);

		// send password reset instruction mail to user
		mailService.sendPasswordResetEmail(user, newPassword);

		return new ModelAndView("passwordResetEmailSent", "username", user.getUsername());
	}

	@RequestMapping(value = "/passwordChange", method = RequestMethod.GET)
	public ModelAndView passwordChange(@ModelAttribute User user) {
		logger.info("Change Password form rendered");
		return new ModelAndView("passwordChange");
	}

	@RequestMapping(value = "/passwordChange", method = RequestMethod.POST)
	public ModelAndView passwordChange(Model model, @Validated User user, BindingResult result) {
		logger.info("Updating password for : " + user);

		userPasswordChangeValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("passwordChange");
		}

		String username = userService.findLoggedInUsername();
		if (null == username) {
			return new ModelAndView("passwordChange", "message", "Your session has been expired. Please Login again");
		}
		User loggedUser = userService.findByUsername(username);
		loggedUser.setPassword(user.getPassword());

		userService.updateUser(loggedUser);

		return new ModelAndView("passwordChange", "message", "Your password has been updated succesfully");
	}

	@RequestMapping(value = "/newPassword", method = RequestMethod.GET)
	public ModelAndView resetPassword(@RequestParam String newPassword, Map<String, String> model) {
		String emailId = EthioUtil.getDecodedFromBase64(newPassword);
		User loggedUser = userService.findByUsername(emailId);
		if (null == loggedUser) {
			return new ModelAndView("passwordChange", "message",
					"The Link has been expired. Please try to reset your password again");
		}
		model.put("emailid", emailId);
		return new ModelAndView("passwordChange");
	}

}
