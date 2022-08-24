package br.com.financas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
@Entity
@Table(name = "tb_entrada_saida",schema = "financas")
@SequenceGenerator(name = "sq_id_entrada_saida", sequenceName = "seq_id_entrada_saida", schema = "financas", allocationSize = 1, initialValue = 1)
public class EntradaSaidaModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_entrada_saida")
	@GeneratedValue(generator = "sq_id_entrada_saida", strategy = GenerationType.SEQUENCE)
	private Long idEntradaSaida;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "tipo_entrada_saida")
	private String tipoEntradaSaida;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_entrada_saida")
	private Date dtEntradaSaida;
	
	@Column(name = "valor")
	private BigDecimal valor;
	

}
