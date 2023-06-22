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

import lombok.Data;

@Data
@Entity
@Table(name = "tb_compra", schema = "app_financas")
@SequenceGenerator(name = "sq_id_compra", sequenceName = "seq_id_compra", initialValue = 1, allocationSize = 1, schema = "app_financas")
public class CompraEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sq_id_compra", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_compra")
	private Long idCompra;
	
	@Column(name = "id_cartao")
	private Long idCartao;
	
	@Column(name = "id_tp_compra")
	private Long idTpCompra;
	
	@Column(name = "item_compra")
	private String itemCompra;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_compra")
	private Date dataCompra;
	
	@Column(name = "qtd_parcelas")
	private Integer qtdParcelas;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "id_cartao", updatable = false, insertable = false, foreignKey = @ForeignKey(name="fk_id_cartao"))
	private CartaoModel cartao;
	
	@ManyToOne
	@JoinColumn(name = "id_tp_compra", updatable = false, insertable = false, foreignKey = @ForeignKey(name="fk_tp_compra"))
	private TipoCompraEntity tipoCompra;

}
