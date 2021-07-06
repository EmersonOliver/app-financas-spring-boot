package br.com.financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario", schema = "fin")
@SequenceGenerator(name = "sq_id_usuario", sequenceName = "seq_id_usuario", allocationSize = 1, initialValue = 1, schema = "fin")
public class UsuarioModel {

	@Id
	@GeneratedValue(generator = "sq_id_usuario",strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario", precision = 8, nullable = false, unique = true)
	private Long idUsuario;
	
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	
	@Column(name = "email_usuario")
	private String emailUsuario;
	
	@Column(name = "senha_usuario")
	private String senhaUsuario;

	public UsuarioModel(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
	}

}
