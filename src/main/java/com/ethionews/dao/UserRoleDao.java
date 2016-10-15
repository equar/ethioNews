package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.UserRole;

public interface UserRoleDao {
	public long createUserRole(UserRole userRole);

	public UserRole updateUserRole(UserRole userRole);

	public void deleteUserRole(long id);

	public List<UserRole> getAllUserRoles();

	public UserRole getUserRole(long id);

	public List<UserRole> getAllUserRoles(String roleType);
}
