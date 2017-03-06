package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.User;

public interface UserDao {
	public long createUser(User user);

	public User updateUser(User user);

	public List<User> getAllUsers();

	public User findByUsername(String username);
}
