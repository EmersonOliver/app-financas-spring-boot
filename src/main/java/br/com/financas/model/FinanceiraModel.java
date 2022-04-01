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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_financeira", schema = "financas")
public class FinanceiraModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_financeira")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFinanceira;

	@Column(name = "nome")
	private String nome;
	
	@JoinColumn(name = "id_financeira", referencedColumnName = "id_financeira")
	@OneToMany(fetch = FetchType.EAGER)
	private List<CartaoModel> cartoes;

	public FinanceiraModel(Long idFinanceira, String nome) {
		super();
		this.idFinanceira = idFinanceira;
		this.nome = nome;
	}
	
	

	 
}
