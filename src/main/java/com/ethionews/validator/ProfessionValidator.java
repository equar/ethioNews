package com.ethionews.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Profession;

@Component("professionValidator")
public class ProfessionValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Profession.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "service.name");
		ValidationUtils.rejectIfEmpty(errors, "type", "service.type");
		ValidationUtils.rejectIfEmpty(errors, "address", "service.address");
		ValidationUtils.rejectIfEmpty(errors, "phonenumber", "service.phonenumber");
	}
}
