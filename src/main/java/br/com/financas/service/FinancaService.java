package br.com.financas.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.financas.bean.UsuarioBean;
import br.com.financas.dto.UsuarioDTO;
import br.com.financas.model.ComprasModel;
import br.com.financas.model.UsuarioModel;
import br.com.financas.repository.CategoriaRepository;
import br.com.financas.repository.ComprasRepository;
import br.com.financas.repository.FaturaRepository;
import br.com.financas.repository.UsuarioRepository;
import br.com.financas.util.EncriptySHA;

@Service
public class FinancaService {

	@Autowired
	private ComprasRepository comprasRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private FaturaRepository faturaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	public List<ComprasModel> listarTodos() {
		return this.comprasRepository.listarTodasCompras();
	}
	
	public UsuarioDTO cadastrarUsuario(UsuarioModel usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		this.usuarioRepository.salvarUsuario(usuario);
		usuarioDTO.setNomeUsuario(usuario.getNomeUsuario());
		usuarioDTO.setTokenUsuario("");
		return usuarioDTO;
	}

	public UsuarioModel loginUsuario(UsuarioBean usuarioBean) throws NoSuchAlgorithmException {
		return this.usuarioRepository.loginUsuario(usuarioBean.getEmail(), EncriptySHA.encrypt(usuarioBean.getSenha()));
	}
	
}
