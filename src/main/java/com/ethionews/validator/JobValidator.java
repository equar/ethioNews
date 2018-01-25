package com.ethionews.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Job;

@Component("jobValidator")
public class JobValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Job.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "job.title");

	}
}
