package com.ethionews.service;

import java.io.IOException;
import java.util.List;

import com.ethionews.model.Event;
import com.ethionews.model.Job;

public interface EventService {
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

	List<Event> getAllPublicEvents() throws IOException;

	public List<Event> getUserEvents();

	public List<Event> getPublicEvents();
}
