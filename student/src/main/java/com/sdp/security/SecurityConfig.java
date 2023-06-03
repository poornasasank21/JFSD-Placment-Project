package com.sdp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Service;

@Configuration
@EnableWebSecurity
@Service
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
        http
        		.httpBasic().disable()
        		.authorizeRequests()
                .antMatchers("/home").permitAll()                
                .and()
                .sessionManagement()
                .and()
                .logout()
                .permitAll();
                
  
        		
                
                
    } 
}
