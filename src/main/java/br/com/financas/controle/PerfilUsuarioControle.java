package br.com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.dto.UsuarioDTO;
import br.com.financas.model.UsuarioModel;
import br.com.financas.service.UsuarioService;

@RestController
@RequestMapping("perfil")
public class PerfilUsuarioControle {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("cadastrar")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuario) {
		UsuarioModel u = usuarioService.salvarUsuario(usuario);
		return new ResponseEntity<>(u!= null ? u : null, u!= null ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED);
	}
	

	public ResponseEntity<?> resgatarComprasEfetuadas(
			@RequestParam(value = "ordem", defaultValue = "desc") String ordem, 
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam("dataInicio") String dataInicio,
			@RequestParam("dataFinal") String dataFinal){
		
		
		
		return null;
	}
	
}
