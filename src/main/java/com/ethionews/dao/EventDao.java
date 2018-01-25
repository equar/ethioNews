package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Event;

public interface EventDao {
	public long createEvent(Event event);

	public Event updateEvent(Event event);

	public void deleteEvent(long id);

	public List<Event> getAllEvents();

	public Event getEvent(long id);

	public long enableEvent(long id);

	public long disableEvent(long id);

	public List<Event> getAllEvents(String search);

	public List<Event> getAllEnabledEvents();

	public List<Event> getAllDisabledEvents();

	public List<Event> getPublicEvents();

	public List<Event> getPublicEvents(String search);

	public List<Event> getUserEvents(long userId);

}
