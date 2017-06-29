package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.RentDao;
import com.ethionews.model.Rent;
import com.ethionews.service.RentService;
import com.ethionews.service.UserService;

@Service("rentService")
@Transactional
public class RentServiceImpl implements RentService {
	@Autowired
	private RentDao rentDao;
	@Autowired
	private UserService userService;

	@Override
	public long createRent(Rent rent) {
		rent.setUser(userService.findLoggedUser());
		return rentDao.createRent(rent);
	}

	@Override
	public Rent updateRent(Rent rent) {
		return rentDao.updateRent(rent);
	}

	@Override
	public void deleteRent(long id) {
		rentDao.deleteRent(id);

	}

	@Override
	public List<Rent> getAllRents() {
		return rentDao.getAllRents();
	}

	@Override
	public Rent getRent(long id) {
		return rentDao.getRent(id);
	}

	@Override
	public List<Rent> getAllRents(String search) {
		return rentDao.getAllRents(search);
	}

}
