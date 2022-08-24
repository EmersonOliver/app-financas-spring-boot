package br.com.financas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_compras", schema = "financas")
@SequenceGenerator(name = "sq_id_compra", sequenceName = "seq_id_compra", schema = "financas", allocationSize = 1, initialValue = 1)
public class ComprasModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_compra")
	@GeneratedValue(generator = "sq_id_compra", strategy = GenerationType.SEQUENCE)
	private Long idCompra;
	
	@Column(name = "id_cartao")
	private Long idCartao;
	
	@Column(name = "compra")
	private String compra;

	@Column(name = "metodo_pagamento")
	private String metodoPagamento;
	
	@Column(name = "qtd_parcelas")
	private Integer qtdParcelas;
	
	@Column(name = "valor_parcela")
	private BigDecimal valorParcela;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_compra")
	private Date dataCompra;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	@JsonIgnoreProperties(value = {"usuario"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cartao", referencedColumnName = "id_cartao", insertable = false, updatable = false)
	private CartaoModel cartao;
	
	
}
