package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.TodoRequest;
import br.com.cotiinformatica.dtos.TodoResponse;
import br.com.cotiinformatica.services.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired TodoService todoService;
	
	@PostMapping
	public ResponseEntity<TodoResponse> post(@RequestBody TodoRequest request) throws Exception {		
		return ResponseEntity.status(201).body(todoService.create(request));
	}

	@PutMapping("{id}")
	public ResponseEntity<TodoResponse> put(@PathVariable Long id, @RequestBody TodoRequest request) throws Exception {
		return ResponseEntity.status(200).body(todoService.update(id, request));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<TodoResponse> delete(@PathVariable Long id) throws Exception {
		return ResponseEntity.status(200).body(todoService.delete(id));
	}

	@GetMapping
	public ResponseEntity<List<TodoResponse>> getAll() throws Exception {
		return ResponseEntity.status(200).body(todoService.getAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<TodoResponse> getById(@PathVariable Long id) throws Exception {
		return ResponseEntity.status(200).body(todoService.getById(id));
	}

}
