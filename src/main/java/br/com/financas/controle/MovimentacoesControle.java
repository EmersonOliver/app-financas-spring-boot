package br.com.financas.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacoesControle {

	
	public ResponseEntity<?> criarCompra(){
		return null;
	}
	
	public ResponseEntity<?> registrarMovimentacaoConta(){
		return null;
	}
	
	public ResponseEntity<?> registrarPagamento(){
		return null;
	}
	
	public ResponseEntity<?> registrarSimulacaoCompra(){
		return null;
	}
	
	public ResponseEntity<?> registrarSimulacaoQuitacao(){
		return null;
	}
	
	
}
