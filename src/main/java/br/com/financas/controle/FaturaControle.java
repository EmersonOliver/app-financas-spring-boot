package br.com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.model.json.FaturaCartao;
import br.com.financas.service.FaturaService;

@RestController
@RequestMapping("faturas")
public class FaturaControle {
	
	@Autowired
	private FaturaService faturaService;

	@PostMapping("cadastrar")
	public ResponseEntity<?> cadastrarFatura(@RequestBody FaturaCartao request){
		return new ResponseEntity<>(faturaService.cadastrarFatura(request), HttpStatus.CREATED);
	}
	
	@PostMapping("buscar")
	public ResponseEntity<?> buscarFaturas(@RequestBody FaturaCartao request,
			@RequestParam(value = "ordem", defaultValue = "desc") String ordem,
			@RequestParam(value = "page", defaultValue = "0") Integer page) {
		return new ResponseEntity<>(faturaService.buscarFatura(ordem, page, request), HttpStatus.OK);
	}
	
	@GetMapping("listar")
	public ResponseEntity<?> carregarFaturas(@RequestParam(value = "ordem", defaultValue = "desc") String ordem,
			@RequestParam(value = "page", defaultValue = "0") Integer page){
		return new ResponseEntity<>(faturaService.buscarFatura(ordem, page, null), HttpStatus.OK);
	}

}
