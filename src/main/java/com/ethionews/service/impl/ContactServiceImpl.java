package com.ethionews.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ethionews.dao.ContactDao;
import com.ethionews.model.Contact;
import com.ethionews.service.ContactService;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDao contactDao;

	@Override
	public long createContact(Contact contact) {
		return contactDao.createContact(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	@Override
	public void deleteContact(long id) {
		contactDao.deleteContact(id);

	}

	@Override
	public List<Contact> getAllContacts() {
		return contactDao.getAllContacts();
	}

	@Override
	public Contact getContact(long id) {
		return contactDao.getContact(id);
	}

	@Override
	public List<Contact> getAllContacts(String search) {
		return contactDao.getAllContacts(search);
	}

}
