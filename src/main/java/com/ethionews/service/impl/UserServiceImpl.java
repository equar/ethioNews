package com.ethionews.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.UserDao;
import com.ethionews.model.User;
import com.ethionews.model.UserRole;
import com.ethionews.service.UserService;
import com.ethionews.util.EthioUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public long createUser(User user) {
		Set<UserRole> userRoles = new HashSet<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setRoleType("roleTypes");

		userRoles.add(userRole);
		//user.setUserRole(userRoles);
		user.setPassword(EthioUtil.passwordEncoder(user.getPassword()));

		return userDao.createUser(user);
	}
}
