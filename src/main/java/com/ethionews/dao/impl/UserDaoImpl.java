package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ethionews.dao.UserDao;
import com.ethionews.model.User;
import com.ethionews.model.UserRole;
import com.ethionews.model.User;
import com.ethionews.util.HibernateUtil;

@Repository("userDao")
@SessionAttributes("loggedUser")
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

		List<User> userObjects = hibernateUtil.fetchAllUser(Query);
		User user = null;
		for (User userObject : userObjects) {

			user = new User();

			user.setId(userObject.getId());
			user.setUsername(userObject.getUsername());
			user.setPassword(userObject.getPassword());
			user.setEnabled(userObject.isEnabled());
			user.setUserRoles(userObject.getUserRoles());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(String username) {
		String query = "SELECT e.* FROM User e WHERE e.username like '%" + username + "%'";
		List<Object[]> userObjects = hibernateUtil.fetchAll(query);
		List<User> users = new ArrayList<User>();
		long id;
		String email;
		for (Object[] userObject : userObjects) {
			User user = new User();
			id = ((BigInteger) userObject[0]).longValue();
			email = (String) userObject[3];

			user.setId(id);
			user.setUsername(email);
			users.add(user);
		}
		return users;
	}
}
