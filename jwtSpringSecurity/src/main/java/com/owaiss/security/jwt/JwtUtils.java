package com.owaiss.security.jwt;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.owaiss.service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

	//methods for parsing JWT tokens
	
	@Value("${owaiss.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${owaiss.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	@Value("${owaiss.app.jwtCookieName}")
	private String jwtCookie;
	
	
	//Get JWT from client request:
	public String getJwtFromCookies(HttpServletRequest req) {
		Cookie cookie= WebUtils.getCookie(req, jwtCookie);
		if(cookie != null) {
			return cookie.getValue();
		}else return null;
	}
	
	
	//to delete cookie from clients device:
	public ResponseCookie getDeleteJwtCookie() {
		return ResponseCookie.from(jwtCookie, null).path("/api").build();
	}
	
	
	
	//to generate cookie with jwt token (will be sent with response):
	public ResponseCookie generateJwtCookie(UserDetailsImpl userDetails) {
		String jwt = generateTokenFromUserName(userDetails.getUsername());
		
		ResponseCookie cookie= ResponseCookie.from(jwtCookie,jwt).path("/api").maxAge(24 * 60 * 60)
			.build();
		return cookie;
	}
	
	
	//to get username from the token:
	public String getUserNameFromJwtToken(String token) {
       return Jwts.parser().setSigningKey(jwtSecret)
    		   .parseClaimsJws(token)
    		   .getBody().getSubject();		
	}
	
	
	
	//to validate JWT token:
	public boolean validateJwtToken(String authToken) {
		try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
		return true;
		}catch(SignatureException e) {
			System.out.println(e.getMessage());
		}catch(ExpiredJwtException e) {
			System.out.println(e.getMessage());
		}catch(MalformedJwtException e) {
			System.out.println(e.getMessage());
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}catch(UnsupportedJwtException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	
	
	//to generate a new token by username:
	public String generateTokenFromUserName(String username) {
		
		return	Jwts.builder().setSubject(username)
		.setIssuedAt(new Date())
		.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		 
	}
	
}
