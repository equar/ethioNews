package com.ethionews.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.UserRole;
import com.ethionews.service.UserRoleService;

@Controller
public class UserRoleController {

	private static final Logger logger = Logger.getLogger(UserRoleController.class);

	@Autowired
	@Qualifier("userRoleValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping("createUserRole")
	public ModelAndView createUserRole(@ModelAttribute UserRole userRole) {
		logger.info("Creating UserRole. Data: " + userRole);
		return new ModelAndView("userRoleForm");
	}

	@RequestMapping("editUserRole")
	public ModelAndView editUserRole(@RequestParam long id, @ModelAttribute UserRole userRole) {
		logger.info("Updating the UserRole for the Id " + id);
		userRole = userRoleService.getUserRole(id);
		return new ModelAndView("userRoleForm", "userRoleObject", userRole);
	}

	@RequestMapping("saveUserRole")
	public String saveUserRole(Model model, @Validated UserRole userRole, BindingResult result) {
		logger.info("Saving the UserRole. Data : " + userRole);
		// if userRole id is 0 then creating the userRole other updating the
		// userRole
		String returnVal = "redirect:getAllUserRoles";
		if (result.hasErrors()) {
			return "userRoleForm";
		} else {
			if (userRole.getId() == 0) {
				userRoleService.createUserRole(userRole);
			} else {
				userRoleService.updateUserRole(userRole);
			}
		}
		return returnVal;
	}

	@RequestMapping("deleteUserRole")
	public ModelAndView deleteUserRole(@RequestParam long id) {
		logger.info("Deleting the UserRole. Id : " + id);
		userRoleService.deleteUserRole(id);
		return new ModelAndView("redirect:getAllUserRoles");
	}

	@RequestMapping("getAllUserRoles")
	public ModelAndView getAllUserRoles() {
		logger.info("Getting the all UserRoles.");
		List<UserRole> userRoleList = userRoleService.getAllUserRoles();
		return new ModelAndView("userRoleList", "userRoleList", userRoleList);
	}

	@RequestMapping("searchUserRole")
	public ModelAndView searchUserRole(@RequestParam("roleType") String roleType) {
		logger.info("Searching the UserRole. UserRole Names: " + roleType);
		List<UserRole> userRoleList = userRoleService.getAllUserRoles(roleType);
		return new ModelAndView("userRoleList", "userRoleList", userRoleList);
	}

}
