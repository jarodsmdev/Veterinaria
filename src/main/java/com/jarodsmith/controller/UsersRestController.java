package com.jarodsmith.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarodsmith.dao.impl.AuthoritiesDAOImpl;
import com.jarodsmith.dao.impl.UserDAOImpl;
import com.jarodsmith.model.Authorities;
import com.jarodsmith.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
public class UsersRestController {
	
	@Autowired
	private UserDAOImpl userDAO;
	
	@Autowired
	private AuthoritiesDAOImpl authoritiesDAO;
	
	@GetMapping("/testAPI")
    public ResponseEntity<Users> obtenerSaludo() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Mi-Encabezado", "Valor del encabezado");
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<Authorities> roles = new ArrayList<>();
        Authorities auth = new Authorities();
        auth.setUsername("EJEMPLO API REST");
        auth.setAuthority("ROLE_ADMINISTRADOR");
        roles.add(auth);

        Users user = new Users();
        user.setUsername("API REST");
        user.setPassword("PASSWORD SIN ENCRIPTAR");
        user.setEnabled(1);
        user.setAuthorities(roles);

        return ResponseEntity
                .status(HttpStatus.OK) //ESTO INDICA EL CODIGO DE RESPUESTA 200
                .headers(headers)
                .body(user);
    }


	@PostMapping("/addUser")
	public ResponseEntity<Users> crearUsuario(@RequestBody Users usuario) {

	    // GUARDAR USUARIO EN LA BD
	    userDAO.insertar(usuario);

	    return ResponseEntity
	    		.status(HttpStatus.CREATED)
	    		.body(usuario);
	}


    @GetMapping("/user/{username}")
    public ResponseEntity<Users> obtenerUsuarioPorId(@PathVariable String username) {
    	//CREO UN OBJETO TIPO USERS CON LOS DATOS RECUPERADOS DEL DAO
    	Users user = userDAO.buscarPorNombre(username);
    	
		//CREO UNA LISTA CON LOS ROLES RECUPERADOS DEL DAO
		List<Authorities> listaRoles = authoritiesDAO.buscarRolesPorUsername(username);
		
		//SETEO LA LISTA DE ROLES AL OBJETO
		user.setAuthorities(listaRoles);

        return ResponseEntity
        		.status(HttpStatus.OK) //CODIGO 200
        		.body(user);
    }

    @PutMapping("/user/{id}")
    public Users actualizarUsuario(@PathVariable int id, @RequestBody Users usuario) {
        // Lógica para actualizar un usuario en la base de datos
        return usuario;
    }

    @DeleteMapping("/user/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        // Lógica para eliminar un usuario de la base de datos
        return "Usuario eliminado con éxito";
    }
}
