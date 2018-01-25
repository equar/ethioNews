package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Job;
import com.ethionews.model.Ride;

public interface JobDao {
	public long createJob(Job job);

	public Job updateJob(Job job);

	public void deleteJob(long id);

	public List<Job> getPublicJobs();

	public List<Job> getPublicJobs(String search);

	public List<Job> getUserJobs(long userId);

	public Job getJob(long id);

}
