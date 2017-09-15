package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Speak;

public interface SpeakService {
	public long createSpeak(Speak speak);

	public Speak updateSpeak(Speak speak);

	public void deleteSpeak(long id);

	public List<Speak> getAllSpeaks();
	
	public List<Speak> getUserSpeaks();

	public Speak getSpeak(long id);

	public List<Speak> getAllSpeaks(String search);
}
