package com.ethionews.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Video;
import com.ethionews.service.VideoService;

@Controller
public class VideoController {
	private static final Logger logger = Logger.getLogger(VideoController.class);

	@Autowired
	private VideoService videoService;

	@RequestMapping("createVideo")
	public ModelAndView createVideo(@ModelAttribute Video video) {
		logger.info("Creating Video. Data: " + video);
		return new ModelAndView("videoForm");
	}

	@RequestMapping("editVideo")
	public ModelAndView editVideo(@RequestParam long id, @ModelAttribute Video video) {
		logger.info("Updating the Video for the Id " + id);
		video = videoService.getVideo(id);
		return new ModelAndView("videoForm", "videoObject", video);
	}

	@RequestMapping("saveVideo")
	public ModelAndView saveVideo(@ModelAttribute Video video) {
		logger.info("Saving the Video. Data : " + video);
		// if video id is 0 then creating the video other updating the
		// video
		if (video.getId() == 0) {
			videoService.createVideo(video);
		} else {
			videoService.updateVideo(video);
		}
		return new ModelAndView("redirect:getAllVideos");
	}

	@RequestMapping("deleteVideo")
	public ModelAndView deleteVideo(@RequestParam long id) {
		logger.info("Deleting the Video. Id : " + id);
		videoService.deleteVideo(id);
		return new ModelAndView("redirect:getAllVideos");
	}

	@RequestMapping("getAllVideos")
	public ModelAndView getAllVideos() {
		logger.info("Getting the all Videos.");
		List<Video> videoList = videoService.getAllVideos();
		return new ModelAndView("videoList", "videoList", videoList);
	}

	@RequestMapping("searchVideo")
	public ModelAndView searchVideo(@RequestParam("roleType") String roleType) {
		logger.info("Searching the Video. Video Names: " + roleType);
		List<Video> videoList = videoService.getAllVideos(roleType);
		return new ModelAndView("videoList", "videoList", videoList);
	}

}
