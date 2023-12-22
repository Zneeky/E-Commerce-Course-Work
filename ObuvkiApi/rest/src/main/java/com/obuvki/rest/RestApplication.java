package com.obuvki.rest;

import com.obuvki.rest.Models.AppUser;
import com.obuvki.rest.Models.Role;
import com.obuvki.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	public void run(String... args){
		AppUser adminAccount  = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount){
			AppUser user = new AppUser();

			user.setEmail("admin@gmail.com");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}

}
