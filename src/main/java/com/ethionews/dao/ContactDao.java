package com.ethionews.dao;

import java.util.List;

import com.ethionews.model.Contact;

public interface ContactDao {
	public long createContact(Contact contact);

	public Contact updateContact(Contact contact);

	public void deleteContact(long id);

	public List<Contact> getAllContacts();

	public Contact getContact(long id);

	public List<Contact> getAllContacts(String search);

	public List<Contact> getAllContacts(Boolean status);

	public void updateContactStatus(long id);
}
