package com.jarodsmith.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Clase que configura la aplicación para su funcionamiento con Spring MVC.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jarodsmith")
public class AppConfig implements WebMvcConfigurer{
	
	/**
	 * Configura el ViewResolver que se encarga de buscar las vistas para el controlador.
	 * @return Un objeto ViewResolver configurado para buscar las vistas en /WEB-INF/view/ con extensión .jsp.
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/**
	 * Configura los ResourceHandlers que se encargan de buscar los recursos estáticos (como CSS, JS, imágenes, etc.).
	 * @param registry El registro de los ResourceHandlers.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
