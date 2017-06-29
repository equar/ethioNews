package com.ethionews.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Job;
import com.ethionews.service.JobService;

@Controller
public class JobController {
	private static final Logger logger = Logger.getLogger(JobController.class);

	@Autowired
	@Qualifier("jobValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private JobService jobService;

	@RequestMapping("createJob")
	public ModelAndView createJob(@ModelAttribute Job job) {
		logger.info("Creating Job. Data: " + job);
		return new ModelAndView("jobForm");
	}

	@RequestMapping("editJob")
	public ModelAndView editJob(@RequestParam long id, @ModelAttribute Job job) {
		logger.info("Updating the Job for the Id " + id);
		job = jobService.getJob(id);
		return new ModelAndView("jobForm", "jobObject", job);
	}

	@RequestMapping("saveJob")
	public String saveJob(Model model, @Validated Job job, BindingResult result) {
		logger.info("Saving the Media. Data : " + job);
		// if media id is 0 then creating the media other updating the
		// media
		String returnVal = "redirect:getAllJobs";
		Date today = Calendar.getInstance().getTime();

		if (result.hasErrors()) {
			return "jobForm";
		} else {
			if (job.getId() == 0) {
				jobService.createJob(job);
			} else {
				jobService.updateJob(job);
			}

		}

		return returnVal;
	}

	@RequestMapping("deleteJob")
	public ModelAndView deleteJob(@RequestParam long id) {
		logger.info("Deleting the Job. Id : " + id);
		jobService.deleteJob(id);
		return new ModelAndView("redirect:getAllJobs");
	}

	@RequestMapping("getAllJobs")
	public ModelAndView getAllJobs() {
		logger.info("Getting the all Jobs.");
		List<Job> jobList = jobService.getAllJobs();
		return new ModelAndView("jobList", "jobList", jobList);
	}

	@RequestMapping("getPublicJobs")
	public ModelAndView getPublicJobs() {
		logger.info("Getting the all Jobs.");
		List<Job> jobList = jobService.getAllJobs();
		return new ModelAndView("jobListPublic", "jobList", jobList);
	}

	@RequestMapping("searchJob")
	public ModelAndView searchJob(@RequestParam("title") String title) {
		logger.info("Searching the Job. Job Names: " + title);
		List<Job> jobList = jobService.getAllJobs(title);
		return new ModelAndView("jobList", "jobList", jobList);
	}

}
