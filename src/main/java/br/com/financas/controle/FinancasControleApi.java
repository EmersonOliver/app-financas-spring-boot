package br.com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.service.FinancaService;

@RestController
@RequestMapping("controle")
public class FinancasControleApi {

	@Autowired
	private FinancaService financaService;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscar(){
		return ResponseEntity.ok(financaService.listarTodos());
	}
	
}
