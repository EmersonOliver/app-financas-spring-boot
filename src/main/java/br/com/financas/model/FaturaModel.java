package br.com.financas.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tb_fatura", schema = "fin")
@SequenceGenerator(name = "sq_id_fatura", sequenceName = "seq_id_fatura", initialValue = 1, allocationSize = 1, schema = "fin")
public class FaturaModel {
	
	@Id
	@GeneratedValue(generator = "sq_id_fatura", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_fatura")
	private Long idFatura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fatura_criada")
	private Date dataFaturaCriada;
	
	@Column(name = "dados_fatura_csv")
	private String dadosFaturaCSV;
	
	@Column(name = "valor_total_fatura")
	private BigDecimal valorTotalFatura;
	
}
