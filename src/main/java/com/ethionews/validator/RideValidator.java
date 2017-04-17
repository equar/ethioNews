package com.ethionews.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Ride;

@Component("rideValidator")
public class RideValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Ride.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "ride.title");
		ValidationUtils.rejectIfEmpty(errors, "description", "ride.description");
		ValidationUtils.rejectIfEmpty(errors, "category", "ride.category");
		ValidationUtils.rejectIfEmpty(errors, "filename", "ride.filename");
	}
}
