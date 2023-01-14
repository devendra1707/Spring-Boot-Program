package com.springboot.jwt.intercepter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.jwt.security.JwtTokenUtil;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired private UserDetailsService userDetailsService;
	
	@Autowired private JwtTokenUtil jwtTokenUtil;
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authToken=request.getHeader(this.tokenHeader);
		
		if(authToken!=null && authToken.length()>7) {
			authToken=authToken.substring(7);
		}
	
		String userName=jwtTokenUtil.getUserNameFromToken(authToken);
		
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=this.userDetailsService.loadUserByUsername(userName);
			boolean isValid=jwtTokenUtil.validateToken(authToken,userDetails);
			if(isValid)
			{
				UsernamePasswordAuthenticationToken authentication=new 
						UsernamePasswordAuthenticationToken(userDetails,
								null,userDetails.getAuthorities());
				
				authentication.setDetails(new WebAuthenticationDetailsSource().
						buildDetails(request));
				SecurityContextHolder.getContext().
				setAuthentication(authentication);
			}
		}
		filterChain.doFilter(request, response);
	}

}
