package br.com.financas.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO {

	@NotNull(message = "E-mails is not empty")
	@NotBlank(message = "E-mails is not empty")
	private String email;
	
	@NotNull(message = "Password is not empty")
	@NotBlank(message = "Password is not empty")
	private String senha;
	
}
