package com.ethionews.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.EventDao;
import com.ethionews.dao.MediaDao;
import com.ethionews.model.Event;
import com.ethionews.model.Event;
import com.ethionews.service.EventService;
import com.ethionews.service.UserService;
import com.ethionews.util.EthioUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {
	@Autowired
	private EventDao eventDao;
	@Autowired
	private UserService userService;

	@Override
	public long createEvent(Event event) {
		event.setUser(userService.findLoggedUser());
		return eventDao.createEvent(event);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventDao.updateEvent(event);
	}

	@Override
	public void deleteEvent(long id) {
		eventDao.deleteEvent(id);

	}

	@Override
	public List<Event> getAllEvents() {
		return eventDao.getAllEvents();
	}

	@Override
	public List<Event> getAllPublicEvents() throws IOException {
		List<Event> imageEvents = eventDao.getAllEvents();
		return getAllEventsWithImage(imageEvents);
	}

	@Override
	public long enableEvent(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long disableEvent(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Event> getAllEvents(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAllEnabledEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAllDisabledEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Event> getAllEventsWithImage(List<Event> events) throws IOException {
		List<Event> imageEvents = new ArrayList<>();
		String base64Encoded;
		for (int i = 0; i < events.size(); i++) {
			Event event = new Event();
			base64Encoded = EthioUtil.getBase64Encoded(events.get(i).getImagePath());
			event.setId(events.get(i).getId());
			event.setType(events.get(i).getType());
			event.setAddress(events.get(i).getAddress());
			event.setImagePath(base64Encoded);
			event.setStatus(events.get(i).isStatus());

			imageEvents.add(event);
		}
		return imageEvents;
	}

	@Override
	public List<Event> getPublicEvents() {
		return eventDao.getPublicEvents();
	}

	@Override
	public List<Event> getUserEvents() {
		long userId = userService.findLoggedUser().getId();
		return eventDao.getUserEvents(userId);
	}

	@Override
	public Event getEvent(long id) {
		return eventDao.getEvent(id);
	}

	public List<Event> getPublicEvents(String search) {
		return eventDao.getPublicEvents(search);
	}

}
