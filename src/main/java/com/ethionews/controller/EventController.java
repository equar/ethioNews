package com.ethionews.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Event;
import com.ethionews.model.Video;
import com.ethionews.service.EventService;

@Controller
public class EventController {
	private static final Logger logger = Logger.getLogger(EventController.class);

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
	public ModelAndView saveEvent(@ModelAttribute Event event, @RequestParam("file") MultipartFile file) {
		logger.info("Saving the Event. Data : " + event);
		// if event id is 0 then creating the event other updating the
		// event
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "eventFiles");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				event.setImagePath(serverFile.toString());
				event.setStatus(false);

				if (event.getId() == 0) {
					eventService.createEvent(event);
				} else {
					eventService.updateEvent(event);
				}

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}

		return new ModelAndView("redirect:getAllEvents");
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
	public ModelAndView getPublicVideos() {
		logger.info("Getting the all Videos.");
		List<Event> eventList = eventService.getAllEvents();
		return new ModelAndView("eventListPublic", "eventList", eventList);
	}

}
