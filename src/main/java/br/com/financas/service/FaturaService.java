package br.com.financas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financas.controle.exception.handler.ApiException;
import br.com.financas.model.CartaoModel;
import br.com.financas.model.FaturaCartaoEntity;
import br.com.financas.model.json.FaturaCartao;
import br.com.financas.repository.CartaoRepository;
import br.com.financas.repository.FaturaRepository;

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
	
}
