package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Subscription;

public interface SubscriptionService {
	public long createSubscription(Subscription subscription);

	public Subscription updateSubscription(Subscription subscription);

	public List<Subscription> getAllSubscription();
}
