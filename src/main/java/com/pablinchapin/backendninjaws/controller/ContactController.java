package com.pablinchapin.backendninjaws.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pablinchapin.backendninjaws.configuration.ViewConstant;
import com.pablinchapin.backendninjaws.model.ContactModel;
import com.pablinchapin.backendninjaws.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Logger LOG = Logger.getLogger(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImplementation")
	private ContactService contactService;
	
	
	@GetMapping("/cancel")
	private String contactList(){
		return "redirect:/contacts/listcontacts";
	}
	
	@GetMapping("/contactform")
	private String contactForm(
			@RequestParam(name="id", required=true) int id,
			Model model){
		
		ContactModel contact = new ContactModel();
		if(id != 0){
			contact = contactService.findContactByIdModel(id);
		}
		
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTACT_FORM;
	}
	
	@PostMapping("/addcontact")
	private String contactAdd(
			Model model,
			@ModelAttribute(name="contactModel") ContactModel contactModel
			){
		
		LOG.info("METHOD: contactAdd() PARAMS: contactModel->"+contactModel.toString());
		
		if(null != contactService.addContact(contactModel)){
			model.addAttribute("result", 1);	
		}else{
			model.addAttribute("result", 0);
		}
		
				
		
		return "redirect:/contacts/listcontacts";
	}
	
	@GetMapping("/listcontacts")
	public ModelAndView listAllContacts(){
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACT_VIEW);
		
		modelAndView.addObject("contacts", contactService.listAllContacts());
		
		return modelAndView;
	}
	
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(
			@RequestParam(name="id", required=true) int id
			){
		
		LOG.info("METHOD: removeContact() PARAMS: id->"+id);
		
		contactService.removeContact(id);
		
		return listAllContacts();
	}
	
	

}