package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Ride;

public interface RideDao {
	public long createRide(Ride ride);

	public Ride updateRide(Ride ride);

	public void deleteRide(long id);

	public List<Ride> getAllRides();

	public Ride getRide(long id);

	public List<Ride> getAllRides(String search);
}
