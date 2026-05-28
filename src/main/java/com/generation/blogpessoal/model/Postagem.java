package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// Anotações: servem para alterar ou definir o comportamento da classe/atributos 

@Entity // Define que esta classe vai se tornar uma tabela no Banco de Dados
@Table(name = "tb_postagens") // Define o nome da tabela no Banco de Dados
public class Postagem {

	@Id // Define que este atributo é a Chave Primária (Primary Key)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor será gerado pelo banco de dados (Auto-Incremento)
	private Long id;

	@Column (length = 100)
	@NotBlank(message = "O atributo título é obrigatório!") // Não permite valores nulos ou vazios
	@Size(min = 5, max = 100, message = "O atributo título deve ter no minimo 5 e no máximo 100 caracteres.") // Limita o tamanho do texto
	@Pattern(regexp = "^[^0-9].*", message = "O título não pode ser apenas numérico")
	private String titulo;

	@Column(length = 1000)
	@NotBlank(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve ter no minimo 10 e no máximo 1000 caracteres.")
	@Pattern(regexp = "^[^0-9].*", message = "O texto não pode ser apenas numérico")
	private String texto;

	@UpdateTimestamp // O Banco de Dados preenche e atualiza a data/hora automaticamente a cada modificação
	private LocalDateTime data;
	
	@ManyToOne // Define o relacionamento: Muitas Postagens podem ter apenas Um Tema (Muitos para Um)
	@JsonIgnoreProperties("postagem") // Evita o efeito de "loop infinito" (recursão) na hora de converter os dados para JSON
	private Tema tema; // Cria a chave estrangeira (Foreign Key) da tabela Tema dentro da tabela Postagem
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario; // Cria a chave estrangeira (Foreign Key) da tabela Tema dentro da tabela Postagem

	// --- Getters e Setters (Métodos para acessar e modificar os atributos privados) ---
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
