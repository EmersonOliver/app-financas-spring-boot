package br.com.financas.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.financas.model.CartaoModel;
import br.com.financas.model.ComprasModel;
import br.com.financas.model.json.Compra;
import br.com.financas.repository.CartaoRepository;
import br.com.financas.repository.CompraRepository;
import br.com.financas.utils.DataUtils;

@Service
public class MovimentacoesService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private CartaoRepository cartaoRepository;

	public void efetuarCompra(Compra compra) {
		CartaoModel cartao = cartaoRepository.findById(compra.getCartao().getIdCartao()).get();
		compraRepository.saveAll(processarCompras(cartao,
				DataUtils.converterStringToDate(compra.getDataPagamento(), DataUtils.yyyy_MM_dd), compra));
	}

	private List<ComprasModel> processarCompras(CartaoModel cartao, Date dataCompra, Compra compra) {
		Calendar cal = Calendar.getInstance();
		List<ComprasModel> compras = new ArrayList<>();

		if (dataCompra.after(cartao.getDataVencimento())
				&& dataCompra.getTime() > cartao.getDataVencimento().getTime()) {
			cal.add(Calendar.MONTH, 1);
		}

		for (int i = 1; i < compra.getQtdParcelas(); i++) {
			ComprasModel mCompra = new ComprasModel();
			mCompra.setCompra(compra.getCompra());
			mCompra.setDataPagamento(cal.getTime());
			mCompra.setDataCompra(DataUtils.converterStringToDate(compra.getDataPagamento(), DataUtils.yyyy_MM_dd));
			mCompra.setMetodoPagamento(compra.getMetodoPagamento());
			mCompra.setQtdParcelas(compra.getQtdParcelas());
			mCompra.setValorParcela(compra.getValorParcela());
			mCompra.setValorTotal(compra.getValorTotal());
			mCompra.setIdCartao(cartao.getIdCartao());
			compras.add(mCompra);
			cal.add(Calendar.MONTH, 1);
		}
		return compras;
	}
	
	/*
	 * public static void main(String[] args) throws ParseException { int qtdParcela
	 * = 2;
	 * 
	 * Calendar cal = Calendar.getInstance(); Date vencimentoFatura = new
	 * SimpleDateFormat("dd-MM-yyyy").parse("21-08-2022"); Date dataCompra = new
	 * Date();
	 * 
	 * if(dataCompra.after(vencimentoFatura) && dataCompra.getTime() >
	 * vencimentoFatura.getTime()) { cal.add(Calendar.MONTH, 1); }
	 * 
	 * for(int i = 1; i <= qtdParcela; i++ ) { Date data = cal.getTime();
	 * System.out.println("Parcela: " + i + " vencimento compra: " +
	 * DataUtils.converterDataToString(data, DataUtils.dd_MM_yyyy));
	 * cal.add(Calendar.MONTH, 1); } }
	 */

}
