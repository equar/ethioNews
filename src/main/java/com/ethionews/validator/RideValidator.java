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
		ValidationUtils.rejectIfEmpty(errors, "from", "ride.from");
		ValidationUtils.rejectIfEmpty(errors, "to", "ride.to");
		ValidationUtils.rejectIfEmpty(errors, "date", "ride.date");
		ValidationUtils.rejectIfEmpty(errors, "time", "ride.time");
		ValidationUtils.rejectIfEmpty(errors, "phonenumber", "ride.phonenumber");
	}
}
