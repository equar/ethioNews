package com.ethionews.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Media;
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
	public String saveVideo(Model model, @Validated Video video, BindingResult result) {
		logger.info("Saving the Media. Data : " + video);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getAllVideos";
		Date today = Calendar.getInstance().getTime();
		video.setDate(today);

		if (result.hasErrors()) {
			return "videoForm";
		} else {
			if (video.getId() == 0) {
				videoService.createVideo(video);
			} else {
				videoService.updateVideo(video);
			}

		}

		return returnVal;
	}

	@RequestMapping("saveVideoTemp")
	public ModelAndView saveVideoTemp(@ModelAttribute Video video, @RequestParam("file") MultipartFile file) {
		logger.info("Saving the Video. Data : " + video);
		// if video id is 0 then creating the video other updating the
		// video

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				Date today = Calendar.getInstance().getTime();
				video.setFilename(serverFile.toString());
				video.setDate(today);

				if (video.getId() == 0) {
					videoService.createVideo(video);
				} else {
					videoService.updateVideo(video);
				}

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

			} catch (Exception e) {
				logger.info(e.getMessage());
			}
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

	@RequestMapping("getPublicVideos")
	public ModelAndView getPublicVideos() {
		logger.info("Getting the all Videos.");
		List<Video> videoList = videoService.getAllVideos();
		return new ModelAndView("videoListPublic", "videoList", videoList);
	}

	@RequestMapping("searchVideo")
	public ModelAndView searchVideo(@RequestParam("roleType") String roleType) {
		logger.info("Searching the Video. Video Names: " + roleType);
		List<Video> videoList = videoService.getAllVideos(roleType);
		return new ModelAndView("videoList", "videoList", videoList);
	}

	@RequestMapping("upload")
	public ModelAndView upload(@ModelAttribute Video video) {
		logger.info("Creating Video. Data: " + video);
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	@RequestMapping("testVideo")
	public ModelAndView testVideo(@RequestParam String filename) {
		logger.info("Testing the Video. Id : " + filename);
		return new ModelAndView("videoTest", "videoTest", filename);
	}

}
