package br.com.financas.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.financas.model.FaturaCartaoEntity;

@Repository
public interface FaturaRepository extends JpaRepository<FaturaCartaoEntity, Long>, JpaSpecificationExecutor<FaturaCartaoEntity> {

	@Query("SELECT count(1) > 0 FROM FaturaCartaoEntity where dtFechamento=:dtFechamento")
	public Boolean existeFaturaMesAtual(@Param("dtFechamento") Date dtFechamento);
	
	@Query("SELECT f FROM FaturaCartaoEntity f WHERE f.dtFechamento=:dtFechamento")
	public Optional<FaturaCartaoEntity> findByFaturaMesAtual(@Param("dtFechamento") Date dtFechamento);
	
}
