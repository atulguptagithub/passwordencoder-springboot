package com.springboot.restapi.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration

public class WebSecurity   extends  WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity httpSecurity)throws Exception
	{
		httpSecurity.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST).permitAll().anyRequest().authenticated().and().formLogin().permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	

}
