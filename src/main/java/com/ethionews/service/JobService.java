package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Job;

public interface JobService {
	public long createJob(Job job);

	public Job updateJob(Job job);

	public void deleteJob(long id);

	public List<Job> getAllJobs();

	public Job getJob(long id);

	public List<Job> getAllJobs(String search);
}
