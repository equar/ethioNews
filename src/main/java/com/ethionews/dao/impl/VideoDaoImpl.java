package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.VideoDao;
import com.ethionews.model.Media;
import com.ethionews.model.User;
import com.ethionews.model.Video;
import com.ethionews.util.HibernateUtil;

@Repository("videoDao")
public class VideoDaoImpl implements VideoDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createVideo(Video video) {
		return (Long) hibernateUtil.create(video);
	}

	@Override
	public Video updateVideo(Video video) {
		return hibernateUtil.update(video);
	}

	@Override
	public void deleteVideo(long id) {
		Video video = new Video();
		video.setId(id);
		hibernateUtil.delete(video);
	}

	@Override
	public List<Video> getAllVideos() {
		return hibernateUtil.fetchAll(Video.class);
	}

	@Override
	public Video getVideo(long id) {
		return hibernateUtil.fetchById(id, Video.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> getAllVideos(String search) {
		String query = "SELECT e.* FROM Video e WHERE e.title like '%" + search + "%'";
		List<Object[]> videoObjects = hibernateUtil.fetchAll(query);
		List<Video> videos = new ArrayList<Video>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] videoObject : videoObjects) {
			Video video = new Video();
			id = ((BigInteger) videoObject[0]).longValue();
			title = (String) videoObject[5];
			description = (String) videoObject[3];
			category = (String) videoObject[1];
			filename = (String) videoObject[4];

			video.setId(id);
			video.setTitle(title);
			video.setDescription(description);
			video.setCategory(category);
			video.setFilename(filename);

			videos.add(video);
		}

		return videos;
	}

}
