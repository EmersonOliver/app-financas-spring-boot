package br.com.financas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Boolean usuarioExistente (String email) {
		return this.usuarioRepository.usuarioExistente(email.trim()).size() > 0;
	}
	
}
