package com.ethionews.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	 */

	@Override
	public long createUser(User user) {
		List<UserRole> roleList = userRoleDao.getAllUserRoles();
		user.setEnabled(true);
		Set<UserRole> userRoles = new HashSet<UserRole>(roleList);
		user.setUserRoles(userRoles);
		user.setPassword(EthioUtil.passwordEncoder(user.getPassword()));

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
		return userDao.findByUsername(username);
	}

	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}

		return null;
	}

	public void autologin(String username, String password) {
		/*
		 * try { UserDetails userDetails =
		 * userDetailsService.loadUserByUsername(username);
		 * UsernamePasswordAuthenticationToken
		 * usernamePasswordAuthenticationToken = new
		 * UsernamePasswordAuthenticationToken( userDetails, password,
		 * userDetails.getAuthorities());
		 * 
		 * authenticationManager.authenticate(
		 * usernamePasswordAuthenticationToken);
		 * 
		 * if (usernamePasswordAuthenticationToken.isAuthenticated()) {
		 * SecurityContextHolder.getContext().setAuthentication(
		 * usernamePasswordAuthenticationToken); logger.debug(String.format(
		 * "Auto login %s successfully!", username)); } } catch (Exception e) {
		 * logger.info("Exception: " + e.getMessage()); }
		 */
	}

}
