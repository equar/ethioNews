package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.RideDao;
import com.ethionews.model.Media;
import com.ethionews.model.Ride;
import com.ethionews.model.User;
import com.ethionews.model.Ride;
import com.ethionews.util.HibernateUtil;

@Repository("rideDao")
public class RideDaoImpl implements RideDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createRide(Ride ride) {
		return (Long) hibernateUtil.create(ride);
	}

	@Override
	public Ride updateRide(Ride ride) {
		return hibernateUtil.update(ride);
	}

	@Override
	public void deleteRide(long id) {
		Ride ride = new Ride();
		ride.setId(id);
		hibernateUtil.delete(ride);
	}

	@Override
	public List<Ride> getPublicRides() {
		return hibernateUtil.fetchAll(Ride.class);
	}

	@Override
	public Ride getRide(long id) {
		return hibernateUtil.fetchById(id, Ride.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ride> getPublicRides(String search) {
		String query = "SELECT e.* FROM Ride e WHERE e.title like '%" + search + "%'";
		List<Object[]> rideObjects = hibernateUtil.fetchAll(query);
		List<Ride> rides = new ArrayList<Ride>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] rideObject : rideObjects) {
			Ride ride = new Ride();
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
	public List<Ride> getUserRides(long userId) {
		String query = "SELECT e.* FROM Ride e WHERE e.userId=" + userId;
		List<Object[]> rideObjects = hibernateUtil.fetchAll(query);
		List<Ride> rides = new ArrayList<Ride>();
		long id;
		String date;
		String description;
		String from;
		String phonenumber;
		String time;
		String to;
		for (Object[] rideObject : rideObjects) {
			Ride ride = new Ride();
			id = ((BigInteger) rideObject[0]).longValue();
			date = (String) rideObject[1];
			description = (String) rideObject[2];
			from = (String) rideObject[3];
			phonenumber = (String) rideObject[4];
			time = (String) rideObject[5];
			to = (String) rideObject[6];

			ride.setId(id);
			ride.setDate(date);
			ride.setDescription(description);
			ride.setFrom(from);
			ride.setPhonenumber(phonenumber);
			ride.setTime(time);
			ride.setTo(to);

			rides.add(ride);
		}

		return rides;
	}

}
