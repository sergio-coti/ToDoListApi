package br.com.cotiinformatica.controllers;

import java.util.List;

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

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@PostMapping
	public ResponseEntity<TodoResponse> post(@RequestBody TodoRequest request) {
		return ResponseEntity.status(201).body(null);
	}

	@PutMapping("{id}")
	public ResponseEntity<TodoResponse> put(@PathVariable Long id, @RequestBody TodoRequest request) {
		return ResponseEntity.status(200).body(null);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<TodoResponse> delete(@PathVariable Long id) {
		return ResponseEntity.status(200).body(null);
	}

	@GetMapping
	public ResponseEntity<List<TodoResponse>> getAll() {
		return ResponseEntity.status(200).body(null);
	}

	@GetMapping("{id}")
	public ResponseEntity<TodoResponse> getById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(null);
	}

}
