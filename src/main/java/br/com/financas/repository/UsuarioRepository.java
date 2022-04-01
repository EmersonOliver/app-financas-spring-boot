package br.com.financas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.financas.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	
	@Query(name = "loginUsuario", value = "SELECT u FROM UsuarioModel u WHERE u.email =:email and u.senha=:password")
	UsuarioModel efetuarLogin(String email, String password);
	
	@Query(name = "usuarioExiste", value = "SELECT u FROM UsuarioModel u WHERE UPPER(u.email) =:email")
	List<UsuarioModel> usuarioExistente(String email);

	
	
}
