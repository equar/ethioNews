package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.SpeakDao;
import com.ethionews.model.Speak;
import com.ethionews.service.SpeakService;
import com.ethionews.service.UserService;

@Service("speakService")
@Transactional
public class SpeakServiceImpl implements SpeakService {
	@Autowired
	private SpeakDao speakDao;
	@Autowired
	private UserService userService;

	@Override
	public long createSpeak(Speak speak) {
		speak.setUser(userService.findLoggedUser());
		speak.setUp(1);
		speak.setDown(0);
		return speakDao.createSpeak(speak);
	}

	@Override
	public Speak updateSpeak(Speak speak) {
		speak.setUser(userService.findLoggedUser());
		return speakDao.updateSpeak(speak);
	}

	@Override
	public void deleteSpeak(long id) {
		speakDao.deleteSpeak(id);

	}

	@Override
	public List<Speak> getAllSpeaks() {
		return speakDao.getAllSpeaks();
	}

	@Override
	public Speak getSpeak(long id) {
		return speakDao.getSpeak(id);
	}

	@Override
	public List<Speak> getUserSpeaks() {
		long userId = userService.findLoggedUser().getId();
		return speakDao.getUserSpeaks(userId);
	}

	@Override
	public List<Speak> getAllSpeaks(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
