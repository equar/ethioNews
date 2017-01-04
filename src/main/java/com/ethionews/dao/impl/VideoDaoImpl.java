package com.ethionews.dao.impl;

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
	public List<Video> getAllVideos(String roleType) {
		String query = "SELECT e.* FROM Video e WHERE e.roleType like '%" + roleType + "%'";
		List<Object[]> videoObjects = hibernateUtil.fetchAll(query);
		List<Video> videos = new ArrayList<Video>();
		for (Object[] videoObject : videoObjects) {
			Video video = new Video();
			long roleId = ((long) videoObject[0]);
			String roleName = (String) videoObject[1];
			video.setId(roleId);
			// video.setRoleType(roleName);
			videos.add(video);
		}
		System.out.println(videos);
		return videos;
	}

}
