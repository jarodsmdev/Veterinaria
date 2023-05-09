package com.jarodsmith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TelefonoController {
	@GetMapping("/editarTelefono")
	public String editarTelefono() {
		return "telefono/editPhoneForm";
	}
	
	@GetMapping("/agregaTelefono")
	public String agregaTelefono() {
		return "telefono/addPhoneForm";
	}
}
