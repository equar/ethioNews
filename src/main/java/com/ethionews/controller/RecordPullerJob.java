package com.ethionews.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.ethionews.model.Media;
import com.ethionews.service.MediaService;
import com.ethionews.service.RecordService;
import com.sun.syndication.io.FeedException;

public class RecordPullerJob {
	private static final Logger logger = Logger.getLogger(RecordPullerJob.class);

	@Autowired
	private RecordService recordService;

	@Autowired
	private MediaService mediaService;

	@Scheduled(fixedRate = 1000 * 60 * 60 * 3, initialDelay = 5000)
	public void saveRecord() {
		List<Media> mediaList = mediaService.getAllMediasToSubscribe();

		try {
			for (Media media : mediaList) {
				if (media.getUrl() != null) {
					recordService.createRecord(media);
				}
			}
			System.out.println("Automatic crawling completed");

		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (FeedException e) {
			logger.error(e.getMessage());
		}

	}
}
