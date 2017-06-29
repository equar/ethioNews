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

import com.ethionews.model.Ride;
import com.ethionews.service.RideService;

@Controller
public class RideController {
	private static final Logger logger = Logger.getLogger(RideController.class);

	@Autowired
	@Qualifier("rideValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private RideService rideService;

	@RequestMapping("createRide")
	public ModelAndView createRide(@ModelAttribute Ride ride) {
		logger.info("Creating Ride. Data: " + ride);
		return new ModelAndView("rideForm");
	}

	@RequestMapping("editRide")
	public ModelAndView editRide(@RequestParam long id, @ModelAttribute Ride ride) {
		logger.info("Updating the Ride for the Id " + id);
		ride = rideService.getRide(id);
		return new ModelAndView("rideForm", "rideObject", ride);
	}

	@RequestMapping("saveRide")
	public String saveRide(Model model, @Validated Ride ride, BindingResult result) {
		logger.info("Saving the Media. Data : " + ride);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getAllRides";
		Date today = Calendar.getInstance().getTime();
		ride.setDate(today.toString());

		if (result.hasErrors()) {
			return "rideForm";
		} else {
			if (ride.getId() == 0) {
				rideService.createRide(ride);
			} else {
				rideService.updateRide(ride);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteRide")
	public ModelAndView deleteRide(@RequestParam long id) {
		logger.info("Deleting the Ride. Id : " + id);
		rideService.deleteRide(id);
		return new ModelAndView("redirect:getAllRides");
	}

	@RequestMapping("getAllRides")
	public ModelAndView getAllRides() {
		logger.info("Getting the all Rides.");
		List<Ride> rideList = rideService.getAllRides();
		return new ModelAndView("rideList", "rideList", rideList);
	}

	@RequestMapping("getPublicRides")
	public ModelAndView getPublicRides() {
		logger.info("Getting the all Rides.");
		List<Ride> rideList = rideService.getAllRides();
		return new ModelAndView("rideListPublic", "rideList", rideList);
	}

	@RequestMapping("searchRide")
	public ModelAndView searchRide(@RequestParam("title") String title) {
		logger.info("Searching the Ride. Ride Names: " + title);
		List<Ride> rideList = rideService.getAllRides(title);
		return new ModelAndView("rideList", "rideList", rideList);
	}

}
