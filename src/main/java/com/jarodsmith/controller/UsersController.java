package com.jarodsmith.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jarodsmith.dao.impl.AuthoritiesDAOImpl;
import com.jarodsmith.dao.impl.UserDAOImpl;
import com.jarodsmith.model.Authorities;
import com.jarodsmith.model.Users;



@Controller
@RequestMapping("/usuarios")
public class UsersController {

	/*
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/listarUsuarios")
	public ModelAndView listUsers() {
		String sql = "SELECT * FROM users";
		ModelAndView mav = new ModelAndView();
		List datos = this.jdbcTemplate.queryForList(sql);
		mav.addObject("datos",datos);
		mav.setViewName("users/listForm");
		return mav;
	}
	*/
	
	
	@Autowired
	private UserDAOImpl userDAO;
	
	@Autowired
	private AuthoritiesDAOImpl authoritiesDAO;
	
	/**
	* Devuelve una vista con la lista de usuarios obtenidos desde la base de datos.
	* @return ModelAndView objeto que representa la vista de la lista de usuarios
	*/
	@GetMapping("/listarUsuarios")
	public ModelAndView listaUsuarios() {
		List<Users> users = userDAO.obtenerTodos();
		ModelAndView mav = new ModelAndView();
		mav.addObject("datos", users);
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
		System.out.println("[GETEDITARUSUARIO]: " + user.toString());
		
		//ENVIO EL OBJETO USERS A LA VISTA
		mav.addObject("user", user);
		mav.setViewName("users/editUsersForm");
		return mav;
	}
	
	@PostMapping("/actualizarUsuario")
	public ModelAndView actualizarUsuario(@ModelAttribute("userForm") Users userForm,
										@RequestParam("rolesAsignados") List<String> rolesAsignados,
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

	    for(String rol: rolesAsignados) {

	        //CREAR UN OBJETO POR CADA ROL
	        Authorities authorities = new Authorities();
	        authorities.setUsername(userForm.getUsername());
	        authorities.setAuthority(rol);

	        //AÑADIR CADA OBJETO A LA LISTA
	        listaRoles.add(authorities);

	        //GUARDAR AUTHORITIES EN LA BD
	        authoritiesDAO.insertar(authorities);

	    }
	    
	    //AGREGAR LA LISTA AL OBJETO user
	    userForm.setAuthorities(listaRoles);

		//ACTUALIZAR AL USUARIO
		userDAO.actualizar(userForm);
		System.out.println("[USERFORM]: " + userForm.toString()); //DEBUG
		
		//REDIRECCIONAR A LA VISTA DE USUARIOS
		mav.setViewName("redirect:/usuarios/listarUsuarios");
		return mav;
	}
	
	@GetMapping("/nuevoUsuario")
	public ModelAndView nuevoUsuario() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("users/addUserForm");
		return mav;
	}
	
/*
 	@PostMapping("/crearUsuario")
		public ModelAndView nuevoUsuario(@ModelAttribute("userForm") Users userForm, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		//GUARDAR USUARIO
		userDAO.insertar(userForm);
		System.out.println("[USERFORM]: " + userForm.toString()); //DEBUG
		
		//REDIRECCIONAR A LA VISTA DE USUARIOS
		mav.setViewName("redirect:/usuarios/listarUsuarios");
		return mav;
	}
 **/
	@PostMapping("/crearUsuario")
	public ModelAndView nuevoUsuario(@ModelAttribute("userForm") Users userForm,
									@RequestParam("rolesAsignados") List<String> rolesAsignados,
									BindingResult result) {
	
		ModelAndView mav = new ModelAndView();
		
		//GUARDAR USUARIO EN LA BD
		userDAO.insertar(userForm);
	
		//ASIGNAR ROLES AL USUARIO
		List<Authorities> listaRoles = new ArrayList<>();
	
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
		
		//AGREGAR LA LISTA AL OBJETO user
		userForm.setAuthorities(listaRoles);
		

		System.out.println("[USERFORM]: " + userForm.toString()); //DEBUG
		
		//REDIRECCIONAR A LA VISTA DE USUARIOS
		mav.setViewName("redirect:/usuarios/listarUsuarios");
		return mav;
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
