package br.com.financas.controle.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorHandler {
	
	private HttpStatus status;
	private LocalDateTime date;
	private String message;
	private String description;
	public ErrorHandler(HttpStatus status, LocalDateTime date, String message, String description) {
		super();
		this.status = status;
		this.date = date;
		this.message = message;
		this.description = description;
	}
	
	
	

}
