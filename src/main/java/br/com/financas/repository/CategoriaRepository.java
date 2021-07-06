package br.com.financas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.financas.model.CategoriaModel;

@Repository
public class CategoriaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvarCategoria(CategoriaModel categoria) {
		this.entityManager.persist(categoria);
		this.entityManager.flush();
	}
	
	public List<CategoriaModel> listarCategorias(){
		try {
			return this.entityManager
					.createQuery("SELECT c FROM CategoriaModel c ORDER BY c.descricao ASC", CategoriaModel.class)
					.getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	public void atualizarCategorya(CategoriaModel categoria) {
		Query query = this.entityManager.createQuery("UPDATE CategoriaModel set descricao =:descricao where idCategoria =:idCategoria");
		query.setParameter("descricao", categoria.getDescricao());
		query.setParameter("idCategoria", categoria.getIdCategoria());
		query.executeUpdate();
	}
	
	public List<CategoriaModel> buscarCategoria(String descricao){
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT c FROM CategoriaModel c WHERE c.descricao like ");
			return this.entityManager.createQuery(sql.toString(), CategoriaModel.class)
					.setParameter("descricao", "%"+descricao.trim())
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
}
