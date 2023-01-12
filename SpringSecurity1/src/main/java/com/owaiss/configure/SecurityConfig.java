package com.owaiss.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.owaiss.filters.JwtTokenGeneratorFilter;
import com.owaiss.filters.JwtTokenValidatorFilter;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain projectSecurityFilter(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth) ->auth
				.requestMatchers("/app/welcomeP").authenticated()
				.requestMatchers("/app/employee/admin").hasRole("admin")
				.requestMatchers("/app/welcome","/app/employee/register").permitAll()
				
		).addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.csrf().disable()
		.httpBasic();		
		
		
		return http.build();
	}

	//used for testing purpose only: 
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//	
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//	    UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
//	    UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//	    userDetailsService.createUser(admin);
//	    userDetailsService.createUser(user);
//	    return userDetailsService;
//	}
	

	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
	
	
	
	
}
