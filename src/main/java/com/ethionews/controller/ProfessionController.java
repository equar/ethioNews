package com.ethionews.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Profession;
import com.ethionews.service.ProfessionService;

@Controller
public class ProfessionController {
	private static final Logger logger = Logger.getLogger(ProfessionController.class);

	@Autowired
	@Qualifier("professionValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private ProfessionService professionService;

	@RequestMapping("createProfession")
	public ModelAndView createService(@ModelAttribute Profession profession) {
		logger.info("Creating Service. Data: " + profession);
		return new ModelAndView("professionForm");
	}

	@RequestMapping("editService")
	public ModelAndView editProfession(@RequestParam long id, @ModelAttribute Profession profession) {
		logger.info("Updating the Profession for the Id " + id);
		profession = professionService.getProfession(id);
		return new ModelAndView("professionForm", "professionObject", profession);
	}

	@RequestMapping("saveProfession")
	public String saveProfession(Model model, @Validated Profession profession, BindingResult result) {
		logger.info("Saving the Media. Data : " + profession);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getUserProfessions";

		if (result.hasErrors()) {
			return "professionForm";
		} else {
			if (profession.getId() == 0) {
				professionService.createProfession(profession);
			} else {
				professionService.updateProfession(profession);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteProfession")
	public ModelAndView deleteProfession(@RequestParam long id) {
		logger.info("Deleting the Profession. Id : " + id);
		professionService.deleteProfession(id);
		return new ModelAndView("redirect:getAllProfessions");
	}

	@RequestMapping("getUserProfessions")
	public ModelAndView getAllProfessions() {
		logger.info("Getting the all Professions.");
		List<Profession> professionList = professionService.getUserProfessions();
		return new ModelAndView("professionList", "professionList", professionList);
	}

	@RequestMapping("getPublicProfessions")
	public ModelAndView getPublicProfessions() {
		logger.info("Getting the all Professions.");
		List<Profession> professionList = professionService.getAllProfessions();
		return new ModelAndView("professionListPublic", "professionList", professionList);
	}

	@RequestMapping("searchProfession")
	public ModelAndView searchProfession(@RequestParam("title") String title) {
		logger.info("Searching the Profession. Profession Names: " + title);
		List<Profession> professionList = professionService.getAllProfessions(title);
		return new ModelAndView("professionList", "professionList", professionList);
	}

}
