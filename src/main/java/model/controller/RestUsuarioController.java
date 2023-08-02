package model.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.entity.Usuario;
import model.service.UsuarioService;

@RestController
public class RestUsuarioController {
	@Autowired
	private UsuarioService cs;
	
	@RequestMapping(value="/api/clientes", headers="Accept=application/json")
	public List<Usuario> getAllClientes(){
		return cs.getAllClientes();
	}
}
