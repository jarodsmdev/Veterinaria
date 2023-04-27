package com.jarodsmith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AtencionController {
	@GetMapping("/nuevaAtencion")
	public String nuevaAtencion() {
		return "atencion/nuevaAtencionForm";
	}
}
