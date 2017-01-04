package com.ethionews.service;

import java.util.List;

import com.ethionews.model.Contact;

public interface ContactService {
	public long createContact(Contact contact);

	public Contact updateContact(Contact contact);

	public void deleteContact(long id);

	public List<Contact> getAllContacts();

	public Contact getContact(long id);

	public List<Contact> getAllContacts(String search);

	public List<Contact> getReadContacts();

	public List<Contact> getNewContacts();

	public void updateContactStatus(long id);

}
