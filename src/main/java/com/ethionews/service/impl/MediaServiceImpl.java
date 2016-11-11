package com.ethionews.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethionews.dao.MediaDao;
import com.ethionews.model.Media;
import com.ethionews.model.Subscription;
import com.ethionews.service.MediaService;

@Service("mediaService")
@Transactional
public class MediaServiceImpl implements MediaService {
	@Autowired
	private MediaDao mediaDao;

	@Override
	public long createMedia(Media media) {
		return mediaDao.createMedia(media);
	}

	@Override
	public Media updateMedia(Media media) {
		return mediaDao.updateMedia(media);
	}

	@Override
	public void deleteMedia(long id) {
		mediaDao.deleteMedia(id);

	}

	@Override
	public List<Media> getAllMedias() {
		return mediaDao.getAllMedias();
	}

	@Override
	public Media getMedia(long id) {
		return mediaDao.getMedia(id);
	}

	@Override
	public List<Media> getAllMedias(String search) {
		return mediaDao.getAllMedias(search);
	}

	public List<Media> getAllMediasToSubscribe() {
		return mediaDao.getAllMediasToSubscribe();
	}

	public long createSubscription(Subscription subscription) {
		return mediaDao.createSubscription(subscription);
	}

	public Subscription updateSubscription(Subscription subscription) {
		return mediaDao.updateSubscription(subscription);
	}

}
