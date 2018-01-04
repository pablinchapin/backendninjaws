package com.pablinchapin.backendninjaws.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pablinchapin.backendninjaws.configuration.ViewConstant;
import com.pablinchapin.backendninjaws.model.UserCredential;

@Controller
public class LoginController {
	
	private static final Logger LOG = Logger.getLogger(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(
			Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout
			){
		
		LOG.info("METHOD: showLoginForm() PARAMS: error->"+error+" logout-> "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredential", new UserCredential());
		
		return ViewConstant.LOGIN_FORM;
	}
	
	@PostMapping("logincheck")
	public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential){
		
		LOG.info("METHOD: loginCheck() PARAMS: userCredential->"+userCredential.toString());
		if(userCredential.getUsername().equals("username") && userCredential.getPassword().equals("userpass")){
			return "redirect:/contacts/listcontacts";
		}
		
		return "redirect:/login?error";
		
	}
	
	

}
