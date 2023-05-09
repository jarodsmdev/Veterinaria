package com.jarodsmith.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource seguridadDataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.jdbcAuthentication().dataSource(seguridadDataSource);
	    auth.jdbcAuthentication()
	        .dataSource(seguridadDataSource)
	        .passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("USUARIO")
		.antMatchers("/usuarios/**").hasRole("ADMINISTRADOR")
		.and().formLogin()
		.loginPage("/formularioLogin")
		.loginProcessingUrl("/autenticarUsuario")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/acceso-denegado");
	}
	
}
