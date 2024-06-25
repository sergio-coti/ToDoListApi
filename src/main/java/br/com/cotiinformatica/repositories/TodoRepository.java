package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
