package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.ProfessionDao;
import com.ethionews.model.Profession;
import com.ethionews.model.Profession;
import com.ethionews.util.HibernateUtil;

@Repository("professionDao")
public class ProfessionDaoImpl implements ProfessionDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createProfession(Profession profession) {
		return (Long) hibernateUtil.create(profession);
	}

	@Override
	public Profession updateProfession(Profession profession) {
		return hibernateUtil.update(profession);
	}

	@Override
	public void deleteProfession(long id) {
		Profession profession = new Profession();
		profession.setId(id);
		hibernateUtil.delete(profession);
	}

	@Override
	public List<Profession> getAllProfessions() {
		return hibernateUtil.fetchAll(Profession.class);
	}

	@Override
	public Profession getProfession(long id) {
		return hibernateUtil.fetchById(id, Profession.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profession> getAllProfessions(String search) {
		String query = "SELECT e.* FROM Profession e WHERE e.title like '%" + search + "%'";
		List<Object[]> professionObjects = hibernateUtil.fetchAll(query);
		List<Profession> professions = new ArrayList<Profession>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] professionObject : professionObjects) {
			Profession profession = new Profession();
			id = ((BigInteger) professionObject[0]).longValue();
			title = (String) professionObject[5];
			description = (String) professionObject[3];
			category = (String) professionObject[1];
			filename = (String) professionObject[4];

			profession.setId(id);

			professions.add(profession);
		}

		return professions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profession> getUserProfessions(long userId) {
		String query = "SELECT e.* FROM Profession e WHERE e.userId=" + userId;
		List<Object[]> professionObjects = hibernateUtil.fetchAll(query);
		List<Profession> professions = new ArrayList<Profession>();
		long id;
		String address;
		String description;
		String name;
		String phonenumber;
		String type;
		String website;
		for (Object[] professionObject : professionObjects) {
			Profession profession = new Profession();
			id = ((BigInteger) professionObject[0]).longValue();
			address = (String) professionObject[1];
			description = (String) professionObject[2];
			name = (String) professionObject[3];
			phonenumber = (String) professionObject[4];
			type = (String) professionObject[5];
			website = (String) professionObject[6];

			profession.setId(id);
			profession.setAddress(address);
			profession.setDescription(description);
			profession.setName(name);
			profession.setPhonenumber(phonenumber);
			profession.setType(type);
			profession.setWebsite(website);

			professions.add(profession);
		}

		return professions;
	}

}
