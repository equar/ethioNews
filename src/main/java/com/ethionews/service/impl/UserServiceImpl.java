package com.ethionews.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.UserDao;
import com.ethionews.dao.UserRoleDao;
import com.ethionews.model.User;
import com.ethionews.model.UserRole;
import com.ethionews.service.UserService;
import com.ethionews.util.EthioUtil;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public long createUser(User user) {
		List<UserRole> roleList = userRoleDao.getAllUserRoles();
		user.setEnabled(false);
		Set<UserRole> userRoles = new HashSet<UserRole>(roleList);
		user.setUserRole(userRoles);
		// user.setPassword(EthioUtil.passwordEncoder(user.getPassword()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userDao.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUserName(username);
	}

}
