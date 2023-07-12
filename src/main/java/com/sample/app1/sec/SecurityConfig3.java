package com.sample.app1.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig3 {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtFilter securityFilter;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private InvalidUserAuthenticationEntryPoint authenticationEntryPoint;

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider  = new DaoAuthenticationProvider(); 
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable();
		httpSecurity.authorizeHttpRequests()
				.antMatchers("/user/signup", "/user/login").permitAll()
				.antMatchers("/bankaccounts").hasAuthority("ROLE_ADMIN")
				.antMatchers(HttpMethod.GET, "/bankaccounts/rolecustomer").hasAuthority("ROLE_CUSTOMER")
//				.antMatchers(HttpMethod.GET, "/bankaccounts/roleadmin").hasAuthority("ROLE_ADMIN")
//				.antMatchers(HttpMethod.GET, "/bankaccounts/rolecustomer").hasAuthority("ROLE_CUSTOMER")								
				.anyRequest().authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
				.and()
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
}
