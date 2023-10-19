package br.com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.model.CompraEntity;
import br.com.financas.model.json.Compra;
import br.com.financas.service.CompraService;

@RestController
@RequestMapping("compras")
public class CompraControle {

	
	@Autowired
	private CompraService compraService;
	
	@PostMapping(path = "cadastrar", consumes = "application/json;UTF-8", produces = "application/json;UTF-8")
	public ResponseEntity<?> cadastrarCompra(@RequestBody Compra compra){
		CompraEntity compraEntity = this.compraService.salvarCompra(compra);
		return new ResponseEntity<>(compraEntity, HttpStatus.CREATED);
	}
	
	
}

