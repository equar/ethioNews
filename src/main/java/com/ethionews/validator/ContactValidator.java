package com.ethionews.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Contact;

@Component("contactValidator")
public class ContactValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean supports(Class<?> paramClass) {
		return Contact.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "contact.name");
		ValidationUtils.rejectIfEmpty(errors, "email", "contact.email");
		ValidationUtils.rejectIfEmpty(errors, "subject", "contact.subject");
		ValidationUtils.rejectIfEmpty(errors, "message", "contact.message");
		/*if (obj != null) {
			Contact contact = (Contact) obj;
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(contact.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "Email is invalid");
			}
		}*/
	}
}
