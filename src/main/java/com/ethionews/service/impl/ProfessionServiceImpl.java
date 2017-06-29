package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.ProfessionDao;
import com.ethionews.model.Profession;
import com.ethionews.service.ProfessionService;
import com.ethionews.service.UserService;

@Service("professionService")
@Transactional
public class ProfessionServiceImpl implements ProfessionService {
	@Autowired
	private ProfessionDao professionDao;
	@Autowired
	private UserService userService;

	public long createProfession(Profession profession) {
		profession.setUser(userService.findLoggedUser());
		return professionDao.createProfession(profession);
	}

	public Profession updateProfession(Profession profession) {
		return professionDao.updateProfession(profession);
	}

	@Override
	public void deleteProfession(long id) {
		professionDao.deleteProfession(id);

	}

	public List<Profession> getAllProfessions() {
		return professionDao.getAllProfessions();
	}

	public Profession getProfession(long id) {
		return professionDao.getProfession(id);
	}

	public List<Profession> getAllProfessions(String search) {
		return professionDao.getAllProfessions(search);
	}

}
