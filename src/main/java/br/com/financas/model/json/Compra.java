package br.com.financas.model.json;

import static br.com.financas.specs.CompraSpecification.setDataCompraPeriodo;
import static br.com.financas.specs.CompraSpecification.setItemCompra;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.financas.model.CompraEntity;
import lombok.Data;

@Data
public class Compra implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String metodoPagamento;
	private String compra;
	private Integer qtdParcelas;
	private BigDecimal valorParcela;
	private BigDecimal valorTotal;
	private BigDecimal valorPrimeiraParcela;
	private String dataPagamento;
	private String dataCompra;
	private List<Date> periodoCompra;
	private Long idCartao;
	private Long tpCompra;
//	private CartaoModel cartao;
//	private TipoCompraEntity tipoCompra;
	
	public Compra () {
		super();
	}
	public Specification<CompraEntity> toSpecification(){
		List<Specification<CompraEntity>> listSpecs = new ArrayList<>();

		if(!"".equalsIgnoreCase(compra) && compra != null) {
			listSpecs.add(setItemCompra(compra));
		}
		
		if(periodoCompra != null && !periodoCompra.isEmpty()) {
			listSpecs.add(setDataCompraPeriodo(this.periodoCompra.get(0), this.periodoCompra.get(1)));
		}
		
		Specification<CompraEntity> specs = null;
		if(!listSpecs.isEmpty()) {
			specs = Specification.where(listSpecs.get(0));
		}
		
		for(int i = 0; i < listSpecs.size(); i++) {
			specs = specs.and(listSpecs.get(i));
		}
		return specs;
	}
}
