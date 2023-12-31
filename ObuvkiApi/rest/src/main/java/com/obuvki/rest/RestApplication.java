package com.obuvki.rest;

import com.obuvki.rest.Models.AppSupplier;
import com.obuvki.rest.Models.AppUser;
import com.obuvki.rest.Models.Role;
import com.obuvki.rest.repository.SupplierRepository;
import com.obuvki.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	//TODO: FIX EVERYTHING :* :*
	//TODO: MIGRATE TO C# ASP.NET > JABA LAYNARSKOTO GEYSKO EZICHE
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	@Bean

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:5173")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*")
						.allowCredentials(true)
						.maxAge(3600);
			}
		};
	}

	public void run(String... args){
		AppUser adminAccount  = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount){
			AppUser user = new AppUser();

			user.setEmail("admin@gmail.com");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);

			AppSupplier supplier = new AppSupplier();
			supplier.setId(1);
			supplier.setPhoneNumber("0884556623");
			supplier.setSupplierName("EKONT");
			supplierRepository.save(supplier);
		}
	}

}
