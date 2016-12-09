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
	public List<Media> getAllMedias(String roleType) {
		String query = "SELECT e.* FROM Media e WHERE e.roleType like '%" + roleType + "%'";
		List<Object[]> mediaObjects = hibernateUtil.fetchAll(query);
		List<Media> medias = new ArrayList<Media>();
		for (Object[] mediaObject : mediaObjects) {
			Media media = new Media();
			long roleId = ((long) mediaObject[0]);
			String roleName = (String) mediaObject[1];
			media.setId(roleId);
			// media.setRoleType(roleName);
			medias.add(media);
		}
		System.out.println(medias);
		return medias;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMediasToSubscribe() {
		String query = "SELECT e.* FROM Media e WHERE e.crawel = " + true;
		List<Object[]> mediaObjects = hibernateUtil.fetchAll(query);
		List<Media> medias = new ArrayList<Media>();
		for (Object[] mediaObject : mediaObjects) {
			Media media = new Media();
			long id = ((BigInteger) mediaObject[0]).longValue();
			String name = (String) mediaObject[4];
			media.setId(id);
			media.setName(name);
			medias.add(media);
		}
		System.out.println(medias);
		return medias;
	}

	public long createSubscription(Subscription subscription) {
		return (Long) hibernateUtil.create(subscription);
	}

	public Subscription updateSubscription(Subscription subscription) {
		return hibernateUtil.update(subscription);
	}

}
