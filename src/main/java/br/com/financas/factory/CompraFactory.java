package br.com.financas.factory;

import br.com.financas.model.CompraEntity;
import br.com.financas.model.json.Compra;
import br.com.financas.utils.DataUtils;

public class CompraFactory {

	
	public static CompraEntity instance(Compra compra) {
			CompraEntity compraEntity = CompraEntity.builder()
					.idCartao(compra.getIdCartao())
					.dataCompra(DataUtils.converterStringToDate(compra.getDataCompra(), DataUtils.yyyy_MM_dd))
					.idTpCompra(compra.getTpCompra())
					.itemCompra(compra.getCompra())
					.valor(compra.getValorTotal())
//					.tipoCompra(compra.getTipoCompra())
					.build();
		return compraEntity;
	}
	
}
