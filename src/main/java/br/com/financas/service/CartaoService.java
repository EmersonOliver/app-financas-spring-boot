package br.com.financas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.financas.model.CartaoModel;
import br.com.financas.model.UsuarioModel;
import br.com.financas.model.json.Cartao;
import br.com.financas.repository.CartaoRepository;
import br.com.financas.repository.UsuarioRepository;
import br.com.financas.specs.CartaoSpecification;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public CartaoModel salvarCartao(Cartao cartao) {
		CartaoModel card = new CartaoModel();
		UsuarioModel usuario = usuarioRepository.findByUsuarioNome(cartao.usuario).orElseThrow(()-> null);
		try {
			card.setDataFechamento(dataCartao(cartao.dataFechamento));
			card.setBandeiraCartao(cartao.bandeiraCartao);
			card.setDataVencimento(dataCartao(cartao.dataVencimento));
			card.setNomeCartao(cartao.nomeCartao);
			card.setNumeroCartao(cartao.numeroCartao);
			card.setIdUsuario(usuario.getIdUsuario());
			return cartaoRepository.save(card);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Page<CartaoModel> buscarCartoes(Cartao cartao, String ordem, Integer page){
		Direction direction = ordem.equalsIgnoreCase("desc") ? Sort.Direction.DESC :Sort.Direction.ASC ;
		Pageable pagination = PageRequest.of(page, 10, Sort.by(direction, "idCartao"));
		
		List<Specification<CartaoModel>> listSpecs= new ArrayList<>();
		Specification<CartaoModel> specs = null;
		
		if(cartao.bandeiraCartao != null){
			listSpecs.add(CartaoSpecification.bandeiraCartao(cartao.bandeiraCartao));
		}
		if(cartao.nomeCartao != null) {
			listSpecs.add(CartaoSpecification.nomeCartao(cartao.nomeCartao));
		}
		if(cartao.numeroCartao != null) {
			listSpecs.add(CartaoSpecification.numeroCartao(cartao.numeroCartao));
		}
		if(cartao.tipoCartao != null) {
			listSpecs.add(CartaoSpecification.tipoCartao(cartao.tipoCartao));
		}
		specs = !listSpecs.isEmpty() ? Specification.where(listSpecs.get(0)):null;
		
		for(int i = 1; i < listSpecs.size(); i++) {
			specs = specs.and(listSpecs.get(i));
		}
		return cartaoRepository.findAll(specs,pagination);
	}
	
	

	private Date dataCartao(String data) throws ParseException {
		return new SimpleDateFormat("dd-MM-yyyy").parse(data);
	}

}
