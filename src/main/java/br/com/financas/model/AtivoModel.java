package br.com.financas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_ativo", schema = "financas")
public class AtivoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ativo")
	private Long idAtivo;
	
	@Column(name = "nome_ativo")
	private String nomeAtivo;

	@Column(name = "status")
	private Boolean status;
	
	
}
