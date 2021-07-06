package br.com.financas.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioBean {

	private String nome;
	private String email;
	private String senha;
}
