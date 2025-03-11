package com.crm.crud;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.crm.crud.users.dao.AuthorityRepository;
import com.crm.crud.users.dao.UserRepository;
import com.crm.crud.users.models.Authority;
import com.crm.crud.users.models.User;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// use the ( entity manager or DAO ) to create, find, update, delete the user and authorities
	@Bean
    CommandLineRunner initDatabase(UserRepository userRepository, AuthorityRepository authorityRepository ,PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User("omarAdmin", "12345", true);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
            
            Authority roleAdmin = new Authority("ROLE_ADMIN");
			user.addAuthority(roleAdmin);

            Authority roleManager = new Authority("ROLE_MANAGER");
            user.addAuthority(roleManager);
            
            Authority roleEmployee = new Authority("ROLE_EMPLOYEE");
            user.addAuthority(roleEmployee);

            userRepository.save(user);
            System.out.println("User and Authorities created successfully!");
			// userRepository.findAll().forEach(System.out::println);
			// authorityRepository.findAll().forEach(System.out::println);
            System.out.println(userRepository.findAll());
            System.out.println(authorityRepository.findAll());
        };
    }



}
