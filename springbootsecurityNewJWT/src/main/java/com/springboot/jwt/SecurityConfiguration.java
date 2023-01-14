package com.springboot.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import com.springboot.jwt.intercepter.AuthenticationTokenFilter;
import com.springboot.jwt.security.CsrfHeaderFilter;
import com.springboot.jwt.security.JWTAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfiguration extends 
WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	private JWTAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.
		userDetailsService(userDetailsService).
		passwordEncoder(PasswordEncoder());
	}

	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception{
		
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean()
	{
		return new AuthenticationTokenFilter();
	}
	
	
	@Override
	protected void configure(HttpSecurity httpsecurity) throws Exception{
		httpsecurity.csrf().disable().exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and().sessionManagement().sessionCreationPolicy
		(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/**").permitAll()
		.antMatchers("/registration").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.anyRequest().authenticated();
		
		httpsecurity.addFilterBefore(authenticationTokenFilterBean(), 
				UsernamePasswordAuthenticationFilter.class)
		.addFilterAfter(new CsrfHeaderFilter(),CsrfFilter.class);
		
		httpsecurity.headers().cacheControl();
		httpsecurity.headers().httpStrictTransportSecurity().
		includeSubDomains(true).maxAgeInSeconds(31536000);
		
		
	}
	
}
