package com.ethionews.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethionews.dao.VideoDao;
import com.ethionews.model.Video;
import com.ethionews.service.VideoService;

@Service("videoService")
@Transactional
public class VideoServiceImpl implements VideoService {
	@Autowired
	private VideoDao videoDao;

	@Override
	public long createVideo(Video video) {
		return videoDao.createVideo(video);
	}

	@Override
	public Video updateVideo(Video video) {
		return videoDao.updateVideo(video);
	}

	@Override
	public void deleteVideo(long id) {
		videoDao.deleteVideo(id);

	}

	@Override
	public List<Video> getAllVideos() {
		return videoDao.getAllVideos();
	}

	@Override
	public Video getVideo(long id) {
		return videoDao.getVideo(id);
	}

	@Override
	public List<Video> getAllVideos(String search) {
		return videoDao.getAllVideos(search);
	}

}
