package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Media;
import com.ethionews.model.Subscription;
import com.ethionews.model.User;

public interface MediaDao {
	public long createMedia(Media media);

	public Media updateMedia(Media media);

	public void deleteMedia(long id);

	public List<Media> getAllMedias();

	public Media getMedia(long id);

	public List<Media> getAllMedias(String search);

	public List<Media> getAllMediasToSubscribe();

	public Media findByURL(String url);

}
