package org.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}123456").roles("USER","ADMIN");
		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}123456").roles("USER");
		/*
         auth.jdbcAuthentication()
         .dataSource(dataSource)
         .usersByUsernameQuery("select id as principal, password as credentials from user where login = ?")
         .authoritiesByUsernameQuery("select id_user as principal, id_role as role from user_role where login = ?")
         .rolePrefix("ROLE_");  */
         
	}  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().loginPage("/login");
            http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
            http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
            http.logout()    
    		.logoutUrl("/login?logout") 
    		.logoutSuccessUrl("/login");
            http.exceptionHandling().accessDeniedPage("/403");
            
	} 
	 }