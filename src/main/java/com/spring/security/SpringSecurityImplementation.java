package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SpringSecurityImplementation extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {  //@formatter:off
		authentication
		              .inMemoryAuthentication()
		              .withUser("user")
		              .password("{noop}password")
		              .roles("ADMIN");
	} // @formatter:on
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		
		/* Few examples are given here which we have discussed in the articles  and rest of topic we will discuss in the later articles. you
		 * can remove and check out the code one by one.*/	
		
		/* In this below example we are using hasAuthority where we can pass single role access */
	  /*	http
		.authorizeRequests()
			.antMatchers("/delete/**").hasAuthority("ROLE_ADMIN")
			.and()
		.formLogin().and()
		.httpBasic(); */  
		
		/* In this url authorization we are using hasAnyAuthority in which we can pass multiple as shown in the below example */
		
	   /*	  http 
		      .authorizeRequests()
		      .antMatchers("/delete/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER") 
		      .and()
		  .formLogin().and() 
		  .httpBasic(); */  
		
		
		/* In this below example we are using hasRole instead of hasAuthority which is we don't have to add 'ROLE' before the authority */
 /* http
		.authorizeRequests()
			.antMatchers("/delete/**").hasRole("ADMIN")
			.and()
		.formLogin().and()
		.httpBasic(); */   
		
		/* In this below example we are using hasAnyRole instead of hasAnyAuthority which is we don't have to add 'ROLE' before the authority that is only difference */
	  /* http
		.authorizeRequests()
			.antMatchers("/delete/**").hasAnyRole("ADMIN","USER")
			.and()
		.formLogin().and()
		.httpBasic(); */
		
		/* Below Code is not checked yet */
		
		
       /* This is the syntax of how to use the anonymous that means a user which does not have any role */
	   /*   http
			 .authorizeRequests()
			    .antMatchers("/delete/**").anonymous()
			    .and()
			  .formLogin()
			     .and()
			   .httpBasic(); */ 
	
		/* This is the syntax of authenticated which shows the any valid user role */	
		
	 /* http
		 .authorizeRequests()
		    .antMatchers("/delete/**").authenticated()
		    .and()
		  .formLogin()
		     .and()
		   .httpBasic(); */ 
		
		/* FullyAuthenticated means a valid user but not remembered. */	
		
	/*	http
		 .authorizeRequests()
		    .antMatchers("/delete/**").fullyAuthenticated()
		    .and()
		  .formLogin()
		     .and()
		   .httpBasic(); */ 
	
		/* denyAll will simply deny any type of Role */	
	/*	http
		 .authorizeRequests()
		    .antMatchers("/delete/**").denyAll()
		    .and()
		  .formLogin()
		     .and()
		   .httpBasic(); */ 
		
		
		
	} 

}
