package com.icecube.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	LoginService xservice;
	

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String showLoginPage() {
		//System.out.println("Get this method");
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String validateLogin(ModelMap model, @RequestParam String name,
			@RequestParam String password) {
		model.put("name", name);
		model.put("password", password);
		
		if (!xservice.validateLogin(name, password)){
			model.put("errorMessage", "User and Password is not match");
			return "login";
		}
		return "userwelcome";
	}

}
