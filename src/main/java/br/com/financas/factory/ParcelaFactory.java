package br.com.financas.factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.financas.model.CompraEntity;
import br.com.financas.model.ParcelaModel;
import br.com.financas.utils.DataUtils;

public class ParcelaFactory {

	private ParcelaFactory() {}
	
	public static List<ParcelaModel> getInstance(CompraEntity compra){
		 List<ParcelaModel> listParcelas = new ArrayList<>();
		 List<Date> dataVencimento = DataUtils.dataVencimentoFatura(compra.getQtdParcelas(), compra.getCartao().getDiaFechamento() , LocalDate.now());
		 int numParcela = 1;
		 for(Date dtVencimento : dataVencimento) {
			 listParcelas.add(ParcelaModel.builder()
					 .idCompra(compra.getIdCompra())
					 .numeroParcela(numParcela++)
					 .parcelaPaga(false)
					 .build());
		 }
		return null;
	}

}
