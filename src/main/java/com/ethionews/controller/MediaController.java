package com.ethionews.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Media;
import com.ethionews.model.Subscription;
import com.ethionews.service.MediaService;
import com.ethionews.util.EnConstants;

@Controller
public class MediaController {
	private static final Logger logger = Logger.getLogger(MediaController.class);

	@Autowired
	private MediaService mediaService;

	@RequestMapping("createMedia")
	public ModelAndView createMedia(@ModelAttribute Media media) {
		logger.info("Creating Media. Data: " + media);
		return new ModelAndView("mediaForm");
	}

	@RequestMapping("editMedia")
	public ModelAndView editMedia(@RequestParam long id, @ModelAttribute Media media) {
		logger.info("Updating the Media for the Id " + id);
		media = mediaService.getMedia(id);
		return new ModelAndView("mediaForm", "mediaObject", media);
	}

	@RequestMapping("saveMedia")
	public ModelAndView saveMedia(@ModelAttribute Media media) {
		logger.info("Saving the Media. Data : " + media);
		// if media id is 0 then creating the media other updating the
		// media
		if (media.getId() == 0) {
			mediaService.createMedia(media);
		} else {
			mediaService.updateMedia(media);
		}
		return new ModelAndView("redirect:getAllMedias");
	}

	@RequestMapping("deleteMedia")
	public ModelAndView deleteMedia(@RequestParam long id) {
		logger.info("Deleting the Media. Id : " + id);
		mediaService.deleteMedia(id);
		return new ModelAndView("redirect:getAllMedias");
	}

	@RequestMapping("getAllMedias")
	public ModelAndView getAllMedias() {
		logger.info("Getting the all Medias.");
		List<Media> mediaList = mediaService.getAllMedias();
		return new ModelAndView(EnConstants.MEDIA_LIST, EnConstants.MEDIA_LIST, mediaList);
	}

	@RequestMapping("searchMedia")
	public ModelAndView searchMedia(@RequestParam("roleType") String roleType) {
		logger.info("Searching the Media. Media Names: " + roleType);
		List<Media> mediaList = mediaService.getAllMedias(roleType);
		return new ModelAndView(EnConstants.MEDIA_LIST, EnConstants.MEDIA_LIST, mediaList);
	}

	@RequestMapping("getMediasToSubscribe")
	public ModelAndView getAllMediasToSubscribe(@ModelAttribute Subscription subscription) {
		logger.info("Getting the all Medias to subscribe.");
		List<Media> mediaList = mediaService.getAllMediasToSubscribe();
		return new ModelAndView("subscribeList", "mediaList", mediaList);
	}

	@RequestMapping("subscribeToMedias")
	public ModelAndView createSubscription(@ModelAttribute Subscription subscription) {
		logger.info("Saving the subscription. Data : " + subscription);
		// if subscription id is 0 then creating the subscription other updating
		// the subscription
		if (subscription.getId() == 0) {
			mediaService.createSubscription(subscription);
		} else {
			mediaService.updateSubscription(subscription);
		}
		return new ModelAndView("redirect:getMediasToSubscribe");
	}

}
