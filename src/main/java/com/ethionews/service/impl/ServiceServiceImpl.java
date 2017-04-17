package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.ServiceDao;
import com.ethionews.model.Service;
import com.ethionews.service.ServiceService;

@Service("serviceService")
@Transactional
public class ServiceServiceImpl implements ServiceService {
	@Autowired
	private ServiceDao serviceDao;

	@Override
	public long createService(Service service) {
		return serviceDao.createService(service);
	}

	@Override
	public Service updateService(Service service) {
		return serviceDao.updateService(service);
	}

	@Override
	public void deleteService(long id) {
		serviceDao.deleteService(id);

	}

	@Override
	public List<Service> getAllServices() {
		return serviceDao.getAllServices();
	}

	@Override
	public Service getService(long id) {
		return serviceDao.getService(id);
	}

	@Override
	public List<Service> getAllServices(String search) {
		return serviceDao.getAllServices(search);
	}

}
