package com.jarodsmith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelefonoController {
	@GetMapping("/editarTelefono")
	public String editarTelefono() {
		return "telefono/editarTelefonoForm";
	}
}
