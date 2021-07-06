package br.com.financas.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.financas.model.UsuarioModel;

@Repository
@Transactional
public class UsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvarUsuario(UsuarioModel usuario) {
		this.entityManager.persist(usuario);
		this.entityManager.flush();
	}

	public UsuarioModel loginUsuario(String email, String senha) {
		try {
			return this.entityManager
					.createQuery("SELECT u FROM UsuarioModel u WHERE u.emailUsuario=:email and u.senhaUsuario =:senha",
							UsuarioModel.class)
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

}
