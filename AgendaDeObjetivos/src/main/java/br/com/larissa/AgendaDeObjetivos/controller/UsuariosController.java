package br.com.larissa.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.larissa.AgendaDeObjetivos.domain.Usuario;

@RestController
public class UsuariosController {

	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nomeUsuario}")
	public ResponseEntity<List <Usuario>> obterPorNome(@PathVariable("nomeUsuario") String nome){
		List<Usuario> usuariosPorNome = new ArrayList<Usuario>();
		for(Usuario u : usuarios) {
			if(u.getNome().equals(nome)) {
				usuariosPorNome.add(u);
			}
		}
		if(usuariosPorNome.isEmpty()) {
		return ResponseEntity.noContent().build();
	} 
		return 	ResponseEntity.ok(usuariosPorNome);
	
	}
	private List<Usuario> obterTodosUsuarios(){
	/*	return Arrays.asList(
				new Usuario ("Larissa", 19), 
				new Usuario ("Larissa", 77), 
				new Usuario ("larii", 20), 
				new Usuario("gui", 5));
				
	*/
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Rodrigo" , 39));
		usuarios.add(new Usuario("Rodrigo" , 39));
		usuarios.add(new Usuario("Rodrigo" , 39));
		usuarios.add(new Usuario("Rodrigo" , 39));
		return usuarios;
				
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(
		@RequestBody Usuario usuario){
		
			this.usuarios.add(usuario);
			return ResponseEntity.ok(usuario);
		
		}
	}

}
