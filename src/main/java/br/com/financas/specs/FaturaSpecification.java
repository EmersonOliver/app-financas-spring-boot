package br.com.financas.specs;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import br.com.financas.model.FaturaCartaoEntity;

public class FaturaSpecification {
	
	public static Specification<FaturaCartaoEntity> nomeCartao(String nomeCartao){
		return (root, query, builder) -> builder.and(builder.like(root.get("cartao").get("nomeCartao"), nomeCartao.concat("%")));
	}
	
	public static Specification<FaturaCartaoEntity> numeroCartao(String numeroCartao){
		return (root, query, builder) -> builder.and(builder.equal(root.get("cartao").get("numeroCartao"), numeroCartao));
	}
	
	public static Specification<FaturaCartaoEntity> situacaoFatura(String situacao){
		return (root, query, builder) -> builder.and(builder.like(root.get("situacaoFatura"), situacao.concat("%")));
	}
	
	public static Specification<FaturaCartaoEntity> dtVencimento(Date dt){
		return (root, query, builder) -> builder.and(builder.equal(root.get("dtVencimento"), dt));
	}
	
	public static Specification<FaturaCartaoEntity> dtFechamento(Date dt){
		return (root, query, builder) -> builder.and(builder.equal(root.get("dtFechamento"), dt));
	}
	
}
