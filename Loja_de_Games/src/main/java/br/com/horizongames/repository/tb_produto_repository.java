package br.com.horizongames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horizongames.model.tb_produto_model;

@Repository
public interface tb_produto_repository extends JpaRepository<tb_produto_model, Long> {
	public List<tb_produto_model> findAllByNomeContainingIgnoreCase(String nome);
}
