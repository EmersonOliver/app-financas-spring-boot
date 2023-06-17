package br.com.financas.specs;

import org.springframework.data.jpa.domain.Specification;

import br.com.financas.model.CartaoModel;

public class CartaoSpecification {

	public static Specification<CartaoModel> nomeCartao(String nomeCartao){
		return (root, query, builder) -> builder.and(builder.like(root.get("nomeCartao"), nomeCartao.concat("%")));
	}
	
	public static Specification<CartaoModel> numeroCartao(String numeroCartao){
		return (root, query, builder) -> builder.and(builder.equal(root.get("numeroCartao"), numeroCartao));
	}
	
}
