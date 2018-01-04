package com.pablinchapin.backendninjaws.service;

import java.util.List;

import com.pablinchapin.backendninjaws.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();

}
