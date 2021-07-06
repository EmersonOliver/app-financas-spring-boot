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
@Table(name = "tb_compra", schema = "fin")
@SequenceGenerator(name = "sq_id_compra", sequenceName = "seq_id_compra", schema="fin", initialValue = 1, allocationSize = 1)
public class ComprasModel {
	
	@Id
	@GeneratedValue(generator = "sq_id_compra", strategy = GenerationType.SEQUENCE)
	@Column(name="id_compra", precision = 8, unique = true, nullable = false)
	private Long idCompra;
	
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	@Column(name = "cod_mes_referencia")
	private Integer codMesReferencia;
	
	@Column(name = "mes_referencia")
	private String mesReferencia;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "parcela_atual")
	private Integer parcelaAtual;
	
	@Column(name = "qtd_parcelas")
	private Integer qtdParcelas;
	
	@Column(name = "valor_parcela")
	private BigDecimal valorParcela;
	
	@Column(name = "valor_total_parcela")
	private BigDecimal valorTotalParcela;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_compra")
	private Date dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, nullable = false, updatable = false, foreignKey = @ForeignKey(name="fk_id_categoria"))
	private CategoriaModel categoria;

	public ComprasModel(Long idCompra, Long idCategoria, Integer codMesReferencia, String mesReferencia,
			String descricao, Integer parcelaAtual, Integer qtdParcelas, BigDecimal valorParcela,
			BigDecimal valorTotalParcela, Date dataCompra, CategoriaModel categoria) {
		super();
		this.idCompra = idCompra;
		this.idCategoria = idCategoria;
		this.codMesReferencia = codMesReferencia;
		this.mesReferencia = mesReferencia;
		this.descricao = descricao;
		this.parcelaAtual = parcelaAtual;
		this.qtdParcelas = qtdParcelas;
		this.valorParcela = valorParcela;
		this.valorTotalParcela = valorTotalParcela;
		this.dataCompra = dataCompra;
		this.categoria = categoria;
	}
	
	

}
