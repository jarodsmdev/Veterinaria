package com.jarodsmith.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * Clase que configura la aplicación para su funcionamiento con Spring MVC.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jarodsmith")
@PropertySource("classpath:persistencia-mysql.properties")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	//--SISTEMA DE LOG PARA REVISIONES --
	private Logger miLogger = Logger.getLogger(getClass().getName());
	
	
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
	
	//DEFINIR UN BEAN PARA SEGURIDAD
		@Bean
		public DataSource seguridadDataSource() {
			//CREAR POOL DE CONEXIONES

			ComboPooledDataSource seguridadDataSource = new ComboPooledDataSource();
			
			//ESTABLECER DRIVER JDBC
			try {
				seguridadDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			
			//HACER LOG DE LAS PROPIEDADES DE CONEXION
			miLogger.info("**URL de la BBDD: " + env.getProperty("jdbc.url"));
			miLogger.info("**Usuario conectado a BBDD: " + env.getProperty("jdbc.user"));
			miLogger.warning("**DataSource de seguridad creado correctamente");
			
			//ESTABLECER LAS PROPIEDADES DE CONEXION CON BBDD
			seguridadDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			seguridadDataSource.setUser(env.getProperty("jdbc.user"));
			seguridadDataSource.setPassword(env.getProperty("jdbc.password"));
			
			//ESTABLECER LAS PROPIEDADES DEL POOL DE CONEXIONES
			seguridadDataSource.setInitialPoolSize(getPropPool("connection.pool.initialPoolSize"));
			seguridadDataSource.setMinPoolSize(getPropPool("connection.pool.minPoolSize"));
			seguridadDataSource.setMaxPoolSize(getPropPool("connection.pool.maxPoolSize"));
			seguridadDataSource.setMaxIdleTime(getPropPool("connection.pool.maxIdleTime"));
			
			return seguridadDataSource;
		}
		
		
		private int getPropPool(String nombreProp) {
			
			String propVal = env.getProperty(nombreProp);
			int propPool = Integer.parseInt(propVal);
			
			return propPool;
		}

	
}
