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
@Table(name = "tb_pagamentos", schema = "financas")
@SequenceGenerator(name = "sq_id_pagamento", sequenceName = "seq_id_pagamento", allocationSize = 1, initialValue = 1, schema = "financas")
public class PagamentosModel implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sq_id_pagamento",strategy = GenerationType.SEQUENCE)
	@Column(name = "id_pagamento")
	private Long idPagamento;
	
	@Column(name = "id_simulador")
	private Long id_simulador;
	
	@Column(name = "valor_pagamento")
	private BigDecimal valorPagamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
}
