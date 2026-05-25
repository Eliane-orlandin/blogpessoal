package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity // Define que esta classe vai se tornar uma tabela no Banco de Dados
@Table(name = "tb_temas") // Define o nome da tabela no Banco de Dados
public class Tema {

	@Id // Define que este atributo é a Chave Primária (Primary Key)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor será gerado pelo banco de dados
														// (Auto-Incremento)
	private Long id;

	@NotBlank(message = "O Atributo Descrição é obrigatório") // Não permite valores nulos ou vazios
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE)
	// Define o relacionamento: Um Tema pode ter Muitas Postagens (Um para Muitos)
	// fetch = FetchType.LAZY -> Carrega as postagens apenas quando forem explicitamente chamadas (melhora a performance)
	// mappedBy = "tema" -> Indica que o relacionamento foi mapeado pelo atributo "tema" lá na classe Postagem
	// cascade = CascadeType.REMOVE -> Se um Tema for deletado, todas as Postagens associadas a ele também serão apagadas automaticamente
	@JsonIgnoreProperties(value = "tema", allowSetters = true) // Evita o loop infinito no JSON.
	private List<Postagem> postagem;

	// --- Getters e Setters (Métodos para acessar e modificar os atributos privados) ---

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

}