package com.cg.moviesforyou.MovieBookSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.moviesforyou.MovieBookSpringBoot.service.MBSUserDetailsService;

@EnableWebSecurity
public class MBSWebSecurity extends WebSecurityConfigurerAdapter{

	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
		System.out.println(userDetailsService);
	}
	
	@Bean
     public AuthenticationSuccessHandler authenticationSuccessHandler() {
		
		return new AuthenticationSuccessHandlerImpl();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		//System.out.println("inside httpsecurity");
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/Home").permitAll()
		.antMatchers("/AdminHome","/AddCenter","/AddTest","/approve","/approveCenter","/approveAppointment", "/approve").hasRole("ADMIN")
		.antMatchers("/UserHome","/addAppointment","/SelectTests","/confirmAppointment","/viewAppointment","/downloadExcel").hasRole("USER")
		.and().formLogin().usernameParameter("email").passwordParameter("password").loginPage("/login")

		.successHandler(authenticationSuccessHandler())
		.and().logout().logoutSuccessUrl("/").and().csrf().disable();

	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
