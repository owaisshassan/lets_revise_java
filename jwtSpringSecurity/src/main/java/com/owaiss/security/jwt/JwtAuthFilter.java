package com.owaiss.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.owaiss.service.UserDetailsImpl;
import com.owaiss.service.UserDetailsServiceImpl;

@Component
public class JwtAuthFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils jwtUtils;
	
//	@Autowired
//	private UserDetailsImpl userDetailsImpl;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// logic of how to filter requests containing jwt token:
		try {
			String jwt = jwtUtils.getJwtFromCookies(request);
			if(jwt != null) {
				if(jwtUtils.validateJwtToken(jwt)){
					String username = jwtUtils.getUserNameFromJwtToken(jwt);
					UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
					
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities() );
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Could not set the authentication");
		}
		
		filterChain.doFilter(request, response);
	}

}
