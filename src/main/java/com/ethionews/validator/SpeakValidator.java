package com.ethionews.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Speak;

@Component("speakValidator")
public class SpeakValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Speak.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "rent.title");
		ValidationUtils.rejectIfEmpty(errors, "description", "rent.description");
		ValidationUtils.rejectIfEmpty(errors, "category", "rent.category");
		ValidationUtils.rejectIfEmpty(errors, "filename", "rent.filename");
	}
}
