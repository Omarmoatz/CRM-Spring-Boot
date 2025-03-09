package com.crm.crud.security;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails omar = User.builder()
                        .username("omar")
                        .password("{noop}12345")
                        .roles("ADMIN", "MANAGER", "EMPLOYEE")
                        .build();

        UserDetails ahmed = User.builder()
                            .username("ahmed")
                            .password("{noop}12345")
                            .roles("MANAGER", "EMPLOYEE")
                            .build();

        UserDetails user1 = User.builder()
                        .username("user1")
                        .password("{noop}12345")
                        .roles("EMPLOYEE")
                        .build();

        
        return new InMemoryUserDetailsManager(omar, ahmed, user1);
    }


    // rewrite it
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configure ->
                        configure
                                .requestMatchers(HttpMethod.GET, "/api/members").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/members/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
                        );
        
        // authentication type                        
        http.httpBasic(Customizer.withDefaults());

        // disabling CSRF beacuse CSRF is not required for stateless REST APIs
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
