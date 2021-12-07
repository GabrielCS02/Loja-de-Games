package br.com.horizongames.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.horizongames.model.tb_categoria_model;
import br.com.horizongames.repository.tb_categoria_repository;

@RestController // Função de marcar que o controlador está fornecendo serviços REST com o tipo de resposta JSON.
@RequestMapping("/categoria") //Define a entry point (define a URL)
@CrossOrigin("*") // Mecanismo utilizado pelos navegadores para compartilhar recursos entre diferentes origens.
public class CategoriaController {
	
	@Autowired // Define indica um ponto onde a injeção automática deve ser aplicada. Usada em métodos, atributos e construtores.
	private tb_categoria_repository repository;
	
	@GetMapping // retornar todas as postagens
	public ResponseEntity<List<tb_categoria_model>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") // retornar todas as postagens pelo ID
	public ResponseEntity<tb_categoria_model> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}") //retornar as postagens pela categoria
	public ResponseEntity<List<tb_categoria_model>> GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(descricao));
	}
	
	@PostMapping //inserir dados no banco de dados
	public ResponseEntity<tb_categoria_model> Post(@RequestBody tb_categoria_model post){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	
	@PutMapping //atualizar um dado ja existente no banco de dados
	public ResponseEntity<tb_categoria_model> Put(@RequestBody tb_categoria_model put){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(put));
	}
	
	@DeleteMapping("/{id}") //deletar dados do banco de dados pelo id
	public void Delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
