package com.crm.crud.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails omar = User.builder()
                        .username("omar")
                        .password("{noop}12345")
                        .roles("ADMIN", "MANAGER", "EMPLOYEE")
                        .build();

        
        return null;
    }
}
