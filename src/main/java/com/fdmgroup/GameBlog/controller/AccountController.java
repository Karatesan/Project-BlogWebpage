package com.fdmgroup.GameBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.security.DefaultUserDetailService;


@Controller
public class AccountController {

	@Autowired
	private DefaultUserDetailService defaultUserService;
	
	@Autowired
	MainController mainController;

	
	@GetMapping("/showProfile")
	public String goToShowProfile(ModelMap model) {

		mainController.populateLoggedUserModel(model);
		
		return "showProfile";
	}
		
	@GetMapping("/goEditProfilePage")
	public String goToEditProfilePage(ModelMap model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		User user = defaultUserService.findByUsername(username);
		
		System.out.println("Logged in User: " + username);
		
		model.addAttribute("user", user);
		
		mainController.populateLoggedUserModel(model);
		
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String editUser(ModelMap model, @ModelAttribute("user") User user) {
		
		User userFromDatabase = defaultUserService.findByUsername(user.getUsername());
		
	
		userFromDatabase.setEmail(user.getEmail());
	
		
		System.out.println("EDIT PROFILE USER: " + user);
		
		defaultUserService.saveUser(userFromDatabase);
		
		mainController.populateLoggedUserModel(model);
		
		return "showProfile";
	}
	
	
	
}
