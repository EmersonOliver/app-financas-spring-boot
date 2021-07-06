package br.com.financas.controle;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.bean.UsuarioBean;
import br.com.financas.dto.UsuarioDTO;
import br.com.financas.model.UsuarioModel;
import br.com.financas.service.FinancaService;
import br.com.financas.util.EncriptySHA;

@RestController
@RequestMapping("usuario")
public class UsuarioControleApi {

	
	@Autowired
	private FinancaService service;
	
	@PostMapping(value = "cadastrar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioBean usuario){
		try {
			UsuarioModel usuarioModel = montarUsuario(usuario);
			UsuarioDTO usuarioDTO = this.service.cadastrarUsuario(usuarioModel);
			return ResponseEntity.ok(usuarioDTO);
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping(value="login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginUsuario(@RequestBody UsuarioBean usuarioBean){
		try {
			return ResponseEntity.ok(this.service.loginUsuario(usuarioBean));
		} catch (Exception e) {
			return null;
		}
	}
	
	private UsuarioModel montarUsuario(UsuarioBean usuario) throws NoSuchAlgorithmException {
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setEmailUsuario(usuario.getEmail());
		usuarioModel.setNomeUsuario(usuario.getNome());
		usuarioModel.setSenhaUsuario(EncriptySHA.encrypt(usuario.getSenha()));
		return usuarioModel;
	}
}
