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
		//System.out.println("CREARCLIENTEPOST" + cliente.toString());
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
	
	//PERMITE LA VISUALIZACION DEL CLIENTE
	@GetMapping("/eliminarCliente")
	public ModelAndView eliminarUsuario(@RequestParam("cliente") String idCliente) {
		
		Cliente cliente = clienteDAO.buscarPorId(Integer.parseInt(idCliente));
		ModelAndView mav = new ModelAndView();
		mav.addObject("cliente", cliente);
		mav.setViewName("cliente/deleteClienteForm");
		return mav;
	}
	
	//PERMITE LA ELIMINACIÓN DEFINITIVA EN LA BBDD
	@PostMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("idCliente") String idCliente) {
		clienteDAO.borrar(Integer.parseInt(idCliente));
		return "redirect:/cliente/listarClientes";
	}
	
	//PERMITE LA VISUALIZACION DEL CLIENTE CON SUS DATOS
	@GetMapping("/editarCliente")
	public ModelAndView editarCliente(@RequestParam("cliente") String idCliente) {
		//CREO UN OBJETO DE TIPO CLIENTE CON LOS DATOS RECUPERADOS DEL DAO
		Cliente cliente = clienteDAO.buscarPorId(Integer.parseInt(idCliente));
		
		ModelAndView mav = new ModelAndView();
		//System.out.println("[GETEDITCLIENTE]: " + cliente.toString()); //DEBUG
		
		//ENVIAR OBJETO CLIENTE HACIA LA VISTA
		mav.addObject("cliente", cliente);
		mav.setViewName("cliente/editClienteForm");
		return mav;
	}
	
	//PERMITE EL GUARDADO DEFINITIVO EN LA BBDD
	@PostMapping("/actualizarCliente")
	public ModelAndView actualizarCliente(@ModelAttribute("clienteForm") Cliente clienteForm) {
		ModelAndView mav = new ModelAndView();
		//System.out.println(clienteForm.toString()); //DEBUG
		clienteDAO.actualizar(clienteForm);
		//REDIRECCIONAR AL LISTADO DE CLIENTES
		mav.setViewName("redirect:/cliente/listarClientes");
		return mav;
	}
	
}




