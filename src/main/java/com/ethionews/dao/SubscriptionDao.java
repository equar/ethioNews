package com.ethionews.dao;

import com.ethionews.model.Subscription;

public interface SubscriptionDao {
	public long createSubscription(Subscription subscription);

	public Subscription updateSubscription(Subscription subscription);
}
