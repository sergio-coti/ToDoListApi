package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class TodoRequest {

	private String title;
	private String description;
	private boolean completed;
}
