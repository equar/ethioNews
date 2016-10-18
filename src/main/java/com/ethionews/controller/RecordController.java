package com.ethionews.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Record;
import com.ethionews.service.RecordService;

@Controller
public class RecordController {

	private static final Logger logger = Logger.getLogger(UserRoleController.class);

	@Autowired
	private RecordService recordService;

	@RequestMapping(value = { "/", "/news" }, method = RequestMethod.GET)
	public ModelAndView displayRecord(HttpServletRequest request, HttpServletResponse response, Record record) {
		ModelAndView model = new ModelAndView("newsBoard");
		model.addObject("newsBoard", record);
		return model;
	}

}
