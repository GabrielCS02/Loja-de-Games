package br.com.horizongames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horizongames.model.tb_categoria_model;

@Repository
public interface tb_categoria_repository extends JpaRepository<tb_categoria_model, Long> {
	public List<tb_categoria_model> findAllByNomeContainingIgnoreCase(String nome);
}
