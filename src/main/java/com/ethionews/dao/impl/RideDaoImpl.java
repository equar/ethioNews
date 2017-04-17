package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.RideDao;
import com.ethionews.model.Media;
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
	public List<Ride> getAllRides() {
		return hibernateUtil.fetchAll(Ride.class);
	}

	@Override
	public Ride getRide(long id) {
		return hibernateUtil.fetchById(id, Ride.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ride> getAllRides(String search) {
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

}
