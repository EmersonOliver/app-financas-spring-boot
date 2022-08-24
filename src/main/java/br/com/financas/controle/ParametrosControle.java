package br.com.financas.controle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financas.enums.BandeiraEnum;
import br.com.financas.enums.TipoCartaoEnum;
import br.com.financas.enums.TipoEntradaSaidaEnum;

@RestController
@RequestMapping("parametros")
public class ParametrosControle {

	
	
	@GetMapping("bandeiras")
	public List<String> bandeiras(){
		return Stream.of(BandeiraEnum.values()).map(String::valueOf)
				.collect(Collectors.toList());
	}
	
	@GetMapping("meios-pagamento")
	public List<String> meioPagamento(){
		return Stream.of(TipoCartaoEnum.values()).map(String::valueOf)
				.collect(Collectors.toList());
	}
	
	@GetMapping("tipo-entrada-saida")
	public List<String> tiposEntradaSaida(){
		return Stream.of(TipoEntradaSaidaEnum.values()).map(String::valueOf)
				.collect(Collectors.toList());
	}
	
	
	
}
