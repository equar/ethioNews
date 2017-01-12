package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.EventDao;
import com.ethionews.dao.MediaDao;
import com.ethionews.model.Event;
import com.ethionews.service.EventService;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {
	@Autowired
	private EventDao eventDao;

	@Override
	public long createEvent(Event event) {
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
	public Event getEvent(long id) {
		// TODO Auto-generated method stub
		return null;
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

}
