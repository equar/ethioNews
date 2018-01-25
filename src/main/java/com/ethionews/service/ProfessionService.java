package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Profession;

public interface ProfessionService {
	public long createProfession(Profession profession);

	public Profession updateProfession(Profession profession);

	public void deleteProfession(long id);

	public List<Profession> getAllProfessions();

	public List<Profession> getUserProfessions();

	public Profession getProfession(long id);

	public List<Profession> getAllProfessions(String search);
}
