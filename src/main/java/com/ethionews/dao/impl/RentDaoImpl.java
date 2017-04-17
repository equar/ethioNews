package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.RentDao;
import com.ethionews.model.Media;
import com.ethionews.model.User;
import com.ethionews.model.Rent;
import com.ethionews.util.HibernateUtil;

@Repository("rentDao")
public class RentDaoImpl implements RentDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createRent(Rent rent) {
		return (Long) hibernateUtil.create(rent);
	}

	@Override
	public Rent updateRent(Rent rent) {
		return hibernateUtil.update(rent);
	}

	@Override
	public void deleteRent(long id) {
		Rent rent = new Rent();
		rent.setId(id);
		hibernateUtil.delete(rent);
	}

	@Override
	public List<Rent> getAllRents() {
		return hibernateUtil.fetchAll(Rent.class);
	}

	@Override
	public Rent getRent(long id) {
		return hibernateUtil.fetchById(id, Rent.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rent> getAllRents(String search) {
		String query = "SELECT e.* FROM Rent e WHERE e.title like '%" + search + "%'";
		List<Object[]> rentObjects = hibernateUtil.fetchAll(query);
		List<Rent> rents = new ArrayList<Rent>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] rentObject : rentObjects) {
			Rent rent = new Rent();
			id = ((BigInteger) rentObject[0]).longValue();
			title = (String) rentObject[5];
			description = (String) rentObject[3];
			category = (String) rentObject[1];
			filename = (String) rentObject[4];

			rent.setId(id);
			

			rents.add(rent);
		}

		return rents;
	}

}
