package com.crm.crud.security;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.crm.crud.users.dao.AuthorityRepository;
import com.crm.crud.users.dao.UserRepository;
import com.crm.crud.users.models.Authority;
import com.crm.crud.users.models.User;

@Configuration
public class DemoSecurityConfig {


    // to get the users from the DB
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
    
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "SELECT username, password, enabled FROM users WHERE username = ?"
        );
    
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "SELECT u.username, a.role FROM authorities a INNER JOIN users u ON u.id = a.user_id WHERE u.username = ?"
        );
    
        return jdbcUserDetailsManager;
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

                                .requestMatchers(HttpMethod.GET, "/api/profiles").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/profiles/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/profiles").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/profiles/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/profiles/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/users").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/users").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET, "/api/authorities").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/authorities/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/authorities").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PUT, "/api/authorities/**").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/authorities/**").hasRole("ADMIN")

                        );
        
        // authentication type                        
        http.httpBasic(Customizer.withDefaults());

        // disabling CSRF beacuse CSRF is not required for stateless REST APIs
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


   /* 
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
 */

}
