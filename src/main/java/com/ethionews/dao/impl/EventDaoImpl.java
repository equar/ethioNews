package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.EventDao;
import com.ethionews.model.Event;
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

	@Override
	public List<Event> getPublicEvents() {
		return hibernateUtil.fetchAll(Event.class);
	}

	@Override
	public Event getEvent(long id) {
		return hibernateUtil.fetchById(id, Event.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getPublicEvents(String search) {
		String query = "SELECT e.* FROM Event e WHERE e.title like '%" + search + "%'";
		List<Object[]> rideObjects = hibernateUtil.fetchAll(query);
		List<Event> rides = new ArrayList<Event>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] rideObject : rideObjects) {
			Event ride = new Event();
			id = ((BigInteger) rideObject[0]).longValue();
			title = (String) rideObject[5];
			description = (String) rideObject[3];
			category = (String) rideObject[1];
			filename = (String) rideObject[4];

			ride.setId(id);

			rides.add(ride);
		}

		return rides;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getUserEvents(long userId) {
		String query = "SELECT e.* FROM Event e WHERE e.userId=" + userId;
		List<Object[]> eventObjects = hibernateUtil.fetchAll(query);
		List<Event> events = new ArrayList<Event>();
		long id;
		String type;
		String description;
		String address;
		String city;
		String state;
		String zipCode;
		String country;
		String date;
		String time;
		String imagePath;
		Boolean status;
		for (Object[] eventObject : eventObjects) {
			Event event = new Event();
			id = ((BigInteger) eventObject[0]).longValue();
			type = (String) eventObject[10];
			description = (String) eventObject[5];
			address = (String) eventObject[1];
			city = (String) eventObject[2];
			state = (String) eventObject[7];
			zipCode = (String) eventObject[11];
			country = (String) eventObject[3];
			date = (String) eventObject[4];
			time = (String) eventObject[9];
			imagePath = (String) eventObject[6];
			status = (Boolean) eventObject[8];

			event.setId(id);
			event.setType(type);
			event.setDescription(description);
			event.setAddress(address);
			event.setCity(city);
			event.setState(state);
			event.setZipCode(zipCode);
			event.setCity(city);
			event.setCountry(country);
			event.setDate(date);
			event.setTime(time);
			event.setImagePath(imagePath);
			event.setStatus(status);

			events.add(event);
		}

		return events;
	}

}
