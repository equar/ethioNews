package com.ethionews.service;

import java.util.List;

import com.ethionews.model.User;
import com.ethionews.model.UserRole;

public interface UserService {
	public long createUser(User user);

	public User updateUser(User user);

	public List<User> getAllUsers();

	public User findByUsername(String username);

	public String findLoggedInUsername();

	public void autologin(String username, String password);
}
