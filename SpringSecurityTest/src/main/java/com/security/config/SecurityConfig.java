package com.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUser = User
				.withUsername("normal")
				.password(passwordEncoder().encode("normal"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUser = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		UserDetails guestUser = User
				.withUsername("guest")
				.password(passwordEncoder().encode("guest"))
				.roles("GUEST")
				.build();
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser,adminUser, guestUser);
	  return inMemoryUserDetailsManager;	
		// If we use Database then it will use
//		return new CustomUserDetailService();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.csrf()
		.disable()
		.authorizeHttpRequests()
		
		// Role Based 
		//------------------
		/* => We can use method lavel also
		.requestMatchers("/home/admin/**")
		.hasRole("ADMIN")
		.requestMatchers("/home/normal")
		.hasRole("NORMAL")
		.requestMatchers("/home/guest")
		.hasRole("GUEST")
		*/
		//-------------------------------
		
		
		.requestMatchers("/home/public")
		.permitAll().anyRequest()
		.authenticated()
		.and()
		.formLogin();
		return httpSecurity.build();
	}
}
