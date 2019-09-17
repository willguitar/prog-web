package br.com.larissa.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.larissa.AgendaDeObjetivos.domain.TodosUsuarios;
import br.com.larissa.AgendaDeObjetivos.domain.Usuario;

@RestController
public class LoginController {

	/*
	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		
		if(credenciais.getSenha().equals(credenciais.getLogin())) {
		
			return ResponseEntity.ok("sucesso");
	}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("erro");
	}
	
	*/
	
	TodosUsuarios TodosUsuarios;
	
	public LoginController(TodosUsuarios todosUsuarios) {
		super();
		this.TodosUsuarios = todosUsuarios;
	}
	
	
	
	@PostMapping("/login")
	public BodyBuilder existe(@RequestBody @PathVariable("login") String login , @PathVariable("senha") String senha){
		if(TodosUsuarios.existe(login, senha) == false) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.accepted();
	
	
	}

