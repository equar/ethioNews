package com.ethionews.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Contact;
import com.ethionews.model.Media;
import com.ethionews.model.Subscription;
import com.ethionews.service.MediaService;
import com.ethionews.service.SubscriptionService;

@Controller
public class SubscriptionController {
	private static final Logger logger = Logger.getLogger(SubscriptionController.class);

	@Autowired
	@Qualifier("subscriptionValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private MediaService mediaService;

	@Autowired
	private SubscriptionService subscriptionService;

	@RequestMapping("getMediasToSubscribe")
	public ModelAndView getAllMediasToSubscribe(@ModelAttribute Subscription subscription, HttpSession session) {
		logger.info("Getting the all Medias to subscribe.");
		ModelAndView modelSub = new ModelAndView();
		List<Media> mediaList = mediaService.getAllMediasToSubscribe();
		modelSub.addObject("mediaList", mediaList);
		modelSub.setViewName("subscriptionForm");
		session.setAttribute("mediaList", mediaList);
		return modelSub;
	}

	@RequestMapping("subscribeToMedias")
	public ModelAndView createSubscription(Model model, @Validated Subscription subscription, BindingResult result) {
		logger.info("Saving the subscription. Data : " + subscription);
		// if subscription id is 0 then creating the subscription other updating
		// the subscription
		ModelAndView modelSub = new ModelAndView();
		if (result.hasErrors()) {
			modelSub.setViewName("subscriptionForm");
		} else {
			if (subscription.getId() == 0) {
				subscriptionService.createSubscription(subscription);
			} else {
				subscriptionService.updateSubscription(subscription);
			}
			modelSub.addObject("name", subscription.getName());
			modelSub.addObject("email", subscription.getEmail());
			modelSub.addObject("frequency", subscription.getFrequency());
			// modelSub.addObject("mediaList", subscription.getMedia());
			modelSub.setViewName("subscribedUserMedia");
		}
		return modelSub;
	}

	@RequestMapping("getAllSubscribers")
	public ModelAndView getAllSubscription() {
		logger.info("Getting all Subscribers.");
		List<Subscription> subscriptionList = subscriptionService.getAllSubscription();
		return new ModelAndView("subscriptionList", "subscriptionList", subscriptionList);
	}

}
