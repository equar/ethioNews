package com.ethionews.service.impl;

import java.io.StringWriter;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.ethionews.model.Mail;
import com.ethionews.model.User;
import com.ethionews.service.MailService;
import com.ethionews.util.EthioUtil;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	VelocityEngine velocityEngine;

	@Override
	public void sendEmail(Object object) {

		Mail mail = (Mail) object;

		MimeMessagePreparator preparator = getMessagePreparator(mail);

		try {
			mailSender.send(preparator);
			System.out.println("Message has been sent");
		} catch (MailException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private MimeMessagePreparator getMessagePreparator(final Mail mail) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setFrom(mail.getMailFrom());
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getMailTo()));
				mimeMessage.setText(mail.getMailContent());
				mimeMessage.setSubject(mail.getMailSubject());
			}
		};
		return preparator;
	}

	public String getPasswordResetBody(String templateName, String newPassword) {
		velocityEngine.init();
		Template template = velocityEngine.getTemplate("./mailTemplates/" + templateName);
		// String encodedEmail = EthioUtil.getEncodedToBase64(emailId);
		// String url = "http://localhost:8080/newPassword?newPassword=" +
		// encodedEmail;

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("name", "EthioNews  User");
		velocityContext.put("newPassword", newPassword);

		StringWriter stringWriter = new StringWriter();

		template.merge(velocityContext, stringWriter);

		return stringWriter.toString();
	}

	public void sendPasswordResetEmail(User user, String newPassword) {
		String templateName = "resetPassword.vm";
		Mail mail = new Mail();
		mail.setMailFrom("support@sidrabook.com");
		mail.setMailTo(user.getUsername());
		mail.setMailSubject("Password Reset Instructions");
		mail.setTemplateName("resetPassword.vm");
		mail.setMailContent(getPasswordResetBody(templateName, newPassword));
		sendEmail(mail);
	}

}