package com.fdmgroup.GameBlog.dataimport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fdmgroup.GameBlog.model.Role;
import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.repository.UserRepository;

@Component
public class DataImport implements ApplicationRunner {

	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public DataImport(UserRepository userRepository, PasswordEncoder passwordEncoder ) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;	
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(!userRepository.findByUsername("admin").isPresent()) {
			Role roleAdmin = new Role("Admin");
			Role roleCustomer = new Role("Customer");
		
			
			User admin = new User("admin", passwordEncoder.encode("123"), "admin@shazar.com", "defaultCity",  roleAdmin);
			userRepository.save(admin);
		
			User customer = new User("customer", passwordEncoder.encode("321"), "user@abc.com", "defaultCity",  roleCustomer);
			userRepository.save(customer);
		}
		
	}
	
	
}
