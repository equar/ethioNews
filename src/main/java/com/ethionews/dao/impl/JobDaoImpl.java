package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.JobDao;
import com.ethionews.model.Media;
import com.ethionews.model.Job;
import com.ethionews.model.User;
import com.ethionews.model.Job;
import com.ethionews.util.HibernateUtil;

@Repository("jobDao")
public class JobDaoImpl implements JobDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createJob(Job job) {
		return (Long) hibernateUtil.create(job);
	}

	@Override
	public Job updateJob(Job job) {
		return hibernateUtil.update(job);
	}

	@Override
	public void deleteJob(long id) {
		Job job = new Job();
		job.setId(id);
		hibernateUtil.delete(job);
	}

	@Override
	public List<Job> getPublicJobs() {
		return hibernateUtil.fetchAll(Job.class);
	}

	@Override
	public Job getJob(long id) {
		return hibernateUtil.fetchById(id, Job.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getPublicJobs(String search) {
		String query = "SELECT e.* FROM Job e WHERE e.title like '%" + search + "%'";
		List<Object[]> rideObjects = hibernateUtil.fetchAll(query);
		List<Job> rides = new ArrayList<Job>();
		long id;
		String title;
		String description;
		String category;
		String filename;
		for (Object[] rideObject : rideObjects) {
			Job ride = new Job();
			id = ((BigInteger) rideObject[0]).longValue();
			title = (String) rideObject[5];
			description = (String) rideObject[3];
			category = (String) rideObject[1];
			filename = (String) rideObject[4];

			ride.setId(id);

			rides.add(ride);
		}

		return rides;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getUserJobs(long userId) {
		String query = "SELECT e.* FROM Job e WHERE e.userId=" + userId;
		List<Object[]> jobObjects = hibernateUtil.fetchAll(query);
		List<Job> jobs = new ArrayList<Job>();
		long id;
		String title;
		String description;
		String phoneNumber;
		String email;
		String location;
		Boolean available;
		for (Object[] jobObject : jobObjects) {
			Job job = new Job();
			id = ((BigInteger) jobObject[0]).longValue();
			title = (String) jobObject[5];
			description = (String) jobObject[2];
			phoneNumber = (String) jobObject[4];
			email = (String) jobObject[3];
			location = (String) jobObject[6];
			available = (Boolean) jobObject[1];

			job.setId(id);
			job.setTitle(title);
			job.setDescription(description);
			job.setPhoneNumber(phoneNumber);
			job.setEmail(email);
			job.setLocation(location);
			job.setAvailable(available);

			jobs.add(job);
		}

		return jobs;
	}

}
