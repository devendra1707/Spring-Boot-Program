package com.springboot.jwt.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 3635000981572157265L;

	static final String CLAM_KEY_USERNAME = "sub";
	static final String CLAM_KEY_AUDIENCE = "audience";
	static final String CLAM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUserNameFromToken(String authToken) {

		String userName = null;
		try {
			final Claims cliams = getCliamsFromToken(authToken);
			userName = cliams.getSubject();
		} catch (Exception e) {
			userName = null;
		}

		return userName;
	}

	private Claims getCliamsFromToken(String authToken) {

		Claims claims = null;

		try {
			claims = Jwts.parser().setSigningKey(secret).
					parseClaimsJws(authToken).getBody();

		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	public boolean validateToken(String authToken, UserDetails userDetails) {

		JwtUser user = (JwtUser) userDetails;
		final String username = getUserNameFromToken(authToken);
		return (username.equals(user.getUsername()) && 
				!isTokenExpired(authToken));

		// return false;
	}

	private boolean isTokenExpired(String authToken) {
		final Date expiration = getExpirationDateFromToken(authToken);
		
		return expiration.before(new Date());
	}

	private Date getExpirationDateFromToken(String authToken) {
		Date expiration = null;

		try {

			final Claims claims = getCliamsFromToken(authToken);
			if (claims != null) {
				expiration = claims.getExpiration();
			}
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public String generateToken(JwtUser userDetails) {
		
		Map<String,Object> claims=new HashMap<String, Object>();
		claims.put(CLAM_KEY_USERNAME, userDetails.getUsername());
		claims.put(CLAM_KEY_CREATED, new Date());
		return generatetoken(claims);
		
		
	}

	private String generatetoken(Map<String, Object> claims) {
		
		return Jwts.builder().setClaims(claims).
				setExpiration(generateExpirationDate()).
				signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date generateExpirationDate() {
		// TODO Auto-generated method stub
		return new Date(System.currentTimeMillis() + expiration*1000);
	}

}
