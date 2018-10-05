package com.shawn.security;

import com.shawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter  {

    private final UserService userService;

    @Autowired
    public WebSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }
 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.requestMatchers().antMatchers("/oauth/**").and().authorizeRequests().antMatchers("/oauth/**")
				.authenticated();
	}
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	return super.authenticationManagerBean();
    }

}
