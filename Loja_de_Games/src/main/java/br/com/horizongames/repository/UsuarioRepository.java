package br.com.horizongames.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;

public class UsuarioRepository {
	/**
	 * Filtro para buscar um usuario dentro do atributo "usuario" na tb_usuario
	 * 
	 * select * from tb_usuarios where usuario = "usuario procurado"
	 */
	public Optional<Usuario> findByUsuario(String usuario);

	
}
