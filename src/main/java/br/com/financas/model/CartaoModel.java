package br.com.financas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_cartao", schema = "app_financas")
@SequenceGenerator(name = "sq_id_cartao", sequenceName = "seq_id_cartao", allocationSize = 1, initialValue = 1, schema = "app_financas")
public class CartaoModel implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cartao")
	@GeneratedValue(generator = "sq_id_cartao", strategy = GenerationType.SEQUENCE)
	private Long idCartao;
	
	@Column(name = "no_cartao")
	private String nomeCartao;
	
	@Column(name = "nu_cartao")
	private String numeroCartao;
	
	@Column(name = "dia_vencimento")
	private Integer diaVencimento;
	
	@Column(name = "dia_fechamento")
	private Integer diaFechamento;
	
	@Column(name = "limite_cartao")
	private BigDecimal limiteCartao;
	
	@Column(name = "limite_utilizado")
	private BigDecimal limiteUtilizado;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cartao", fetch = FetchType.EAGER)
	private List<FaturaCartaoEntity> faturas;
	

}
