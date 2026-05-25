package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.blogpessoal.model.Tema;

//Interface que gerencia as operações de banco de dados para a entidade Tema
public interface TemaRepository extends JpaRepository<Tema, Long> {

   public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
   // Query Method: O Spring Data JPA cria a consulta SQL automaticamente com base no nome do método
   // Busca todos os temas onde a descrição contenha a palavra digitada (Containing), ignorando maiúsculas e minúsculas (IgnoreCase)
}