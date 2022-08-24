package br.com.financas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.financas.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	@Query("SELECT u FROM UsuarioModel u WHERE UPPER(u.nomeUsuario) =:nomeUsuario ")
	Optional<UsuarioModel> findByUsuarioNome(@Param("nomeUsuario") String nomeUsuario);
	
}
