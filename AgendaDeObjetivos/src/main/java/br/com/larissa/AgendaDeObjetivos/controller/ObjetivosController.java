package br.com.larissa.AgendaDeObjetivos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.larissa.AgendaDeObjetivos.domain.Objetivo;
import br.com.larissa.AgendaDeObjetivos.domain.TodosObjetivos;


@RestController
public class ObjetivosController {
	
	private TodosObjetivos todosObjetivos;
	
	
	public ObjetivosController(TodosObjetivos todosObjetivos) {
		this.todosObjetivos = todosObjetivos;
	}
	
	@PostMapping("/objetivos")	
	public ResponseEntity<String> cadastrar( @RequestBody Objetivo objetivo){
		todosObjetivos.save(objetivo);
//		return ResponseEntity.ok("Sucesso");
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}
	
	@GetMapping("/objetivos/data/{data}")
	public ResponseEntity<List<Objetivo>> listarPorData(@PathVariable("data") String dataString){
		LocalDate data = LocalDate.parse(dataString);
		List<Objetivo> objetivos = todosObjetivos.ate(data);
		if(objetivos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(objetivos);
	}
	
	
}
