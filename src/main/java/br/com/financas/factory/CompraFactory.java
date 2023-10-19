package br.com.financas.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.financas.model.CompraEntity;
import br.com.financas.model.json.Compra;
import br.com.financas.utils.DataUtils;

public class CompraFactory {

	
	public static List<CompraEntity> instance(Compra compra, List<Date> dataParcela) {
		List<CompraEntity> listReturn = new ArrayList<>();
		int parcelaAtual = 1;
		for(Date dtParcela : dataParcela ) {
			CompraEntity compraEntity = CompraEntity.builder()
					.idCartao(compra.getIdCartao())
					.dataCompra(DataUtils.converterStringToDate(compra.getDataCompra(), DataUtils.yyyy_MM_dd))
					.idTpCompra(compra.getTpCompra())
					.itemCompra(compra.getCompra())
					.valor(compra.getValorTotal())
					.qtdParcelas(parcelaAtual++)
//					.tipoCompra(compra.getTipoCompra())
					.build();
			listReturn.add(compraEntity);
		}
		return listReturn;
	}
	
}
