package com.jarodsmith.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource seguridadDataSource;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(seguridadDataSource);
		
		//CONECTAR CON BBDD (POR AHORA NO)
		/*UserBuilder usuarios = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(usuarios.username("Juan").password("123").roles("USUARIO", "AYUDANTE", "ADMINISTRADOR"))
			.withUser(usuarios.username("Antonio").password("456").roles("USUARIO"))
			.withUser(usuarios.username("Ana").password("789").roles("USUARIO", "AYUDANTE"))
			.withUser(usuarios.username("Laura").password("321").roles("USUARIO", "ADMINISTRADOR"));
		*/

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("USUARIO")
		.and().formLogin()
		.loginPage("/formularioLogin")
		.loginProcessingUrl("/autenticarUsuario")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/acceso-denegado");
	}
	
	

}
