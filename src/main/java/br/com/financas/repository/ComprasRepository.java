package br.com.financas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.financas.enums.MesEnum;
import br.com.financas.model.ComprasModel;

@Repository
public class ComprasRepository {

	@PersistenceContext
	private EntityManager entityManger;
	
	public void cadastrarCompra(ComprasModel compra) {
		this.entityManger.persist(compra);
		this.entityManger.flush();
	}
	
	public List<ComprasModel> listarTodasCompras(){
		try {
			return this.entityManger.createQuery(
					"SELECT c FROM ComprasModel c ORDER BY c.dataCompra ASC", ComprasModel.class)
					.getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	public List<ComprasModel> listarComprasDoMes(MesEnum mesEnum){
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT c FROM ComprasModel c WHERE ");
			sql.append("c.codMesReferencia =:codMes ");
			return this.entityManger.createQuery(sql.toString(), ComprasModel.class)
					.setParameter("codMes", mesEnum.getCodMes())
					.getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	public List<ComprasModel> listarComprasEntreMeses(Integer...meses){
		try {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT c FROM ComprasModel c ");
		sql.append("WHERE c.codMesReferencia in (:meses) ");
		return this.entityManger.createQuery(sql.toString(), ComprasModel.class)
				.setParameter("meses", meses)
				.getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
}
