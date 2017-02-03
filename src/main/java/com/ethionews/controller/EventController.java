package com.ethionews.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.ClientLocation;
import com.ethionews.model.Event;
import com.ethionews.service.EventService;
import com.ethionews.util.EthioUtil;

@Controller
public class EventController {
	private static final Logger logger = Logger.getLogger(EventController.class);

	@Autowired
	@Qualifier("eventValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private EventService eventService;

	@RequestMapping("createEvent")
	public ModelAndView createEvent(@ModelAttribute Event event) {
		logger.info("Creating Event. Data: " + event);
		return new ModelAndView("eventForm");
	}

	@RequestMapping("editEvent")
	public ModelAndView editEvent(@RequestParam long id, @ModelAttribute Event event) {
		logger.info("Updating the Event for the Id " + id);
		event = eventService.getEvent(id);
		return new ModelAndView("eventForm", "eventObject", event);
	}

	@RequestMapping("saveEvent")
	public String saveEvent(Model model, @Validated Event event, @RequestParam("file") MultipartFile file,
			BindingResult result) {
		logger.info("Saving the Event. Data : " + event);
		// if event id is 0 then creating the event other updating the
		// event
		String returnVal = "redirect:getAllEvents";
		if (result.hasErrors()) {
			return "eventForm";
		} else {
			String filePath = EthioUtil.uploadFileToServer(file, "eventFiles");
			event.setImagePath(filePath);
			event.setStatus(false);

			if (event.getId() == 0) {
				eventService.createEvent(event);
			} else {
				eventService.updateEvent(event);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteEvent")
	public ModelAndView deleteEvent(@RequestParam long id) {
		logger.info("Deleting the Event. Id : " + id);
		eventService.deleteEvent(id);
		return new ModelAndView("redirect:getAllEvents");
	}

	@RequestMapping("getAllEvents")
	public ModelAndView getAllEvents() {
		logger.info("Getting the all Events.");
		List<Event> eventList = eventService.getAllEvents();
		return new ModelAndView("eventList", "eventList", eventList);
	}

	@RequestMapping("searchEvent")
	public ModelAndView searchEvent(@RequestParam("roleType") String roleType) {
		logger.info("Searching the Event. Event Names: " + roleType);
		List<Event> eventList = eventService.getAllEvents(roleType);
		return new ModelAndView("eventList", "evenList", eventList);
	}

	@RequestMapping("getPublicEvents")
	public ModelAndView getPublicVideos(HttpServletRequest request) {
		logger.info("Getting the all Videos.");
		List<Event> eventList = null;
		try {
			String ipAddress = EthioUtil.getClientIpAddress(request);
			ClientLocation client = EthioUtil.getLocation(ipAddress);

			eventList = eventService.getAllPublicEvents();
		} catch (IOException e) {
			logger.info("There is an exception in file:" + e);
		}
		return new ModelAndView("eventListPublic", "eventList", eventList);
	}

}
