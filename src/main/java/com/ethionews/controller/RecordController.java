package com.ethionews.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Media;
import com.ethionews.model.Record;
import com.ethionews.model.Record;
import com.ethionews.service.MediaService;
import com.ethionews.service.RecordService;
import com.ethionews.util.EthioUtil;
import com.sun.syndication.io.FeedException;

@Controller
public class RecordController {

	private static final Logger logger = Logger.getLogger(RecordController.class);

	@Autowired
	private RecordService recordService;

	@Autowired
	private MediaService mediaService;

	@RequestMapping("recordCrawel")
	public ModelAndView displayRecordCrawel() {
		ModelAndView model = new ModelAndView("recordCrawel");
		model.addObject("recordCrawel");
		return model;
	}

	@RequestMapping("createRecord")
	public ModelAndView createRecord(@ModelAttribute Record record) {
		logger.info("Creating Record. Data: " + record);
		List<Media> mediaList = mediaService.getAllMediasToSubscribe();

		for (Media media : mediaList) {
			try {
				recordService.createRecord(media);
			} catch (IllegalArgumentException | IOException | FeedException e) {
				logger.info(e.getMessage());
			}
		}
		return new ModelAndView("recordCrawel", "status", "News Crawling Completed!");
	}

	@RequestMapping("editRecord")
	public ModelAndView editRecord(@RequestParam long id, @ModelAttribute Record record) {
		logger.info("Updating the Record for the Id " + id);
		record = recordService.getRecord(id);
		return new ModelAndView("recordForm", "recordObject", record);
	}

	@RequestMapping("saveRecord")
	public ModelAndView saveRecord(@ModelAttribute Record record) {
		logger.info("Saving the Record. Data : " + record);
		// if record id is 0 then creating the record other updating the
		// record
		if (record.getId() == 0) {
			recordService.createRecord(record);
		} else {
			recordService.updateRecord(record);
		}
		return new ModelAndView("redirect:getAllRecords");
	}

	@RequestMapping("deleteRecord")
	public ModelAndView deleteRecord(@RequestParam long id) {
		logger.info("Deleting the Record. Id : " + id);
		recordService.deleteRecord(id);
		return new ModelAndView("redirect:getAllRecordsAdmin");
	}

	@RequestMapping("getAllRecords")
	public ModelAndView getAllRecords() {
		logger.info("Getting the all Records.");
		List<Record> recordList = recordService.getAllRecords();
		return new ModelAndView("recordList", "recordList", recordList);
	}

	@RequestMapping("getAllRecordsAdmin")
	public ModelAndView getAllRecordsAdmin() {
		logger.info("Getting the all Records.");
		List<Record> recordList = recordService.getAllRecords();
		return new ModelAndView("recordListAdmin", "recordList", recordList);
	}

	@RequestMapping(value = { "/", "/news" }, method = RequestMethod.GET)
	public String getRecords(Model model, Integer offset, Integer maxResults) {
		List<Record> records = recordService.getRecords(offset, maxResults);
		model.addAttribute("records", records);
		model.addAttribute("count", recordService.count());
		model.addAttribute("offset", offset);

		return "/news";
	}

	@RequestMapping("newsContent")
	public String newsContent(Model model, @RequestParam String content) {
		String fileContents = EthioUtil.readFileFromServer(content);
		model.addAttribute("content", fileContents);
		return "/newsContent";
	}

	@RequestMapping("searchRecord")
	public ModelAndView searchRecord(@RequestParam("roleType") String roleType) {
		logger.info("Searching the Record. Record Names: " + roleType);
		List<Record> recordList = recordService.getAllRecords(roleType);
		return new ModelAndView("recordList", "recordList", recordList);
	}

}
