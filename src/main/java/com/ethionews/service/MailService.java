package com.ethionews.service;

import com.ethionews.model.User;

public interface MailService {

	public void sendEmail(final Object object);

	public String getPasswordResetBody(String templateName, String emailId);

	public void sendPasswordResetEmail(User user, String newPassword);
}