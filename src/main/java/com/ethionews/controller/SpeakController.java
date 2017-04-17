package com.ethionews.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Speak;
import com.ethionews.service.SpeakService;

@Controller
public class SpeakController {
	private static final Logger logger = Logger.getLogger(SpeakController.class);

	@Autowired
	@Qualifier("speakValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private SpeakService speakService;

	@RequestMapping("createSpeak")
	public ModelAndView createSpeak(@ModelAttribute Speak speak) {
		logger.info("Creating Speak. Data: " + speak);
		return new ModelAndView("speakForm");
	}

	@RequestMapping("editSpeak")
	public ModelAndView editSpeak(@RequestParam long id, @ModelAttribute Speak speak) {
		logger.info("Updating the Speak for the Id " + id);
		speak = speakService.getSpeak(id);
		return new ModelAndView("speakForm", "speakObject", speak);
	}

	@RequestMapping("saveSpeak")
	public String saveSpeak(Model model, @Validated Speak speak, BindingResult result) {
		logger.info("Saving the Media. Data : " + speak);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getAllSpeaks";
		Date today = Calendar.getInstance().getTime();

		if (result.hasErrors()) {
			return "speakForm";
		} else {
			if (speak.getId() == 0) {
				speakService.createSpeak(speak);
			} else {
				speakService.updateSpeak(speak);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteSpeak")
	public ModelAndView deleteSpeak(@RequestParam long id) {
		logger.info("Deleting the Speak. Id : " + id);
		speakService.deleteSpeak(id);
		return new ModelAndView("redirect:getAllSpeaks");
	}

	@RequestMapping("getAllSpeaks")
	public ModelAndView getAllSpeaks() {
		logger.info("Getting the all Speaks.");
		List<Speak> speakList = speakService.getAllSpeaks();
		return new ModelAndView("speakList", "speakList", speakList);
	}

	@RequestMapping("getPublicSpeaks")
	public ModelAndView getPublicSpeaks() {
		logger.info("Getting the all Speaks.");
		List<Speak> speakList = speakService.getAllSpeaks();
		return new ModelAndView("speakListPublic", "speakList", speakList);
	}

	@RequestMapping("searchSpeak")
	public ModelAndView searchSpeak(@RequestParam("title") String title) {
		logger.info("Searching the Speak. Speak Names: " + title);
		List<Speak> speakList = speakService.getAllSpeaks(title);
		return new ModelAndView("speakList", "speakList", speakList);
	}

}
