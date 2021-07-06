package br.com.financas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.financas.model.FaturaModel;
import br.com.financas.model.FaturaPagaModel;

@Repository
public class FaturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvarFatura(FaturaModel fatura) {
		this.entityManager.persist(fatura);
		this.entityManager.flush();
	}

	public void salvarFaturaPaga(FaturaPagaModel faturaPaga) {
		this.entityManager.persist(faturaPaga);
		this.entityManager.flush();
	}
	
}
