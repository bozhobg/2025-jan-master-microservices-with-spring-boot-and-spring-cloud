package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

//        1) all reqs showed be authenticated
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

//        2) If a req is not authenticated, a web page is shown -(change to)-> dialog for username and password
        httpSecurity.httpBasic(withDefaults());

//        3) CSRF token for POST and PUT -> disable
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
