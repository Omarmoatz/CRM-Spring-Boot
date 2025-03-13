package com.crm.crud;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.crm.crud.aspects.MyService;
import com.crm.crud.employees.dao.EmployeeProfileRepository;
import com.crm.crud.employees.dao.EmployeeRepository;
import com.crm.crud.employees.model.Employee;
import com.crm.crud.employees.model.EmployeeProfile;
import com.crm.crud.users.dao.AuthorityRepository;
import com.crm.crud.users.dao.UserRepository;
import com.crm.crud.users.models.Authority;
import com.crm.crud.users.models.User;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // use the ( entity manager or DAO ) to create, find, update, delete the user
    // and authorities
    @Bean
    CommandLineRunner initDatabase(
            UserRepository userRepository,
            AuthorityRepository authorityRepository,
            PasswordEncoder passwordEncoder,
            EmployeeRepository employeeRepository,
            EmployeeProfileRepository employeeProfileRepository,
            EntityManager entityManager,
            MyService myService
            ) {
        return args -> {
            // create a super user
            // User user = new User("omarAdmin", "12345", true);
            // user.setPassword(passwordEncoder.encode(user.getPassword()));

            // Authority roleAdmin = new Authority("ROLE_ADMIN");
            // user.addAuthority(roleAdmin);

            // Authority roleManager = new Authority("ROLE_MANAGER");
            // user.addAuthority(roleManager);

            // Authority roleEmployee = new Authority("ROLE_EMPLOYEE");
            // user.addAuthority(roleEmployee);

            // userRepository.save(user);
            // System.out.println("User and Authorities created successfully!");
            // userRepository.findAll().forEach(System.out::println);
            // authorityRepository.findAll().forEach(System.out::println);

            // ------test the one-to-many relationship---------
            // List<Authority> allAuthorities = authorityRepository.findAll();
            // System.out.println(userRepository.findAll());
            // System.out.println(allAuthorities);

            // User user2 = entityManager.find(User.class, 1);
            // System.out.println(user2);

            // // i did this because of the lazy loading
            // user2.setAuthorities(allAuthorities);

            // System.out.println("user2 allAuthorities" + user2.getAuthorities());
            // System.out.println("---------------------------------------");

            // // --------test the one-to-one relationship------------
            // Employee employee = new Employee("Omar", "Ahmed", "omar@mail.com");
            // EmployeeProfile profile = new EmployeeProfile("Java Developer", "Cairo", "0123456789");

            // employee.setProfile(profile);
            // profile.setEmployee(employee);

            // employeeRepository.save(employee);

            // get the profile from the employee
            Employee emp = employeeRepository.findById(1).get();
            System.out.println(emp);
            System.out.println(emp.getProfile());

            // EmployeeProfile prof = employeeProfileRepository.findById(1).get();
            // System.out.println(prof);
            // System.out.println(prof.getEmployee());


            // System.out.println("Employee and Profile created successfully!");

            myService.doAnyThing();
        };
    }

}
