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
@Table(name = "tb_categoria", schema = "fin")
@SequenceGenerator(name = "sq_id_categoria", sequenceName = "seq_id_categoria", schema = "fin", initialValue = 1, allocationSize = 1)
public class CategoriaModel {

	@Id
	@GeneratedValue(generator = "sq_id_categoria", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_categoria", precision = 8, nullable = false, unique = true)
	private Long idCategoria;

	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;

	public CategoriaModel(Long idCategoria, String descricao) {
		super();
		this.idCategoria = idCategoria;
		this.descricao = descricao;
	}

}
