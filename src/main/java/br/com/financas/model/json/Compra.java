package br.com.financas.model.json;

import java.math.BigDecimal;

import br.com.financas.model.CartaoModel;
import lombok.Data;

@Data
public class Compra {
	
	private String metodoPagamento;
	private String compra;
	private Integer qtdParcelas;
	private BigDecimal valorParcela;
	private BigDecimal valorTotal;
	private String dataPagamento;
	private CartaoModel cartao;
}
