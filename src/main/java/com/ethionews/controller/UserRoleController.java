package com.ethionews.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView saveUserRole(@ModelAttribute UserRole userRole) {
		logger.info("Saving the UserRole. Data : " + userRole);
		// if userRole id is 0 then creating the userRole other updating the
		// userRole
		if (userRole.getId() == 0) {
			userRoleService.createUserRole(userRole);
		} else {
			userRoleService.updateUserRole(userRole);
		}
		return new ModelAndView("redirect:getAllUserRoles");
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
