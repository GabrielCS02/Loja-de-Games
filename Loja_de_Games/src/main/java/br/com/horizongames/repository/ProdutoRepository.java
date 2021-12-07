package br.com.horizonGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horizonGames.model.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	/**
	 * Method Query equivalente a instrução SQL
	 * SELECT * FROM tb_postagem where like "%titulo%"
	 */
	
	public List<Produto> findAllByNomeContainingIgnoreCase (String nome);
}
