package br.com.horizongames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;
	
	@NotBlank(message= "A Descrição não pode ficar vazia")
	private String descricao;
	
	@NotBlank(message= "O tipo de jogo deve possuir informações.")
	private String tipo_jogo;
	
	@NotBlank(message= "O nome dos desenvolvedores é crucial.")
	private String desenvolvedores;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo_jogo() {
		return tipo_jogo;
	}

	public void setTipo_jogo(String tipo_jogo) {
		this.tipo_jogo = tipo_jogo;
	}

	public String getDesenvolvedores() {
		return desenvolvedores;
	}

	public void setDesenvolvedores(String desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	

}
