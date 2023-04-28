package com.jarodsmith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/formularioLogin")
	public String login() {
		return "loginForm";
	}
	
	@GetMapping("/formularioLogout")
	public String logout() {
		return "logoutForm";
	}
	
	//AGREGAR MAPPING PARA PAGINA DE ERROR 403 FORBBIDEN
	@GetMapping("/acceso-denegado")
	public String muestraAccesoDenegado() {
		return "acceso-denegado";
	}
}
