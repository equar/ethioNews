package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.JobDao;
import com.ethionews.model.Job;
import com.ethionews.service.JobService;
import com.ethionews.service.UserService;

@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {
	@Autowired
	private JobDao jobDao;
	@Autowired
	private UserService userService;

	@Override
	public long createJob(Job job) {
		job.setUser(userService.findLoggedUser());
		return jobDao.createJob(job);
	}

	@Override
	public Job updateJob(Job job) {
		return jobDao.updateJob(job);
	}

	@Override
	public void deleteJob(long id) {
		jobDao.deleteJob(id);

	}

	@Override
	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}

	@Override
	public Job getJob(long id) {
		return jobDao.getJob(id);
	}

	@Override
	public List<Job> getAllJobs(String search) {
		return jobDao.getAllJobs(search);
	}

}
