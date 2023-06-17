package br.com.financas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.financas.model.CartaoModel;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoModel, Long>, JpaSpecificationExecutor<CartaoModel> {

	public Optional<CartaoModel> findByNumeroCartaoContaining(String numeroCartao);
}
