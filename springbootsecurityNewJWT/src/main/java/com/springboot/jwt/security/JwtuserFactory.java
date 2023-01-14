package com.springboot.jwt.security;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.springboot.jwt.model.User;

public class JwtuserFactory {
	public static JwtUser create(User user) {
		
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),  user, 
				maptoGrantedAuthorities(
						new ArrayList<String>(
								java.util.Arrays.asList
								("ROLE_"+user.getRole()))),user.isEnabled());
	}

	private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		return authorities.stream()
		.map(Authority -> new 
				SimpleGrantedAuthority(Authority)).
		collect(Collectors.toList());
	}

}
