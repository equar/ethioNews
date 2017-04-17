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

import com.ethionews.model.Service;
import com.ethionews.service.ServiceService;

@Controller
public class ServiceController {
	private static final Logger logger = Logger.getLogger(ServiceController.class);

	@Autowired
	@Qualifier("serviceValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private ServiceService serviceService;

	@RequestMapping("createService")
	public ModelAndView createService(@ModelAttribute Service service) {
		logger.info("Creating Service. Data: " + service);
		return new ModelAndView("serviceForm");
	}

	@RequestMapping("editService")
	public ModelAndView editService(@RequestParam long id, @ModelAttribute Service service) {
		logger.info("Updating the Service for the Id " + id);
		service = serviceService.getService(id);
		return new ModelAndView("serviceForm", "serviceObject", service);
	}

	@RequestMapping("saveService")
	public String saveService(Model model, @Validated Service service, BindingResult result) {
		logger.info("Saving the Media. Data : " + service);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getAllServices";
		Date today = Calendar.getInstance().getTime();

		if (result.hasErrors()) {
			return "serviceForm";
		} else {
			if (service.getId() == 0) {
				serviceService.createService(service);
			} else {
				serviceService.updateService(service);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteService")
	public ModelAndView deleteService(@RequestParam long id) {
		logger.info("Deleting the Service. Id : " + id);
		serviceService.deleteService(id);
		return new ModelAndView("redirect:getAllServices");
	}

	@RequestMapping("getAllServices")
	public ModelAndView getAllServices() {
		logger.info("Getting the all Services.");
		List<Service> serviceList = serviceService.getAllServices();
		return new ModelAndView("serviceList", "serviceList", serviceList);
	}

	@RequestMapping("getPublicServices")
	public ModelAndView getPublicServices() {
		logger.info("Getting the all Services.");
		List<Service> serviceList = serviceService.getAllServices();
		return new ModelAndView("serviceListPublic", "serviceList", serviceList);
	}

	@RequestMapping("searchService")
	public ModelAndView searchService(@RequestParam("title") String title) {
		logger.info("Searching the Service. Service Names: " + title);
		List<Service> serviceList = serviceService.getAllServices(title);
		return new ModelAndView("serviceList", "serviceList", serviceList);
	}

}
