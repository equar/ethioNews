package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.UserDao;
import com.ethionews.model.User;
import com.ethionews.model.UserRole;
import com.ethionews.util.HibernateUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createUser(User user) {
		return (Long) hibernateUtil.create(user);
	}

	@Override
	public User updateUser(User user) {
		return hibernateUtil.update(user);
	}

	@Override
	public List<User> getAllUsers() {
		return hibernateUtil.fetchAll(User.class);
	}

	@SuppressWarnings("unchecked")
	public User findByUsername(String userId) {
		String Query = "From User U where U.username= '" + userId + "'";
		// String Query = "select u from user u JOIN u.userrole r, UserAndRole
		// ur where ur.userid=u.id and ur.roleid=r.id and u.username= '" +
		// userId + "'";

		List<User> userObjects = hibernateUtil.fetchAllHql(Query);
		User user = null;
		long id;
		String username;
		String password;
		boolean isEnabled;
		Set<UserRole> userRole;
		for (User userObject : userObjects) {
			/*
			 * id = ((BigInteger) userObject[0]).longValue(); username =
			 * (String) userObject[3]; password = (String) userObject[2];
			 * isEnabled = (boolean) userObject[1]; userRole = (Set<UserRole>)
			 * userObject[4];
			 */
			user = new User();
			/*
			 * user.setId(id); user.setUsername(username);
			 * user.setPassword(password); user.setEnabled(isEnabled);
			 * user.setUserRole(userRole);
			 */
			user.setId(userObject.getId());
			user.setUsername(userObject.getUsername());
			user.setPassword(userObject.getPassword());
			user.setEnabled(userObject.isEnabled());
			user.setUserRoles(userObject.getUserRoles());
		}
		return user;
	}
}
