package com.ethionews.service;

public interface MailService {

	public void sendEmail(final Object object);

	public String getMailBody(String templateName, String emailId);
}