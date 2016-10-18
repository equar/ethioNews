package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Video;

public interface VideoDao {
	public long createVideo(Video video);

	public Video updateVideo(Video video);

	public void deleteVideo(long id);

	public List<Video> getAllVideos();

	public Video getVideo(long id);

	public List<Video> getAllVideos(String search);
}
