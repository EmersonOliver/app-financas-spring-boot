package br.com.financas.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="tb_fatura_paga", schema = "fin")
@SequenceGenerator(name = "sq_id_fatura_paga", sequenceName = "seq_id_fatura_paga", allocationSize = 1, initialValue = 1, schema = "fin")
public class FaturaPagaModel {

	@Id
	@GeneratedValue(generator = "sq_id_fatura_paga", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_fatura_paga", precision = 8, nullable = false, unique = true)
	private Long idFaturaPaga;
	
	@Column(name = "id_fatura")
	private Long idFatura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	@Column(name = "valor_pago")
	private BigDecimal valorPago;
	
	@Column(name = "ic_parcelament_fatura")
	private Boolean icParcelamentoFatura;
	
	@Column(name = "valor_parcelamento_fatura")
	private BigDecimal valorParcelamentoFatura;
	
	@Column(name = "valor_total_pago")
	private BigDecimal valorTotalPago;
	
	@Column(name = "qtd_parcelamento_fatura")
	private Integer qtdParcelamentoFatura;
	
	@ManyToOne
	@JoinColumn(name = "id_fatura", updatable = false, insertable = false, foreignKey = @ForeignKey(name="fk_id_fatura"))
	private FaturaModel fatura;
	
}
