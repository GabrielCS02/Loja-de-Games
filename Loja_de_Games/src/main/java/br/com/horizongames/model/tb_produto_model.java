package br.com.horizongames.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private long id_produto;
	
	@NotBlank(message="É obrigatório o nome do produto")
	private String nome;
	
	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
	@NotBlank(message="É obrigatório colocar um valor")
	@JsonIgnoreProperties("tb_produtos")
	private int tipo;
	
	@NotBlank(message="É obrigatório colocar o preço do produto")
	private double preço;

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getPreço() {
		return preço;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}
	
}
