package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.MediaDao;
import com.ethionews.model.User;
import com.ethionews.model.Media;
import com.ethionews.model.Subscription;
import com.ethionews.util.HibernateUtil;

@Repository("mediaDao")
public class MediaDaoImpl implements MediaDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createMedia(Media media) {
		return (Long) hibernateUtil.create(media);
	}

	@Override
	public Media updateMedia(Media media) {
		return hibernateUtil.update(media);
	}

	@Override
	public void deleteMedia(long id) {
		Media media = new Media();
		media.setId(id);
		hibernateUtil.delete(media);

	}

	@Override
	public List<Media> getAllMedias() {
		return hibernateUtil.fetchAll(Media.class);
	}

	@Override
	public Media getMedia(long id) {
		return hibernateUtil.fetchById(id, Media.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMedias(String search) {
		String query = "SELECT e.* FROM Media e WHERE e.name like '%" + search + "%'";
		List<Object[]> mediaObjects = hibernateUtil.fetchAll(query);
		List<Media> medias = new ArrayList<Media>();
		long id;
		String name;
		String url;
		String type;
		String language;
		String country;
		boolean crawel;
		for (Object[] mediaObject : mediaObjects) {
			Media media = new Media();
			id = ((BigInteger) mediaObject[0]).longValue();
			name = (String) mediaObject[4];
			url = (String) mediaObject[6];
			type = (String) mediaObject[5];
			language = (String) mediaObject[3];
			country = (String) mediaObject[1];
			crawel = (Boolean) mediaObject[2];

			media.setId(id);
			media.setName(name);
			media.setUrl(url);
			media.setType(type);
			media.setLanguage(language);
			media.setCountry(country);
			media.setCrawel(crawel);

			medias.add(media);
		}

		return medias;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMediasToSubscribe() {
		String query = "SELECT e.* FROM Media e WHERE e.crawel = " + true;
		List<Object[]> mediaObjects = hibernateUtil.fetchAll(query);
		List<Media> medias = new ArrayList<Media>();
		long id;
		String name;
		String url;
		String type;
		String language;
		String country;
		boolean crawel;
		for (Object[] mediaObject : mediaObjects) {
			Media media = new Media();
			id = ((BigInteger) mediaObject[0]).longValue();
			name = (String) mediaObject[4];
			url = (String) mediaObject[6];
			type = (String) mediaObject[5];
			language = (String) mediaObject[3];
			country = (String) mediaObject[1];
			crawel = (Boolean) mediaObject[2];

			media.setId(id);
			media.setName(name);
			media.setUrl(url);
			media.setType(type);
			media.setLanguage(language);
			media.setCountry(country);
			media.setCrawel(crawel);

			medias.add(media);
		}

		return medias;
	}

	@SuppressWarnings("unchecked")
	public Media findByURL(String url) {
		String Query = "From Media M where M.url= '" + url + "'";

		List<Media> mediaObjects = hibernateUtil.fetchAllMedia(Query);
		Media media = null;
		for (Media mediaObject : mediaObjects) {

			media = new Media();

			media.setId(mediaObject.getId());
			media.setUrl(mediaObject.getUrl());

		}
		return media;
	}

}
