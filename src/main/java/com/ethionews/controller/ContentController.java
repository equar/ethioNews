package com.ethionews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {

	@RequestMapping("aboutUs")
	public ModelAndView displayABoutUs() {
		return new ModelAndView("contentAboutUs");
	}

	@RequestMapping("faq")
	public ModelAndView displayFaq() {
		return new ModelAndView("contentFaq");
	}

	@RequestMapping("siteMap")
	public ModelAndView displaySiteMap() {
		return new ModelAndView("contentSiteMap");
	}

	@RequestMapping("termsOfUse")
	public ModelAndView displayTermsOfUse() {
		return new ModelAndView("contentTermsOfUse");
	}

	@RequestMapping("privacyPolicy")
	public ModelAndView displayPrivacyPolicy() {
		return new ModelAndView("contentPrivacyPolicy");
	}
}
