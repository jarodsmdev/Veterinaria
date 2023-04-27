package com.jarodsmith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
	@GetMapping("/nuevoCliente")
	public String nuevoCliente() {
		return "cliente/nuevoClienteForm";
	}
}




