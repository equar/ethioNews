package com.ethionews.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Advertisement;

@Controller
public class AdvertisementController {
	private static final Logger logger = Logger.getLogger(AdvertisementController.class);

	/*
	 * @Autowired private MediaService mediaService;
	 */

	@RequestMapping("createAdvert")
	public ModelAndView createAdvert(@ModelAttribute Advertisement advertisement) {
		logger.info("Creating Advertisement. Data: " + advertisement);
		return new ModelAndView("advertForm");
	}

}
