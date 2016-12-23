package com.ethionews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.SubscriptionDao;
import com.ethionews.model.Subscription;
import com.ethionews.service.SubscriptionService;

@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
	@Autowired
	private SubscriptionDao subscriptionDao;

	public long createSubscription(Subscription subscription) {
		return subscriptionDao.createSubscription(subscription);
	}

	public Subscription updateSubscription(Subscription subscription) {
		return subscriptionDao.updateSubscription(subscription);
	}
}
