package br.com.financas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario", schema = "financas")
@SequenceGenerator(name = "sq_id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1, initialValue = 1, schema = "financas")
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sq_id_usuario", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nomeUsuario")
	private String nomeUsuario;
	
	@JsonIgnoreProperties(value = {"usuario"})
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private List<CartaoModel> cartao;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private List<EntradaSaidaModel> entradaSaida;

	
}
