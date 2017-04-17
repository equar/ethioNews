package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.SpeakDao;
import com.ethionews.model.Speak;
import com.ethionews.util.HibernateUtil;

@Repository("speakDao")
public class SpeakDaoImpl implements SpeakDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createSpeak(Speak speak) {
		return (Long) hibernateUtil.create(speak);
	}

	@Override
	public Speak updateSpeak(Speak speak) {
		return hibernateUtil.update(speak);
	}

	@Override
	public void deleteSpeak(long id) {
		Speak speak = new Speak();
		speak.setId(id);
		hibernateUtil.delete(speak);
	}

	@Override
	public List<Speak> getAllSpeaks() {
		return hibernateUtil.fetchAll(Speak.class);
	}

	@Override
	public Speak getSpeak(long id) {
		return hibernateUtil.fetchById(id, Speak.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speak> getAllSpeaks(String search) {
		String query = "SELECT e.* FROM Speak e WHERE e.title like '%" + search + "%'";
		List<Object[]> speakObjects = hibernateUtil.fetchAll(query);
		List<Speak> speaks = new ArrayList<Speak>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] speakObject : speakObjects) {
			Speak speak = new Speak();
			id = ((BigInteger) speakObject[0]).longValue();
			title = (String) speakObject[5];
			description = (String) speakObject[3];
			category = (String) speakObject[1];
			filename = (String) speakObject[4];

			speak.setId(id);
			

			speaks.add(speak);
		}

		return speaks;
	}

}
