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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_parcela", schema = "app_financas")
@SequenceGenerator(name = "sq_id_parcela", schema = "app_financas", sequenceName = "seq_id_parcela", initialValue = 1, allocationSize = 1)
public class ParcelaModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sq_id_parcela", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_parcela")
	private Long idParcela;
	
	@Column(name = "id_compra")
	private Long idCompra;

	@Column(name = "valor_parcela")
	private BigDecimal valorParcela;
	
	@Column(name = "num_parcela")
	private Integer numeroParcela;
	
	@Column(name = "parcela_paga")
	private Boolean parcelaPaga;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vencimento_parcela")
	private Date vencimentoParcela;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_compra", referencedColumnName = "id_compra", updatable = false, insertable = false, foreignKey = @ForeignKey(name="fk_id_compra_parcela"))
	private CompraEntity compra;
	
}
