package com.ethionews.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Contact;
import com.ethionews.model.User;
import com.ethionews.util.EthioUtil;

@Component("contactValidator")
public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Contact.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Contact contact = (Contact) obj;

		ValidationUtils.rejectIfEmpty(errors, "name", "contact.name");
		ValidationUtils.rejectIfEmpty(errors, "email", "contact.email");
		ValidationUtils.rejectIfEmpty(errors, "subject", "contact.subject");
		ValidationUtils.rejectIfEmpty(errors, "message", "contact.message");
		if (!EthioUtil.isValidEmailAddress(contact.getName())) {
			errors.rejectValue("email", "contact.email.valid");
		}

	}
}
