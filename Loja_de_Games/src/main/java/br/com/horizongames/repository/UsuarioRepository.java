package br.com.horizongames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horizongames.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	/**
	 * Filtro para buscar um usuario dentro do atributo "usuario" na tb_usuario
	 * 
	 * select * from tb_usuarios where usuario = "usuario procurado"
	 */
	public Optional<Usuario> findByUsuario(String usuario);

	
}
