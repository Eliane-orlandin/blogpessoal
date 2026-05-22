package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

// Anotações: alterar e/ou definir comportamentod

@RestController                  // indica que a classe é uma Controller (Recebe requisições e Responde)
@RequestMapping("/postagens")    // indica que as requisições do endpoint "/postagem" serão tratadas por esse controller
@CrossOrigin(origins = "*", allowedHeaders = "*")  // Permite essa controler receba reuisições libera o acesso a qualquer Frontend
public class PostagemController {

	@Autowired // inversão de dependência/ controle 
	private PostagemRepository postagemRepository;
	
	// cria a classe repo | implementa o método de interface | instancia um objeto da classe repo
	
	@GetMapping // GET | POST | PUT | DELETE -> Todas as requisições do tipo GET vão ser executadas por esse método
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long id){
		return postagemRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

}
