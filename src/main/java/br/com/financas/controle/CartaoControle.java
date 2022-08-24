package br.com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.model.CartaoModel;
import br.com.financas.model.json.Cartao;
import br.com.financas.service.CartaoService;

@RestController
@RequestMapping("cartao")
public class CartaoControle {

	@Autowired
	private CartaoService cartaoService;
	
	@PostMapping("cadastrar")
	public ResponseEntity<?> cadastrarCartao(@RequestBody Cartao cartao){
		return new ResponseEntity<>(cartaoService.salvarCartao(cartao), HttpStatus.CREATED);
	}
	
	@PostMapping("buscar")
	public ResponseEntity<?> carregarCartoes(@RequestBody Cartao cartao, 
			@RequestParam(value = "ordem", defaultValue = "desc") String ordem, 
			@RequestParam(value = "page", defaultValue = "0") Integer page){
		Page<CartaoModel> cartoes =	cartaoService.buscarCartoes(cartao, ordem, page);
		return new ResponseEntity<>(cartoes, HttpStatus.OK);
	}
	
}
