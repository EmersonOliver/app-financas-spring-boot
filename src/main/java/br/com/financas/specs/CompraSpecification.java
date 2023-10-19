package br.com.financas.specs;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import br.com.financas.model.CompraEntity;
import br.com.financas.utils.DataUtils;

public class CompraSpecification {

	
	public static Specification<CompraEntity> setIdCartao(Long idCartao){
		return (root, query, builder) -> builder.and(builder.equal(root.get("idCartao"), idCartao));
	} 
	
	public static Specification<CompraEntity> setIdTpCompra(Long idTpCompra){
		return (root, query, builder) -> builder.and(builder.equal(root.get("idTpCompra"), idTpCompra));
	}
	
	public static Specification<CompraEntity> setItemCompra(String itemCompra){
		return (root, query, builder) -> builder.and(builder.like(root.get("itemCompra"), "%"+itemCompra+"%"));
	}
	
	public static Specification<CompraEntity> setDataCompraPeriodo(Date dtInicio, Date dtFim){
		return (root, query, builder) -> builder.and(builder.between(root.get("dataCompra"), 
				DataUtils.dataInicialDia(dtInicio), DataUtils.dataFinalDia(dtFim)));
	}
	
	public static Specification<CompraEntity> setValorMaiorOrIgualTotal(BigDecimal valor){
		return (root, query, builder) -> builder.and(builder.greaterThanOrEqualTo(root.get("valor"), valor));
	}
	
	public static Specification<CompraEntity> setValorMenorOrIgualTotal(BigDecimal valor){
		return (root, query, builder) -> builder.and(builder.lessThanOrEqualTo(root.get("valor"), valor));
	}
	
	
}
