package com.nareshit.ticketbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //This will be considered as default security filter and loaded on startup
//WebSecurityConfigurerAdapter ==> Default Security Filter
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	//Authentication Logic
	//Nareshitadmin/Nareshitadmin ==> ADMIN Role
	//Nareshitguest/Nareshitguest ===> GUEST ROLE

	@Autowired
	public void configure_global(AuthenticationManagerBuilder authObj) throws Exception {

		//{noop} ==> Encypting the password as security framework does not take plan text password
		authObj.inMemoryAuthentication().withUser("nareshitadmin").password("{noop}nareshitadmin")
		.roles("ADMIN","GUEST");

		authObj.inMemoryAuthentication().withUser("nareshitguest").password("{noop}nareshitguest")
		.roles("GUEST");

	}



	//Authorization Logic

	//ADMIN ROLE can accesss all tickets method
	//GUEST Role can access individual ticket method
	@Override //Default Behaviour of HttpSecurityObj will not have any authorization logic
	public void configure(HttpSecurity authorizationObj) throws Exception {


		//Authorization Logic1 ==> Admin Role Should access All tickets method
		//http://localhost:8080/ticket/admin/all ==> satisify
		//http://localhost:8080/ticket/admin/all/onemore ==> satisify
		//http://localhost:8080/ticket/all ==> Notsatisify
		authorizationObj.csrf().disable()      //Please ignore this line for today's class
		.authorizeRequests().antMatchers("/tickets/admin/**").hasRole("ADMIN")
		.and().formLogin(); //formLogin ==> It will render Login Page


		//Authorization Logic2 ==> Guest Role should access singleticket Method
		//http://localhost:8080/ticket/ticket/1 ==> satisify
		//http://localhost:8080/ticket/ticket/2 ==> satisify
		authorizationObj.csrf().disable().authorizeRequests().antMatchers("/tickets/ticket/**")
		.hasAnyRole("GUEST").and().formLogin();
	}





}
