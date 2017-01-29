package com.ethionews.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.dao.ContactDao;
import com.ethionews.model.Contact;
import com.ethionews.util.HibernateUtil;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createContact(Contact contact) {
		return (Long) hibernateUtil.create(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		return hibernateUtil.update(contact);
	}

	@Override
	public void deleteContact(long id) {
		Contact contact = new Contact();
		contact.setId(id);
		hibernateUtil.delete(contact);

	}

	@Override
	public List<Contact> getAllContacts() {
		return hibernateUtil.fetchAll(Contact.class);
	}

	@Override
	public Contact getContact(long id) {
		return hibernateUtil.fetchById(id, Contact.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts(String search) {
		String query = "SELECT e.* FROM Contact e WHERE e.name like '%" + search + "%'";
		List<Object[]> contactObjects = hibernateUtil.fetchAll(query);
		List<Contact> contacts = new ArrayList<>();
		long id;
		String name;
		String email;
		String subject;
		String message;
		for (Object[] contactObject : contactObjects) {
			Contact contact = new Contact();
			id = ((BigInteger) contactObject[0]).longValue();
			name = (String) contactObject[3];
			email = (String) contactObject[1];
			subject = (String) contactObject[5];
			message = (String) contactObject[2];

			contact.setId(id);
			contact.setName(name);
			contact.setEmail(email);
			contact.setSubject(subject);
			contact.setMessage(message);

			contacts.add(contact);
		}

		return contacts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts(Boolean status) {
		String query = "SELECT e.* FROM Contact e WHERE e.status=" + status;
		List<Object[]> contactObjects = hibernateUtil.fetchAll(query);
		List<Contact> contacts = new ArrayList<>();
		long id;
		String name;
		String email;
		String subject;
		String message;
		for (Object[] contactObject : contactObjects) {
			Contact contact = new Contact();
			id = ((BigInteger) contactObject[0]).longValue();
			name = (String) contactObject[1];
			email = (String) contactObject[2];
			subject = (String) contactObject[3];
			message = (String) contactObject[5];

			contact.setId(id);
			contact.setName(name);
			contact.setEmail(email);
			contact.setSubject(subject);
			contact.setMessage(message);

			contacts.add(contact);
		}

		return contacts;
	}

	@Override
	public void updateContactStatus(long id) {
		String query = "UPDATE Contact set status=" + true + "WHERE id=" + id;
		hibernateUtil.update(query);

	}

}
