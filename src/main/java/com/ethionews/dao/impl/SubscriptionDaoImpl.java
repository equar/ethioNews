package com.ethionews.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.SubscriptionDao;
import com.ethionews.model.Subscription;
import com.ethionews.util.HibernateUtil;

@Repository("subscriptionDao")
public class SubscriptionDaoImpl implements SubscriptionDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	public long createSubscription(Subscription subscription) {
		return (Long) hibernateUtil.create(subscription);
	}

	public Subscription updateSubscription(Subscription subscription) {
		return hibernateUtil.update(subscription);
	}

	@Override
	public List<Subscription> getAllSubscription() {
		return hibernateUtil.fetchAll(Subscription.class);
	}
}
