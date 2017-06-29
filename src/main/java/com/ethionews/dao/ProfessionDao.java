package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Profession;

public interface ProfessionDao {
	public long createProfession(Profession profession);

	public Profession updateProfession(Profession profession);

	public void deleteProfession(long id);

	public List<Profession> getAllProfessions();

	public Profession getProfession(long id);

	public List<Profession> getAllProfessions(String search);
}
