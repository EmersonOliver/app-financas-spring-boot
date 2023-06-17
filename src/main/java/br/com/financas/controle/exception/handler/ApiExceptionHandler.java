package br.com.financas.controle.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = {ApiException.class})
	public ResponseEntity<ErrorHandler> erroApi(ApiException ex, WebRequest request){
		ErrorHandler error = new ErrorHandler(
				HttpStatus.BAD_REQUEST,
				LocalDateTime.now(),
				ex.getMessage(),
				ex.getLocalizedMessage());
		return new ResponseEntity<ErrorHandler>(error, HttpStatus.BAD_REQUEST);
	}
	
}
