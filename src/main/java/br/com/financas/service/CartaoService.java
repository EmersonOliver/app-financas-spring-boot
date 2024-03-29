package br.com.financas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.financas.controle.exception.handler.ApiException;
import br.com.financas.model.CartaoModel;
import br.com.financas.model.json.Cartao;
import br.com.financas.repository.CartaoRepository;
import br.com.financas.specs.CartaoSpecification;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;

	public CartaoModel salvarCartao(Cartao cartao) {

		Optional<CartaoModel> cartaoModel = cartaoRepository.findByNumeroCartaoContaining(cartao.numeroCartao);

		if (cartaoModel.isPresent()) {
			throw new ApiException("Registro já cadastrado");
		}
		cartaoModel = Optional.of(new CartaoModel());
		cartaoModel.get().setNumeroCartao(cartao.numeroCartao);
		cartaoModel.get().setDiaFechamento(cartao.diaFechamento);
		cartaoModel.get().setDiaVencimento(cartao.diaVencimento);
		cartaoModel.get().setLimiteCartao(cartao.limiteCartao);
		cartaoModel.get().setLimiteUtilizado(cartao.limiteUtilizado);
		cartaoModel.get().setNomeCartao(cartao.nomeCartao);
		return cartaoRepository.save(cartaoModel.get());
	}

	public Page<CartaoModel> buscarCartoes(Cartao cartao, String ordem, Integer page) {
		Direction direction = ordem.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
		Pageable pagination = PageRequest.of(page, 10, Sort.by(direction, "idCartao"));

		List<Specification<CartaoModel>> listSpecs = new ArrayList<>();
		Specification<CartaoModel> specs = null;

		if (cartao.nomeCartao != null) {
			listSpecs.add(CartaoSpecification.nomeCartao(cartao.nomeCartao));
		}
		if (cartao.numeroCartao != null) {
			listSpecs.add(CartaoSpecification.numeroCartao(cartao.numeroCartao));
		}
		specs = !listSpecs.isEmpty() ? Specification.where(listSpecs.get(0)) : null;

		for (int i = 1; i < listSpecs.size(); i++) {
			specs = specs.and(listSpecs.get(i));
		}
		return cartaoRepository.findAll(specs, pagination);
	}

	
	public Optional<CartaoModel> carregarCartaoById(Long idCartao){
		return cartaoRepository.findById(idCartao);
	}
}
