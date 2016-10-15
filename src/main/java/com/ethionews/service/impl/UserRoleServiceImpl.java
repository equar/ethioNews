package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.UserRoleDao;
import com.ethionews.model.UserRole;
import com.ethionews.service.UserRoleService;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public long createUserRole(UserRole userRole) {
		return userRoleDao.createUserRole(userRole);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		return userRoleDao.updateUserRole(userRole);
	}

	@Override
	public void deleteUserRole(long id) {
		userRoleDao.deleteUserRole(id);

	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return userRoleDao.getAllUserRoles();
	}

	@Override
	public UserRole getUserRole(long id) {
		return userRoleDao.getUserRole(id);
	}

	@Override
	public List<UserRole> getAllUserRoles(String roleType) {
		return userRoleDao.getAllUserRoles(roleType);
	}

}
