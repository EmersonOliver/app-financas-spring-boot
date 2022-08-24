package br.com.financas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_cartao", schema = "financas")
@SequenceGenerator(name = "sq_id_cartao", sequenceName = "seq_id_cartao", allocationSize = 1, initialValue = 1, schema = "financas")
public class CartaoModel implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cartao")
	@GeneratedValue(generator = "sq_id_cartao", strategy = GenerationType.SEQUENCE)
	private Long idCartao;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "nome_cartao")
	private String nomeCartao;
	
	@Column(name = "numero_cartao")
	private Integer numeroCartao;
	
	@Column(name = "bandeira_cartao")
	private String bandeiraCartao;
	
	@Column(name = "tipo_cartao")
	private String tipoCartao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento")
	private Date dataVencimento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fechamento")
	private Date dataFechamento;
	
	@JsonIgnoreProperties(value = {"cartao"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private UsuarioModel usuario;
	
	@JsonIgnoreProperties(value = {"cartao"})
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id_cartao", name = "id_cartao", updatable = false, insertable = false)
	private List<ComprasModel> compras;

}
