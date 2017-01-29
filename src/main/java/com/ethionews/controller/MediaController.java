package com.ethionews.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Media;
import com.ethionews.service.MediaService;
import com.ethionews.util.EnConstants;

@Controller
public class MediaController {
	private static final Logger logger = Logger.getLogger(MediaController.class);

	@Autowired
	@Qualifier("mediaValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

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
	public String saveMedia(Model model, @Validated Media media, BindingResult result) {
		logger.info("Saving the Media. Data : " + media);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getAllMedias";
		if (result.hasErrors()) {
			return "mediaForm";
		} else {
			if (media.getId() == 0) {
				mediaService.createMedia(media);
			} else {
				mediaService.updateMedia(media);
			}

		}

		return returnVal;
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
	public ModelAndView searchMedia(@RequestParam("name") String name) {
		logger.info("Searching the Media. Media Names: " + name);
		List<Media> mediaList = mediaService.getAllMedias(name);
		return new ModelAndView(EnConstants.MEDIA_LIST, EnConstants.MEDIA_LIST, mediaList);
	}

}
