package com.ethionews.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Video;

@Component("videoValidator")
public class VideoValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Video.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "video.title");
		ValidationUtils.rejectIfEmpty(errors, "description", "video.description");
		ValidationUtils.rejectIfEmpty(errors, "category", "video.category");
		ValidationUtils.rejectIfEmpty(errors, "filename", "video.filename");
	}
}
