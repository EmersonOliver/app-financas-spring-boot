package br.com.financas.model.json;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import static br.com.financas.specs.CartaoSpecification.*;

import br.com.financas.model.CartaoModel;

public class Cartao {

	public String nomeCartao;
	public String numeroCartao;
	public Integer diaVencimento;
	public Integer diaFechamento;
	public BigDecimal limiteCartao;
	public BigDecimal limiteUtilizado;

	
	public Specification<CartaoModel> toSpecification(){
		
		List<Specification<CartaoModel>> listSpec = new ArrayList<>();
		
		if(!this.nomeCartao.isBlank() && !this.nomeCartao.isEmpty()) {
			listSpec.add(nomeCartao(this.nomeCartao));
		}
		
		if(!this.numeroCartao.isBlank() && !this.numeroCartao.isEmpty()) {
			listSpec.add(numeroCartao(this.numeroCartao));
		}
		
		Specification<CartaoModel> specs = null;
		if(!listSpec.isEmpty()) {
			specs = Specification.where(listSpec.get(0));
		}
		
		for(int i = 0; i < listSpec.size(); i++) {
			specs = specs.and(listSpec.get(i));
		}
		return specs;
		
	}
}
