package com.thevoicesistem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.thevoicesistem.security.JWTAuthenticationFilter;
import com.thevoicesistem.security.JWTAuthorizationFilter;
import com.thevoicesistem.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	
	
	
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired 
	private JWTUtil jwtUtil;

	
	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**"
			
			
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/artistas/**",
			"/usuarios/**",
			"/albuns/**"
			
	};	
	
	private static final String[] PUBLIC_MATCHERS_POST = {
			
	};	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.headers().frameOptions().disable();
		
		http.cors().and().csrf().disable()
		
		.addFilter(new  JWTAuthenticationFilter(authenticationManager(), jwtUtil))
	    .addFilter(new  JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated();
		
		
	/*	
		http.cors().and().csrf().disable();
		http. authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			. anyRequest().authenticated();
		http.addFilter(new  JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	*/	 
		 
	}
	
	 @Override
	 public void configure (AuthenticationManagerBuilder auth) throws Exception{
		
	   auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder());
	 }

	
	// 68 - FINALIZADO Configuração inicial do spring security
	@Bean
	CorsConfigurationSource corsConfigurationSource() {

	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	} 




}
