package com.jarodsmith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jarodsmith.dao.impl.UserDAOImpl;
import com.jarodsmith.model.Users;



@Controller
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
		Users user = userDAO.buscarPorNombre(usuario);
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		mav.setViewName("users/editUsersForm");
		return mav;
	}
	
	@PostMapping("/actualizarUsuario")
	public ModelAndView actualizarUsuario(@ModelAttribute("user") Users user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		System.out.println("ESTOY EN EL METODO POST");
		//VALIDACION DE ERRORES
		if(result.hasErrors()) {
			mav.setViewName("users/editUsersForm");
			return mav;
		}
		
		//ACTUALIZAR AL USUARIO
		userDAO.actualizar(user);
		
		//REDIRECCIONAR A LA VISTA DE USUARIOS
		mav.setViewName("redirect:/listaUsuarios");
		return mav;
	}
}
