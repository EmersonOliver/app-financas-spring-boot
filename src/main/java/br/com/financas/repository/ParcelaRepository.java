package br.com.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.financas.model.ParcelaModel;

@Repository
public interface ParcelaRepository extends JpaRepository<ParcelaModel, Long>, JpaSpecificationExecutor<ParcelaModel> {

}
