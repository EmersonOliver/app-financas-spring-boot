package br.com.financas.controle;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.dto.LoginDTO;
import br.com.financas.model.UsuarioModel;

@RestController
@RequestMapping("usuario")
public class UsuarioControleApi {
	
	
	@PostMapping("login")
	public ResponseEntity<UsuarioModel> login( @Valid @RequestBody LoginDTO login) {
		try {
			if(login != null) {
			}
		} catch (Exception e) {
			return new ResponseEntity<UsuarioModel>(HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String,
	 * String> handleValidationExceptions( MethodArgumentNotValidException ex) {
	 * Map<String, String> errors = new HashMap<>();
	 * ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName =
	 * ((FieldError) error).getField(); String errorMessage =
	 * error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return
	 * errors; }
	 */
}
