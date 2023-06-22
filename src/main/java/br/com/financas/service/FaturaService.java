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
import br.com.financas.model.FaturaCartaoEntity;
import br.com.financas.model.json.FaturaCartao;
import br.com.financas.repository.CartaoRepository;
import br.com.financas.repository.FaturaRepository;
import br.com.financas.specs.FaturaSpecification;

@Service
public class FaturaService {


	@Autowired
	FaturaRepository faturaRepository;

	@Autowired
	CartaoRepository cartaoRepository;
	
	
	public FaturaCartaoEntity cadastrarFatura(FaturaCartao request) {
		Optional<FaturaCartaoEntity> fatura = this.faturaRepository.findByFaturaMesAtual(request.dataFechamento);
		if(fatura.isPresent()) {
			throw new ApiException("Fatura já localizada!");
		}
		fatura = Optional.of(new FaturaCartaoEntity());
		Optional<CartaoModel> cartao = this.cartaoRepository.findById(request.idCartao);
		fatura.get().setCartao(cartao.get());
		fatura.get().setDtFechamento(request.dataFechamento);
		fatura.get().setDtVencimento(request.dataVencimento);
		fatura.get().setIdCartao(cartao.get().getIdCartao());
		fatura.get().setSituacaoFatura(request.situacaoFatura);
		fatura.get().setValorFatura(request.valorFatura);
		return faturaRepository.save(fatura.get());
	}
	
	public Page<FaturaCartaoEntity> buscarFatura(String ordem, int page, FaturaCartao fatura){
		Direction direction = ordem.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
		Pageable pagination = PageRequest.of(page, 10, Sort.by(direction, "idFatura"));
		
		List<Specification<FaturaCartaoEntity>> listSpecs = new ArrayList<>();
		Specification<FaturaCartaoEntity> specs = null;
		
		if (fatura != null && fatura.cartao.nomeCartao != null) {
			listSpecs.add(FaturaSpecification.nomeCartao(fatura.cartao.nomeCartao));
		}
		if (fatura != null && fatura.cartao.numeroCartao != null) {
			listSpecs.add(FaturaSpecification.numeroCartao(fatura.cartao.numeroCartao));
		}
		if(fatura != null && fatura.dataVencimento != null) {
			listSpecs.add(FaturaSpecification.dtVencimento(fatura.dataVencimento));
		}
		if(fatura != null && fatura.dataFechamento != null) {
			listSpecs.add(FaturaSpecification.dtFechamento(fatura.dataFechamento));
		}
		specs = !listSpecs.isEmpty() ? Specification.where(listSpecs.get(0)) : null;
		for (int i = 1; i < listSpecs.size(); i++) {
			specs = specs.and(listSpecs.get(i));
		}
		return faturaRepository.findAll(specs, pagination);
	}
	
}
