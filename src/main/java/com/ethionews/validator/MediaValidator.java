package com.ethionews.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ethionews.model.Media;
import com.ethionews.model.User;
import com.ethionews.service.MediaService;
import com.ethionews.service.UserService;

@Component("mediaValidator")
public class MediaValidator implements Validator {
	@Autowired
	private MediaService mediaService;

	@Override
	public boolean supports(Class<?> paramClass) {
		return Media.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Media media = (Media) obj;
		if (mediaService.findByURL(media.getUrl()) != null) {
			errors.rejectValue("url", "media.url.duplicate");
		}

		ValidationUtils.rejectIfEmpty(errors, "name", "media.name");
		ValidationUtils.rejectIfEmpty(errors, "url", "media.url");
		// ValidationUtils.rejectIfEmpty(errors, "type", "media.type");
		// ValidationUtils.rejectIfEmpty(errors, "language", "media.language");
		// ValidationUtils.rejectIfEmpty(errors, "country", "media.country");
		// ValidationUtils.rejectIfEmpty(errors, "crawel", "media.crawel");
	}

}
