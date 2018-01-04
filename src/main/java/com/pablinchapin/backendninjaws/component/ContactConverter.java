package com.pablinchapin.backendninjaws.component;

import org.springframework.stereotype.Component;

import com.pablinchapin.backendninjaws.entity.Contact;
import com.pablinchapin.backendninjaws.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	
	public Contact convertContactModel2Contact(ContactModel contactModel){
		
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstName(contactModel.getFirstName());
		contact.setLastName(contactModel.getLastName());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());
		
		return contact;
	}
	
	public ContactModel convertContact2ContactModel(Contact contact){
		
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstName(contact.getFirstName());
		contactModel.setLastName(contact.getLastName());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());
		
		return contactModel;
	}
	

}