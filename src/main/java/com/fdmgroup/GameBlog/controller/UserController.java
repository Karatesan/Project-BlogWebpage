package com.fdmgroup.GameBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.security.DefaultUserDetailService;
import com.fdmgroup.GameBlog.service.RoleService;

@Controller
public class UserController {

	@Autowired
	private DefaultUserDetailService defaultUserService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private MainController mainController;
	

	@GetMapping("/login") 
	public String goToLogin() {
		
		return "login";
	}
	
	@GetMapping("/login-error") 
	public String loginError(ModelMap model) {
		
		model.addAttribute("errorMessage", "Invalid username or password");
		
		return "login";
	}
	
	@GetMapping("/goRegisterPage")
	public String goToRegisterPage() {
		
		return "register";		
	}
		
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, @RequestParam String confirmPassword, ModelMap model) {
		User userFromDatabase = defaultUserService.findByUsername(user.getUsername());
		
		if(userFromDatabase.getUsername().equals(user.getUsername()) || user.getUsername().equals("anonymousUser") || user.getUsername().equals("default username")) {
			model.addAttribute("errorMessage", "This user name already exists");
			return "register";
		}
		
		if(!user.getPassword().equals(confirmPassword)) {
			model.addAttribute("errorMessage", "Entries in Password and Confirm Password are not the same");
			return "register";	
		}
				
		user.setRole(roleService.findByRoleName("Customer"));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		defaultUserService.saveUser(user);
		
		
		return "index";
	}

	@GetMapping("/goChangePasswordPage") 
	public String goChangePassword(ModelMap model) {
		
		mainController.populateLoggedUserModel(model);
		
		return "changePassword";
	}
	
	@PostMapping("/changePassword") 
	public String changePassword(ModelMap model, @ModelAttribute("user") User user, @RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String confirmNewPassword) {
		
		User userFromDatabase = defaultUserService.findByUsername(user.getUsername());
		
		if(newPassword.equals(confirmNewPassword)) {
			if(passwordEncoder.matches(currentPassword, userFromDatabase.getPassword())) {
				userFromDatabase.setPassword(passwordEncoder.encode(newPassword));
			} else {
				model.addAttribute("errorMessage", "Wrong current password");
				return "changePassword";
			}	
		} else {
			model.addAttribute("errorMessage", "Different entries in 'New Password' and 'Confirm New Password'. Please try again");
			return "changePassword";
		}
		
		model.addAttribute("message", "Password changed successfully");
		defaultUserService.saveUser(userFromDatabase);
		
		return "showProfile";
	}
	
	@GetMapping("/goQuestionPassword") 
	public String goQuestionPassword() {
		return "questionPassword";
	}
	
	
	@PostMapping("/questionPassword")
	public String questionPassword(ModelMap model, @RequestParam String username, @RequestParam String answer) {
		
		User userFromDatabase = defaultUserService.findByUsername(username);
				
		if(!userFromDatabase.getUsername().equals(username)) {
			model.addAttribute("errorMessage", "No User with this username");
			return "questionPassword";
		} else {
			if(answer.toLowerCase().equals(userFromDatabase.getAnswerQuestion().toLowerCase())) {
				model.addAttribute("user", userFromDatabase);
				return "resetPassword";
			} else {
				model.addAttribute("errorMessage", "Something went wrong");
				return "questionPassword";			
			}			
		}	
	}
	
	@PostMapping("/resetPassword") 
	public String resetPassword(ModelMap model, @ModelAttribute("user") User user, @RequestParam String newPassword, @RequestParam String confirmNewPassword) {
		User userFromDatabase = defaultUserService.findByUsername(user.getUsername());
		
		if(newPassword.equals(confirmNewPassword)) {
			userFromDatabase.setPassword(passwordEncoder.encode(newPassword));
		} else {
			model.addAttribute("errorMessage", "Different entries in 'New Password' and 'Confirm New Password'. Please try again");
			return "changePassword";
		}
		
		model.addAttribute("message", "Password changed successfully");
		defaultUserService.saveUser(userFromDatabase);
		
		return "index";
	}
	
}
