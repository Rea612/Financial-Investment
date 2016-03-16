package com.suddenlyjune.financialinvestment.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suddenlyjune.financialinvestment.dao.User;
import com.suddenlyjune.financialinvestment.service.UsersService;


@Controller
public class LoginController {
	
private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		
		return "login";
	}
	@RequestMapping(value="/usermainpage", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal ) {
	 
	String name = principal.getName();
	model.addAttribute("username", name);
	return "usermainpage";
	 
	}
	
	
}
