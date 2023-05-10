package com.jarodsmith.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jarodsmith.dao.impl.AuthoritiesDAOImpl;
import com.jarodsmith.dao.impl.UserDAOImpl;
import com.jarodsmith.model.Authorities;
import com.jarodsmith.model.Users;



@Controller
@RequestMapping("/usuarios")
public class UsersController {
	
	@Autowired
	private UserDAOImpl userDAO;
	
	@Autowired
	private AuthoritiesDAOImpl authoritiesDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	* Devuelve una vista con la lista de usuarios obtenidos desde la base de datos.
	* @return ModelAndView objeto que representa la vista de la lista de usuarios
	*/
	@GetMapping("/listarUsuarios")
	public ModelAndView listaUsuarios() {
		List<Users> users = userDAO.obtenerTodos();
		final String GETONEWITHROLES = "SELECT users.username, COUNT(authorities.authority) AS num_roles FROM users INNER JOIN authorities ON users.username = authorities.username GROUP BY users.username ORDER BY users.username";
		List<Map<String, Object>> resumenUsuarios = jdbcTemplate.queryForList(GETONEWITHROLES);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("datos", users);
		mav.addObject("resumen", resumenUsuarios);
		mav.setViewName("users/listUsersForm");
		return mav;
	}
	
	/**
	* Obtiene la vista para editar un usuario específico según su nombre de usuario.
	* @param usuario El nombre de usuario del usuario a editar.
	* @return El ModelAndView con la vista para editar el usuario.
	*/
	@GetMapping("/editarUsuario")
	public ModelAndView editarUsuario(@RequestParam("usuario") String usuario) {
		//CREO UN OBJETO TIPO USERS CON LOS DATOS RECUPERADOS DEL DAO
		Users user = userDAO.buscarPorNombre(usuario);
		
		//CREO UNA LISTA CON LOS ROLES RECUPERADOS DEL DAO
		List<Authorities> listaRoles = authoritiesDAO.buscarRolesPorUsername(usuario);
		
		//SETEO LA LISTA DE ROLES AL OBJETO
		user.setAuthorities(listaRoles);
		
		ModelAndView mav = new ModelAndView();
		//System.out.println("[GETEDITARUSUARIO]: " + user.toString()); //DEBUG
		
		//ENVIO EL OBJETO USERS A LA VISTA
		mav.addObject("user", user);
		mav.setViewName("users/editUsersForm");
		return mav;
	}
	
	@PostMapping("/actualizarUsuario")
	public ModelAndView actualizarUsuario(@ModelAttribute("userForm") Users userForm,
			 							@RequestParam(value = "rolesAsignados", required = false) List<String> rolesAsignados,
										BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		//VALIDACION DE ERRORES
		/*if(result.hasErrors()) {
			mav.setViewName("users/editUsersForm");
			return mav;
		}
		*/
		//ELIMINAR ROLES ANTIGUOS DEL USUARIO
		authoritiesDAO.eliminarRolesPorUsername(userForm.getUsername());
		
		//ASIGNAR NUEVOS ROLES AL USUARIO
		List<Authorities> listaRoles = new ArrayList<>();

		if(rolesAsignados != null) {
		    for(String rol: rolesAsignados) {
		    	System.out.println("[ROL] " + rol);
		        //CREAR UN OBJETO POR CADA ROL
		        Authorities authorities = new Authorities();
		        authorities.setUsername(userForm.getUsername());
		        authorities.setAuthority(rol);
		        
		        //System.out.println("[ACTUALIZARUSUARIO]: " + authorities.toString()); //DEBUG
		        
		        //GUARDAR AUTHORITIES EN LA BD
		        authoritiesDAO.insertar(authorities);

		        //AÑADIR CADA OBJETO A LA LISTA
		        listaRoles.add(authorities);

		    }
		}

	    //AGREGAR LA LISTA AL OBJETO user
	    userForm.setAuthorities(listaRoles);
	    
	    //ENCRIPTAR LA CONTRASEÑA ANTES DE GUARDAR EN BD
  		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  		String hashedPassword = passwordEncoder.encode(userForm.getPassword());
  		userForm.setPassword(hashedPassword);

		//ACTUALIZAR AL USUARIO
		userDAO.actualizar(userForm);
		System.out.println("[ACTUALIZARUSUARIO]: " + userForm.toString()); //DEBUG
		
		//REDIRECCIONAR A LA VISTA DE USUARIOS
		mav.setViewName("redirect:/usuarios/listarUsuarios");
		return mav;
	}
	
	@GetMapping("/nuevoUsuario")
	public ModelAndView nuevoUsuario(@ModelAttribute("userForm") Users userForm) {
		ModelAndView mav = new ModelAndView();
		mav.addObject(userForm);
		mav.setViewName("users/addUserForm");
		return mav;
	}
	

	@PostMapping("/crearUsuario")
	public ModelAndView nuevoUsuario(@Valid @ModelAttribute("userForm") Users userForm,
									@RequestParam(value = "rolesAsignados", required = false) List<String> rolesAsignados,
									BindingResult resultadoValidacion) {
		
		if(resultadoValidacion.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.addObject(userForm);
			mav.addObject("resultadoValidacion", resultadoValidacion);
			mav.setViewName("users/addUserForm");
			return mav;
		}else {

			try {
				//System.out.println("[USERCONTROLLER] " + userForm); //DEBUG
				
				ModelAndView mav = new ModelAndView();
				
				//ENCRIPTAR LA CONTRASEÑA ANTES DE GUARDAR EN BD
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(userForm.getPassword());
				userForm.setPassword(hashedPassword);
				
				//GUARDAR USUARIO EN LA BD
				userDAO.insertar(userForm);
			
				//ASIGNAR ROLES AL USUARIO
				List<Authorities> listaRoles = new ArrayList<>();
			
				if(rolesAsignados != null) {
					for(String rol: rolesAsignados) {
						
						//CREAMOS UN OBJETO POR CADA ROL
						Authorities authorities = new Authorities();
						authorities.setUsername(userForm.getUsername());
						authorities.setAuthority(rol);
						
						//AÑADIREMOS CADA OBJETO A LA LISTA
						listaRoles.add(authorities);
						
						//GUARDAR AUTHORITIES EN LA BD
						authoritiesDAO.insertar(authorities);
						
					}
				}
				
				//AGREGAR LA LISTA AL OBJETO user
				userForm.setAuthorities(listaRoles);
				
				//System.out.println("[USERFORM]: " + userForm.toString()); //DEBUG
				
				//REDIRECCIONAR A LA VISTA DE USUARIOS
				mav.addObject("success", "Usuario creado satisfactoriamente.");
				mav.setViewName("redirect:/usuarios/listarUsuarios");
				return mav;
			} catch (DuplicateKeyException ex) {
			    // CONTROLA EL ERROR DE CLAVE PRIMARIA DUPLICADA
			    //System.out.println("[ERROR USERCONTROLLER] " + ex); //DEBUG
			    ModelAndView mav = new ModelAndView();
			    mav.addObject("error", "El nombre de usuario ya está en uso. Por favor, elija otro nombre de usuario.");
			    mav.setViewName("users/addUserForm");
			    return mav;
			}
		}
	}

	@GetMapping("/eliminarUsuario")
	public ModelAndView eliminarUsuario(@RequestParam("usuario") String usuario) {
		Users user = userDAO.buscarPorNombre(usuario);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("users/deleteUsersForm");
		return mav;
	}
	
	@PostMapping("/eliminarUsuario")
	public ModelAndView eliminarUsuario(@ModelAttribute("userForm") Users userForm, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		//System.out.println("[POST]: " + userForm.toString()); //DEBUG
		
		//ELIMINAR AL USUARIO POR EL USERNAME
		userDAO.borrarPorUsername(userForm.getUsername());
	
		//REDIRECCIONAR A LA VISTA DE USUARIOS
		mav.setViewName("redirect:/usuarios/listarUsuarios");
		return mav;
	}
}
