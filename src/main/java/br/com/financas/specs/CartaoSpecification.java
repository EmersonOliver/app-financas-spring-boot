package br.com.financas.specs;

import org.springframework.data.jpa.domain.Specification;

import br.com.financas.model.CartaoModel;

public class CartaoSpecification {

	public static Specification<CartaoModel> nomeCartao(String nomeCartao){
		return (root, query, builder) -> builder.and(builder.like(root.get("nomeCartao"), nomeCartao.concat("%")));
	}
	
	public static Specification<CartaoModel> numeroCartao(Integer numeroCartao){
		return (root, query, builder) -> builder.and(builder.equal(root.get("numeroCartao"), numeroCartao));
	}
	
	public static Specification<CartaoModel> usuarioCartao(String nomeUsuario){
		return (root, query, builder) -> builder.and(builder.like(root.get("usuario").get("nomeUsuario"), nomeUsuario+"%"));
	}
	
	public static Specification<CartaoModel> bandeiraCartao(String bandeiraCartao){
		return(root,query, builder) -> builder.and(builder.like(root.get("bandeiraCartao"), bandeiraCartao+"%"));
	}
	
	public static Specification<CartaoModel> tipoCartao(String tipoCartao){
		return(root,query, builder) -> builder.and(builder.like(root.get("tipoCartao"), tipoCartao+"%"));
	}
}
