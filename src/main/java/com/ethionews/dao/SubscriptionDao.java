package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Subscription;

public interface SubscriptionDao {
	public long createSubscription(Subscription subscription);

	public Subscription updateSubscription(Subscription subscription);

	public List<Subscription> getAllSubscription();
}
