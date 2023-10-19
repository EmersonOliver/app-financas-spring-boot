package br.com.financas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financas.factory.ParcelaFactory;
import br.com.financas.model.CompraEntity;
import br.com.financas.model.ParcelaModel;
import br.com.financas.repository.ParcelaRepository;

@Service
public class ParcelaService {

	@Autowired
	private ParcelaRepository parcelaRepository;
	
	public void salvarParcelas(CompraEntity compra) {
		List<ParcelaModel> parcelas = ParcelaFactory.getInstance(compra);
		
		
	}
	
}
