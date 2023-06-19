package br.com.financas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_tipo_compra", schema = "app_financas")
public class TipoCompraEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tp_compra")
	private Long idTipoCompra;
	
	@Column(name = "no_tipo_compra")
	private String noTipoCompra;

}
