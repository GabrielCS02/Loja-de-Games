package br.com.horizongames.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;

public class UsuarioRepository {
	/**
	 * Método que busca um usuário pelo seu usuario (email).
	 * 
	 * select * from tb_usuarios where usuario = "usuario procurado"
	 */
	public Optional<Usuario> findByUsuario(String usuario);

	
}
