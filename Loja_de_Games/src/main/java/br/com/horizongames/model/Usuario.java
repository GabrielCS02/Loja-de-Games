package br.com.horizongames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/*@NotBlank: evita que o atributo fique em branco*/
	/*size: regula a quantidade minima e maxima de caracteres que o atributo aceitara */
	
	@NotBlank (message = "O atributo nome não poderá ficar vazio")
	@Size(min = 2, max = 100, message=" o campo deverá ter no mínimo 2 caracteres e no máximo 100")
	private String nome;
	
	@NotBlank(message = "O atributo usuario não poderá ficar vazio")
	@Size(min = 5, max = 100, message=" o campo deverá ter no mínimo 5 caracteres e no máximo 100")
	private String usuario;
	
	@NotBlank(message = "O atributo senha não poderá ficar vazio")
	@Size(min = 5, max = 100, message=" o campo deverá ter no mínimo 2 caracteres e no máximo 100")
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
