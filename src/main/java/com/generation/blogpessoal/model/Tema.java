package com.generation.blogpessoal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity // Define que esta classe vai se tornar uma tabela no Banco de Dados
@Table(name = "tb_temas") // Define o nome da tabela no Banco de Dados
public class Tema {
	
	@Id // Define que este atributo é a Chave Primária (Primary Key)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor será gerado pelo banco de dados (Auto-Incremento)
	private Long id;

	@NotBlank(message = "O Atributo Descrição é obrigatório") // Não permite valores nulos ou vazios
	private String descricao;
	
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

}