package br.com.horizongames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//Criação da tabela
@Entity

//Nome da tabela
@Table(name="tb_produto")
public class tb_produto_model {
	
	// Criando a primary key
	@Id
	// Declarando auto-increment no id_produto
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="É obrigatório o nome do produto")
	private String nome;
	
	@ManyToOne
	@JsonIgnoreProperties("tb_produtos")
	private tb_categoria_model categoria;
	
	@NotBlank(message="É obrigatório colocar o preço do produto")
	private double preço;
	
	

	public long getId_produto() {
		return id;
	}

	public void setId_produto(long id_produto) {
		this.id = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public tb_categoria_model getCategoria() {
		return categoria;
	}

	public void setCategoria(tb_categoria_model categoria) {
		this.categoria = categoria;
	}

	
}
