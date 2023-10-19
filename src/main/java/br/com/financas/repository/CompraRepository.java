package br.com.financas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.financas.model.CompraEntity;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, Long>, JpaSpecificationExecutor<CompraEntity> {

	@Query("SELECT c FROM CompraEntity c WHERE c.idCartao =:idCartao")
	public List<CompraEntity> listarComprasByCartao(@Param("idCartao") Long idCartao);
	
	@Query("SELECT c FROM CompraEntity c WHERE c.idTpCompra =:idTpCompra")
	public List<CompraEntity> listarComprasByTpCompra(@Param("idTpCompra") Long idTpCompra);
	
	@Query("SELECT c FROM CompraEntity c WHERE c.dataCompra > :dtInicio and c.dataCompra < :dtFim")
	public List<CompraEntity> listarComprasByDataCompra(@Param("dtInicio") Date dataInicio, @Param("dtFim") Date dataFim);
	
}
