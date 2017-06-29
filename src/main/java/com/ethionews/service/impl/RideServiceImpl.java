package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.RideDao;
import com.ethionews.model.Ride;
import com.ethionews.service.RideService;
import com.ethionews.service.UserService;

@Service("rideService")
@Transactional
public class RideServiceImpl implements RideService {
	@Autowired
	private RideDao rideDao;
	@Autowired
	private UserService userService;

	@Override
	public long createRide(Ride ride) {
		ride.setUser(userService.findLoggedUser());
		return rideDao.createRide(ride);
	}

	@Override
	public Ride updateRide(Ride ride) {
		return rideDao.updateRide(ride);
	}

	@Override
	public void deleteRide(long id) {
		rideDao.deleteRide(id);

	}

	@Override
	public List<Ride> getAllRides() {
		return rideDao.getAllRides();
	}

	@Override
	public Ride getRide(long id) {
		return rideDao.getRide(id);
	}

	@Override
	public List<Ride> getAllRides(String search) {
		return rideDao.getAllRides(search);
	}

}
