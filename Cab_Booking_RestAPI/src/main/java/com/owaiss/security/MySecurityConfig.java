package com.owaiss.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class MySecurityConfig {
	
	
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("user").password("$2a$12$4C95HV4CaDGf.8fTojdAYu/zC8omkc6UI6UCXymwGJeFr6B8JEg0.").authorities("user").build();	
		userDetails.createUser(user);
		return userDetails;
	}
	
	
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				(auth) -> auth.antMatchers("/masaicab/user/login","/masaicab/user/findride","/masaicab/user/book/{driverId}/{x}/{y}"
						).authenticated()
				
		).csrf().disable()
		.httpBasic();
		
		return http.build();
	}
	
	
	@Bean
	public PasswordEncoder encodePassword() {
		//return NoOpPasswordEncoder.getInstance(); //Not recommended
		return new BCryptPasswordEncoder();
	}

}
