package com.apigetway.config;

//import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;

//@Configuration
//@EnableMethodSecurity
//@EnableWebFluxSecurity
public class SecurityConfig {
	
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//		
//		httpSecurity
//					.authorizeExchange()
//					.anyExchange()
//					.authenticated()
//					.and()
//					.oauth2Client()
//					.and()
//					.oauth2ResourceServer()
//					.jwt();
//		
//		return httpSecurity.build();
//	}
	
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails normal = User.withUsername("manav").password(passwordEncoder().encode("password")).roles("NORMAL").build();
//		
//		UserDetails admin = User.withUsername("manav1").password(passwordEncoder().encode("password")).roles("ADMIN").build();
//		
//		//InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//		return new InMemoryUserDetailsManager(normal, admin);
//		 
//	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//		httpSecurity
//					.csrf().disable()
//					.authorizeHttpRequests()
//					.antMatchers("/auth/admin")
//					.hasRole("ADMIN")
//					.antMatchers("/auth/normal")
//					.hasRole("NORMAL")
//					.antMatchers("/auth/public")
//					.permitAll()
//					.anyRequest()
//					.authenticated()
//					.and()
//					.httpBasic();
//					
//		return httpSecurity.build();
//	}
}
