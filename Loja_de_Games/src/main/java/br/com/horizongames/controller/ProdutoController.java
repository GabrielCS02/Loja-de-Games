package br.com.horizongames.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.horizongames.model.Produto;
import br.com.horizongames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
    // retorna todas as postagens
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
    // Retorna uma postagem pelo título
	 @GetMapping("/{id}")
	 public ResponseEntity<Produto> GetById(@Valid @PathVariable long id){
		 return produtoRepository.findById(id)
		.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}

	    // Retorna postagem pelo título
	  @GetMapping("/titulo/{titulo}")
	  public ResponseEntity<List<Produto>> GetByNome(@Valid @PathVariable String nome){
		  return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
		}
	  // Adiciona uma postagem
	  @PostMapping
	  public ResponseEntity<Produto> post (@Valid @RequestBody Produto produto){
		  return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	  //altera uma postagem
	  }
	  @PutMapping
	  public ResponseEntity<Produto> put (@Valid @RequestBody Produto produto){
		  return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	  }
	  
	  @DeleteMapping("/{id}")
	  public void delete(@PathVariable long id) {
		  produtoRepository.deleteById(id);
	  }
}
