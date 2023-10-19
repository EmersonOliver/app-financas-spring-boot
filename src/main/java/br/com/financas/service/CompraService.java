package br.com.financas.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financas.factory.CompraFactory;
import br.com.financas.model.CartaoModel;
import br.com.financas.model.CompraEntity;
import br.com.financas.model.json.Compra;
import br.com.financas.repository.CompraRepository;
import br.com.financas.utils.DataUtils;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private CartaoService cartaoService;

	public List<CompraEntity> salvarCompra(Compra compra) {
		 List<CompraEntity> listCompras = new ArrayList<>();
		 CartaoModel cartao = cartaoService.carregarCartaoById(compra.getIdCartao()).orElse(null);
		List<Date> dataVencimento =	DataUtils.dataVencimentoFatura(compra.getQtdParcelas(),cartao.getDiaFechamento() , LocalDate.now());
			List<CompraEntity> compraEntity = CompraFactory.instance(compra, dataVencimento);
			compraEntity.forEach(x-> listCompras.add(compraRepository.save(x)));
		return listCompras;
	}

	public List<CompraEntity> carregarComprasCartao(Long idCartao) {
		Optional<CartaoModel> cartao = cartaoService.carregarCartaoById(idCartao);
		if (cartao.isPresent()) {
			CartaoModel cartaoModel = cartao.get();
			return cartaoModel.getCompras();
		}
		return new ArrayList<>();
	}
	
	public List<CompraEntity> carregarCompraByDataCompra(String dataInicio, String dataFim){
		Date dtInicio = DataUtils.converterStringToDate(dataInicio, DataUtils.yyyy_MM_dd);
		Date dtFim = DataUtils.converterStringToDate(dataFim, DataUtils.yyyy_MM_dd);
		return compraRepository.listarComprasByDataCompra(dtInicio, dtFim);
	}
	
	public List<CompraEntity> listarCompraByParametros(Map<String, Object> params){
		return null;
	}

}
