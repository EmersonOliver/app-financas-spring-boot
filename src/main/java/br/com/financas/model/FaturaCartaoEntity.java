package br.com.financas.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;


@Data
@Entity
@Table(name = "tb_fatura_cartao", schema = "app_financas")
@SequenceGenerator(name = "sq_id_fatura", sequenceName = "seq_id_fatura", allocationSize = 1, initialValue = 1, schema = "app_financas")
public class FaturaCartaoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_fatura")
	@GeneratedValue(generator = "sq_id_fatura", strategy = GenerationType.SEQUENCE)
	private Long idFatura;
	
	@Column(name = "id_cartao")
	private Long idCartao;
	
	@Column(name = "situacao_fatura")
	private String situacaoFatura;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vencimento")
	private Date dtVencimento;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fechamento")
	private Date dtFechamento;
	
	@Column(name = "valor_fatura")
	private BigDecimal valorFatura;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_cartao", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_id_cartao"))
	private CartaoModel cartao;
	
}
