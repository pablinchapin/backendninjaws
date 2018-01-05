package com.pablinchapin.backendninjaws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pablinchapin.backendninjaws.component.ContactConverter;
import com.pablinchapin.backendninjaws.entity.Contact;
import com.pablinchapin.backendninjaws.model.ContactModel;
import com.pablinchapin.backendninjaws.repository.ContactRepository;

@Service("contactServiceImplementation")
public class ContactServiceImplementation implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		// TODO Auto-generated method stub
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {

		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		
		for(Contact contact : contacts){
			contactsModel.add(contactConverter.convertContact2ContactModel(contact));
		}
		
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		Contact contact = contactRepository.findById(id);
		return contact;
	}
	
	public ContactModel findContactByIdModel(int id){
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = contactRepository.findById(id);
		
		if(null != contact){
			contactRepository.delete(contact);
		}
		
	}
	
	

	

}
