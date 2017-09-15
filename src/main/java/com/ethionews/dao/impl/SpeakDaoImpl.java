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
	public List<Speak> getUserSpeaks(long userId) {
		String query = "SELECT e.* FROM Speak e WHERE e.userId=" + userId;
		List<Object[]> speakObjects = hibernateUtil.fetchAll(query);
		List<Speak> speaks = new ArrayList<Speak>();
		long id;
		String author;
		String title;
		String url;
		String description;
		int up;
		int down;
		for (Object[] speakObject : speakObjects) {
			Speak speak = new Speak();
			id = ((BigInteger) speakObject[0]).longValue();
			author = (String) speakObject[1];
			title = (String) speakObject[5];
			url = (String) speakObject[8];
			description = (String) speakObject[3];
			up = (int) speakObject[6];
			down = (int) speakObject[4];

			speak.setId(id);
			speak.setAuthor(author);
			speak.setTitle(title);
			speak.setUrl(url);
			speak.setDescription(description);
			speak.setUp(up);
			speak.setDown(down);

			speaks.add(speak);
		}

		return speaks;
	}

	@Override
	public List<Speak> getAllSpeaks(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
