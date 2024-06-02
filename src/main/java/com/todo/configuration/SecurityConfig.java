package com.todo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Configure security settings for HTTP requests
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (Cross-Site Request Forgery) protection
                .csrf().disable()
                // Authorize all requests to be authenticated
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                // Use HTTP Basic authentication
                .httpBasic();
    }
}
