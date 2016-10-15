package com.ethionews.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.UserDao;
import com.ethionews.model.User;
import com.ethionews.util.HibernateUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createUser(User user) {
		return (Long) hibernateUtil.create(user);
	}
}
