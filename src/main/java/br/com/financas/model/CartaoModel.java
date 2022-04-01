package br.com.financas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.financas.enums.BandeiraEnum;
import br.com.financas.enums.TipoCartaoEnum;
import lombok.Data;


@Data
@Entity
@Table(name = "tb_cartao", schema = "financas")
public class CartaoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cartao")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCartao;
	
	@Column(name = "nome_cartao")
	private String nomeCartao;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "id_financeira")
	private Long idFinanceira;
	
	@Column(name = "numero_cartao")
	private String numeroCartao;
	
	@Column(name="bandeira")
	private BandeiraEnum bandeira;
	
	@Column(name = "tipo_cartao")
	private TipoCartaoEnum tipoCartao;
	
	@Column(name = "mes_validade")
	private Integer mesValidade;
	
	@Column(name = "ano_validade")
	private Integer anoValidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_financeira", insertable = false, updatable = false, foreignKey =  @ForeignKey(name="fk_id_financeira"))
	private FinanceiraModel financeiraModel;
	
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private UsuarioModel usuario;
	
	
}
