package br.com.financas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financas.dto.UsuarioDTO;
import br.com.financas.model.UsuarioModel;
import br.com.financas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioModel salvarUsuario(UsuarioDTO usuario) {
		UsuarioModel user = new UsuarioModel();
		if(!usuarioRepository.findByUsuarioNome(usuario.getNome().toUpperCase()).isPresent()) {
			user.setEmail(usuario.getEmail());
			user.setNomeUsuario(usuario.getNome());
			return usuarioRepository.save(user);
		}
		return null;
	}
	
	public Optional<UsuarioModel> carregarUsuario(String nome){
		return usuarioRepository.findByUsuarioNome(nome.toUpperCase());
	}
	
}
