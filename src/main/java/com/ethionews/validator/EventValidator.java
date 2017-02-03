package com.ethionews.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Event;

@Component("eventValidator")
public class EventValidator implements Validator {
	@Override
	public boolean supports(Class<?> paramClass) {
		return Event.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "type", "event.type");
		ValidationUtils.rejectIfEmpty(errors, "description", "event.description");
		ValidationUtils.rejectIfEmpty(errors, "address", "event.address");
		ValidationUtils.rejectIfEmpty(errors, "city", "event.city");
		ValidationUtils.rejectIfEmpty(errors, "state", "event.state");
		ValidationUtils.rejectIfEmpty(errors, "zipCode", "event.zipCode");
		ValidationUtils.rejectIfEmpty(errors, "country", "event.country");
		ValidationUtils.rejectIfEmpty(errors, "date", "event.date");
		ValidationUtils.rejectIfEmpty(errors, "time", "event.time");
	}
}
