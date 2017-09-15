package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Rent;

public interface RentService {
	public long createRent(Rent rent);

	public Rent updateRent(Rent rent);

	public void deleteRent(long id);

	public List<Rent> getUserRents();

	public List<Rent> getAllRents();

	public Rent getRent(long id);

	public List<Rent> getAllRents(String search);
}
