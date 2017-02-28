package com.ethionews.dao.impl;

import java.util.List;

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
	public User findByUserName(String username) {
		String Query = "Select u.* from User u where u.username= " + username;
		List<User> users = hibernateUtil.fetchAll(Query);
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
}
