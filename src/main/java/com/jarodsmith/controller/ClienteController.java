package com.jarodsmith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jarodsmith.dao.impl.ClienteDAOImpl;
import com.jarodsmith.model.Cliente;
import com.jarodsmith.model.Users;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteDAOImpl clienteDAO;
	
	@RequestMapping("/nuevoCliente")
	public String nuevoCliente(Model modelo) {
		
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		return "cliente/addClienteForm";
	}
	
	@PostMapping("/crearCliente")
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		clienteDAO.insertar(cliente);
		return "redirect:/cliente/listarClientes";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes() {
		List<Cliente> clientes = clienteDAO.obtenerTodos();
		ModelAndView mav = new ModelAndView();
		mav.addObject("clientes", clientes);
		mav.setViewName("cliente/listClienteForm");
		return mav;
	}
	
	@GetMapping("/eliminarCliente")
	public ModelAndView eliminarUsuario(@RequestParam("cliente") String idCliente) {
		
		Cliente cliente = clienteDAO.buscarPorId(Integer.parseInt(idCliente));
		ModelAndView mav = new ModelAndView();
		mav.addObject("cliente", cliente);
		mav.setViewName("cliente/deleteClienteForm");
		return mav;
	}
	
	@PostMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("idCliente") String idCliente) {
		clienteDAO.borrar(Integer.parseInt(idCliente));
		return "redirect:/cliente/listarClientes";
	}
}




