package br.com.financas.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("faturas")
public class FaturaControle {

	
	public ResponseEntity<?> carregarFaturas(){
		return null;
	}
	
}
