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

import com.ethionews.model.Rent;
import com.ethionews.service.RentService;

@Controller
public class RentController {
	private static final Logger logger = Logger.getLogger(RentController.class);

	@Autowired
	@Qualifier("rentValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private RentService rentService;

	@RequestMapping("createRent")
	public ModelAndView createRent(@ModelAttribute Rent rent) {
		logger.info("Creating Rent. Data: " + rent);
		return new ModelAndView("rentForm");
	}

	@RequestMapping("editRent")
	public ModelAndView editRent(@RequestParam long id, @ModelAttribute Rent rent) {
		logger.info("Updating the Rent for the Id " + id);
		rent = rentService.getRent(id);
		return new ModelAndView("rentForm", "rentObject", rent);
	}

	@RequestMapping("saveRent")
	public String saveRent(Model model, @Validated Rent rent, BindingResult result) {
		logger.info("Saving the Media. Data : " + rent);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getUserRents";

		if (result.hasErrors()) {
			return "rentForm";
		} else {
			if (rent.getId() == 0) {
				rentService.createRent(rent);
			} else {
				rentService.updateRent(rent);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteRent")
	public ModelAndView deleteRent(@RequestParam long id) {
		logger.info("Deleting the Rent. Id : " + id);
		rentService.deleteRent(id);
		return new ModelAndView("redirect:getAllRents");
	}

	@RequestMapping("getUserRents")
	public ModelAndView getAllRents() {
		logger.info("Getting the all Rents.");
		List<Rent> rentList = rentService.getUserRents();
		return new ModelAndView("rentList", "rentList", rentList);
	}

	@RequestMapping("getPublicRents")
	public ModelAndView getPublicRents() {
		logger.info("Getting the all Rents.");
		List<Rent> rentList = rentService.getAllRents();
		return new ModelAndView("rentListPublic", "rentList", rentList);
	}

	@RequestMapping("searchRent")
	public ModelAndView searchRent(@RequestParam("title") String title) {
		logger.info("Searching the Rent. Rent Names: " + title);
		List<Rent> rentList = rentService.getAllRents(title);
		return new ModelAndView("rentList", "rentList", rentList);
	}

}
