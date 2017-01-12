package com.ethionews.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.EventDao;
import com.ethionews.model.Event;
import com.ethionews.model.Video;
import com.ethionews.util.HibernateUtil;

@Repository("eventDao")
public class EventDaoImpl implements EventDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createEvent(Event event) {
		return (Long) hibernateUtil.create(event);
	}

	@Override
	public Event updateEvent(Event event) {
		return hibernateUtil.update(event);
	}

	@Override
	public void deleteEvent(long id) {
		Event event = new Event();
		event.setId(id);
		hibernateUtil.delete(event);

	}

	@Override
	public List<Event> getAllEvents() {
		return hibernateUtil.fetchAll(Event.class);
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
