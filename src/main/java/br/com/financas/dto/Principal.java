package br.com.financas.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.financas.utils.DataUtils;

public class Principal {

	public static void main(String[] args) {
		List<String> dataFechamento = DataUtils.dataVencimentoFatura(12, 21, LocalDate.now()).stream()
				.map(x -> new SimpleDateFormat("dd/MM/yyyy").format(x)).collect(Collectors.toList());
		System.out.println(dataFechamento);
	}

}
