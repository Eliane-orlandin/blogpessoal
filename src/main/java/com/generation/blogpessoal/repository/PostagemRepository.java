package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.blogpessoal.model.Postagem;

//Interface responsável pela comunicação com o Banco de Dados (operações de CRUD: Criar, Ler, Atualizar, Deletar)
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

	// Ao herdar (extends) o JpaRepository, ganhamos vários métodos prontos como
	// save(), findAll(), findById(), delete()

	// <Postagem, Long> significa:
	// Postagem: A Entidade (tabela) que este repositório vai manipular.
	// Long: O tipo de dado do atributo que é a Chave Primária (@Id) na classe
	// Postagem.
}
