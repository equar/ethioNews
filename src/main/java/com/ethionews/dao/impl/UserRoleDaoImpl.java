package com.ethionews.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.UserRoleDao;
import com.ethionews.model.User;
import com.ethionews.model.UserRole;
import com.ethionews.util.HibernateUtil;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createUserRole(UserRole userRole) {
		return (Long) hibernateUtil.create(userRole);
	}

	@Override
	public UserRole updateUserRole(UserRole userRole) {
		return hibernateUtil.update(userRole);
	}

	@Override
	public void deleteUserRole(long id) {
		UserRole userRole = new UserRole();
		userRole.setId(id);
		User user = new User();
		user.setId(id);
		hibernateUtil.delete(id, User.class);
		hibernateUtil.delete(userRole);

	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return hibernateUtil.fetchAll(UserRole.class);
	}

	@Override
	public UserRole getUserRole(long id) {
		return hibernateUtil.fetchById(id, UserRole.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllUserRoles(String roleType) {
		String query = "SELECT e.* FROM UserRole e WHERE e.roleType like '%" + roleType + "%'";
		List<Object[]> userRoleObjects = hibernateUtil.fetchAll(query);
		List<UserRole> userRoles = new ArrayList<UserRole>();
		for (Object[] userRoleObject : userRoleObjects) {
			UserRole userRole = new UserRole();
			long roleId = ((long) userRoleObject[0]);
			String roleName = (String) userRoleObject[1];
			userRole.setId(roleId);
			userRole.setRoleType(roleName);
			userRoles.add(userRole);
		}
		System.out.println(userRoles);
		return userRoles;
	}

}
