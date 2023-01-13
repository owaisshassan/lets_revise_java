package com.owaiss.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain projectSecurityFilter(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth) ->auth
				.antMatchers("/masaimail/login","/masaimail/user","/masaimail/delete/{id}").authenticated()
				.antMatchers("/masaimail/register","/masaimail/mail",
						"/masaimail/starred","/masaimail/starred/{id}")
				.permitAll()
				
		)
		.csrf().disable()
		.httpBasic();		
		
		
		return http.build();
	}

	//used for testing purpose only: 
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//	    UserDetails admin = User.withUsername("admin").password("1234").authorities("admin").build();
//	    UserDetails user = User.withUsername("user").password("1234").authorities("read").build();
//	    userDetailsService.createUser(admin);
//	    userDetailsService.createUser(user);
//	    return userDetailsService;
//	}
	

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
	
}
