package com.jarodsmith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

	@GetMapping("/agregarPaciente")
	public String agregarPaciente() {
		return "paciente/nuevoPacienteForm";
	}
}
