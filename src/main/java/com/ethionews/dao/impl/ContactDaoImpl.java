package com.ethionews.dao.impl;

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
	public List<Contact> getAllContacts(String roleType) {
		String query = "SELECT e.* FROM Contact e WHERE e.roleType like '%" + roleType + "%'";
		List<Object[]> contactObjects = hibernateUtil.fetchAll(query);
		List<Contact> contacts = new ArrayList<Contact>();
		for (Object[] contactObject : contactObjects) {
			Contact contact = new Contact();
			long roleId = ((long) contactObject[0]);
			String roleName = (String) contactObject[1];
			contact.setId(roleId);
			// contact.setRoleType(roleName);
			contacts.add(contact);
		}
		System.out.println(contacts);
		return contacts;
	}

}
