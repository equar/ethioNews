package com.ethionews.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ethionews.model.Contact;
import com.ethionews.service.ContactService;
import com.ethionews.util.EnConstants;

@Controller
public class ContactController {
	private static final Logger logger = Logger.getLogger(ContactController.class);

	@Autowired
	@Qualifier("contactValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	private ContactService contactService;

	@RequestMapping("createContact")
	public ModelAndView createContact(@ModelAttribute Contact contact) {
		logger.info("Creating Contact. Data: " + contact);
		return new ModelAndView("contactForm");
	}

	@RequestMapping("editContact")
	public ModelAndView editContact(@RequestParam long id, @ModelAttribute Contact contact) {
		logger.info("Updating the Contact for the Id " + id);
		contact = contactService.getContact(id);
		return new ModelAndView("contactForm", "contactObject", contact);
	}

	@RequestMapping("saveContact")
	public ModelAndView saveContact(Model model, @Validated Contact contact, BindingResult result) {
		logger.info("Saving the Contact. Data : " + contact);
		// if contact id is 0 then creating the contact other updating the
		// contact
		String returnVal = "contactForm";
		if (result.hasErrors()) {
			return new ModelAndView(returnVal);
		} else {
			if (contact.getId() == 0) {
				contactService.createContact(contact);
			} else {
				contactService.updateContact(contact);
			}
			return new ModelAndView(returnVal, "status", "You message has been added succesfully");
		}

	}

	@RequestMapping("deleteContact")
	public ModelAndView deleteContact(@RequestParam long id) {
		logger.info("Deleting the Contact. Id : " + id);
		contactService.deleteContact(id);
		return new ModelAndView("redirect:getAllContacts");
	}

	@RequestMapping("getAllContacts")
	public ModelAndView getAllContacts() {
		logger.info("Getting the all Contacts.");
		List<Contact> contactList = contactService.getAllContacts();
		return new ModelAndView("contactList", "contactList", contactList);
	}

	@RequestMapping("searchContact")
	public ModelAndView searchContact(@RequestParam("name") String name) {
		logger.info("Searching the Contact. Contact Names: " + name);
		List<Contact> contactList = contactService.getAllContacts(name);
		return new ModelAndView("contactList", "contactList", contactList);
	}

	@RequestMapping("getReadContacts")
	public ModelAndView getReadContacts() {
		logger.info("Getting the all read Contacts.");
		List<Contact> contactList = contactService.getReadContacts();
		return new ModelAndView("contactList", "contactList", contactList);
	}

	@RequestMapping("getNewContacts")
	public ModelAndView getNewContacts() {
		logger.info("Getting all un read Contacts.");
		List<Contact> contactList = contactService.getNewContacts();
		return new ModelAndView("contactList", "contactList", contactList);
	}

	@RequestMapping("updateContactStatus")
	public ModelAndView updateContactStatus(@RequestParam long id) {
		logger.info("updating Contact status. Id : " + id);
		contactService.updateContactStatus(id);
		return new ModelAndView("redirect:getAllContacts");
	}

}
