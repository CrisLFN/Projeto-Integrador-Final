package com.AppPI.AppPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
		.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	// Método que configura quais seções do site podem ser acessadas com e sem login
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/pedido").permitAll().anyRequest()
		.authenticated().and().formLogin().permitAll()
		.and().logout().permitAll()
		.and().csrf().disable();
		
	}

}
