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

import lombok.Data;

@Data
@Entity
@Table(name = "tb_simulador", schema = "financas")
@SequenceGenerator(name = "sq_id_simulador", sequenceName = "seq_id_simulador", allocationSize = 1, initialValue = 1, schema = "financas")
public class SimuladorModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_simulacao")
	@GeneratedValue(generator = "sq_id_simulador", strategy = GenerationType.SEQUENCE)
	private Long idSimulacao;

	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "id_cartao")
	private Long idCartao;
	
	@Column(name = "nome_simulacao")
	private String nomeSimulacao;
	
	@Column(name = "qtd_parcelas")
	private Integer qtdParcelas;
	
	@Column(name = "qtd_parcelas_restantes")
	private Integer qtdParcelasRestantes;
	
	@Column(name = "total_compra")
	private BigDecimal totalCompra;
	
	@Column(name = "total_rest_quitacao")
	private BigDecimal totalRestanteQuitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_simulacao")
	private Date dataHoraSimulacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_futura_pagamento")
	private Date dataFuturaPagamento;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private UsuarioModel usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cartao",referencedColumnName = "id_cartao", insertable = false, updatable = false )
	private CartaoModel cartao;
	
	
	

}
