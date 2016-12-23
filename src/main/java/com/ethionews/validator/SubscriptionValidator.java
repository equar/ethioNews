package com.ethionews.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Subscription;

public class SubscriptionValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Subscription.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "subscription.name");
		ValidationUtils.rejectIfEmpty(errors, "email", "subscription.email");
		ValidationUtils.rejectIfEmpty(errors, "frequency", "subscription.frequency");
	}
}