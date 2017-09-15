package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Speak;

public interface SpeakDao {
	public long createSpeak(Speak speak);

	public Speak updateSpeak(Speak speak);

	public void deleteSpeak(long id);

	public List<Speak> getAllSpeaks();

	public Speak getSpeak(long id);

	public List<Speak> getAllSpeaks(String search);

	public List<Speak> getUserSpeaks(long userId);
}
