package br.com.financas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
//		Calendar cal = Calendar.getInstance();
		List<ComprasModel> compras = new ArrayList<>();
//
//		if (dataCompra.after(DataUtils.dataCartao(cartao.getDataVencimento().toString()))
//				&& dataCompra.getTime() > cartao.getDataVencimento().getTime()) {
//			cal.add(Calendar.MONTH, 1);
//		}
//
//		for (int i = 1; i < compra.getQtdParcelas(); i++) {
//			ComprasModel mCompra = new ComprasModel();
//			mCompra.setCompra(compra.getCompra());
//			mCompra.setDataPagamento(cal.getTime());
//			mCompra.setDataCompra(DataUtils.converterStringToDate(compra.getDataPagamento(), DataUtils.yyyy_MM_dd));
//			mCompra.setMetodoPagamento(compra.getMetodoPagamento());
//			mCompra.setQtdParcelas(compra.getQtdParcelas());
//			mCompra.setValorParcela(compra.getValorParcela());
//			mCompra.setValorTotal(compra.getValorTotal());
//			mCompra.setIdCartao(cartao.getIdCartao());
//			compras.add(mCompra);
//			cal.add(Calendar.MONTH, 1);
//		}
		return compras;
	}
	
	
	public static void main(String[] args) throws ParseException {
		int qtdParcelas = 12;
		int diaFechamento = 6;
		int diaFatura = 22;
		
		LocalDate dataCompra = LocalDate.now();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, diaFechamento);
		
		Date dataFechamento = cal.getTime();
		
	
		
		LocalDate dtFechamento = dataFechamento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		if(!dtFechamento.isEqual(dataCompra)) {
			cal.set(Calendar.DAY_OF_MONTH, diaFatura);
			cal.set(Calendar.MONTH, dataCompra.getMonth().getValue()-1);
			Date dataFatura = cal.getTime();
			System.out.println("Data da proxima fatura=> " + new SimpleDateFormat("dd-MM-yyyy").format(dataFatura));
		}else {
			cal.set(Calendar.DAY_OF_MONTH, diaFatura);
			cal.set(Calendar.MONTH, dataCompra.getMonth().getValue());
			Date dataFatura = cal.getTime();
			System.out.println("Data da proxima fatura=> " + new SimpleDateFormat("dd-MM-yyyy").format(dataFatura));
		}
		System.out.println("Data compra=> " + new SimpleDateFormat("dd-MM-yyyy").format(Date.from(dataCompra.atStartOfDay(ZoneId.systemDefault()).toInstant())));
		System.out.println("Parcelas Futura: ");
		
		cal.setTime(Date.from(dataCompra.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		int mesCompra = dataCompra.getMonthValue();
		for(int i = 0; i < qtdParcelas; i++) {
			cal.set(Calendar.MONTH, (mesCompra+i == 12) ? 0 : mesCompra +i);
			System.out.println("Nº parcela: "+ (i+1) +" Data: " + new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime()));
		}
		
		
		
		
		
		
	}
	 

}
