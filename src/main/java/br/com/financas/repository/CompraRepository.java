package br.com.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.financas.model.ComprasModel;

@Repository
public interface CompraRepository extends JpaRepository<ComprasModel, Long> {

}
