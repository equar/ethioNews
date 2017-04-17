package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Service;

public interface ServiceService {
	public long createService(Service service);

	public Service updateService(Service service);

	public void deleteService(long id);

	public List<Service> getAllServices();

	public Service getService(long id);

	public List<Service> getAllServices(String search);
}
