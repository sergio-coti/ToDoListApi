package br.com.cotiinformatica.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.TodoRequest;
import br.com.cotiinformatica.dtos.TodoResponse;
import br.com.cotiinformatica.entities.Todo;
import br.com.cotiinformatica.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired TodoRepository todoRepository;
	@Autowired ModelMapper modelMapper;
	
	public TodoResponse create(TodoRequest request) throws Exception {
		
		Todo todo = modelMapper.map(request, Todo.class);
		todoRepository.save(todo);
		
		return modelMapper.map(todo, TodoResponse.class);
	}
	
	public TodoResponse update(Long id, TodoRequest request) throws Exception {
		
		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new Exception("Todo not found!"));
		
		todo.setTitle(request.getTitle());
		todo.setDescription(request.getDescription());
		todo.setCompleted(request.isCompleted());
		
		todoRepository.save(todo);
		
		return modelMapper.map(todo, TodoResponse.class);
	}
	
	public TodoResponse delete(Long id) throws Exception {

		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new Exception("Todo not found!"));
		
		todoRepository.delete(todo);
		
		return modelMapper.map(todo, TodoResponse.class);
	}
	
	public List<TodoResponse> getAll() throws Exception {

		List<TodoResponse> response = todoRepository.findAll()
				.stream()
				.map(todo -> modelMapper.map(todo, TodoResponse.class))
				.collect(Collectors.toList());
		
		return response;
	}
	
	public TodoResponse getById(Long id) throws Exception {
		
		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new Exception("Todo not found!"));
		
		return modelMapper.map(todo, TodoResponse.class);		
	}
}
