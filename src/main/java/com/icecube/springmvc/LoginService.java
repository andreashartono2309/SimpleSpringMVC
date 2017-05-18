package com.icecube.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateLogin(String name, String password){
		return name.equalsIgnoreCase("username")&&password.equalsIgnoreCase("password");
	}

}
