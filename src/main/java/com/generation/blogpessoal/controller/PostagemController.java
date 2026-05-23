package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

import jakarta.validation.Valid;

// Anotações: alterar e/ou definir comportamentod

@RestController // Indica que a classe é uma Controller (Recebe requisições REST e envia Respostas)
@RequestMapping("/postagens") // Define o endereço (endpoint) base para as requisições desta classe esse

// Configurando o CORS
// @CrossOrigin(origins = "https://meufrontend.com", allowedHeaders = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite que qualquer aplicação frontend (React, Angular, Vue, etc.) acesse este endpoint.
												  // Em produção, substitua "*" pelo domínio específico do seu frontend para evitar acessos não autorizados e reduzir riscos de injeção de dados.

public class PostagemController {

	@Autowired // Injeção de Dependência: O Spring cria e gerencia o objeto do Repositório automaticamente
	private PostagemRepository postagemRepository;


	@GetMapping // Mapeia requisições do tipo GET (Leitura/Busca de dados)
	public ResponseEntity<List<Postagem>> getAll() {
		// Retorna a lista com todas as postagens e o status HTTP 200 (OK)
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	@GetMapping("/{id}") // O {id} indica que um valor será passado pela URL (ex: /postagens/1)
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {
		// @PathVariable captura o {id} da URL. Retorna 200 (OK) se achar, ou 404 (Not Found) se não achar.
		return postagemRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		// Retorna a lista de postagens que contenham o texto pesquisado no título
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping // Mapeia requisições do tipo POST (Criação de novos dados)
	public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem) {
		// @Valid: Executa as validações da Model. @RequestBody: Pega os dados enviados no corpo da requisição (JSON)
		postagem.setId(null); // Garante que o ID será gerado pelo banco (evita atualizar um registro sem querer)
		// Salva no banco e retorna status 201 (Created)
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}

	@PutMapping // Mapeia requisições do tipo PUT (Atualização de dados existentes)
	public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
		// Verifica se o ID enviado existe no banco antes de atualizar. 
		// Retorna 200 (OK) atualizado ou 404 se o ID não for encontrado.
		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT) // Força o retorno do status 204 (Sem conteúdo) em caso de sucesso
	@DeleteMapping("/{id}") // Mapeia requisições do tipo DELETE
	public void delete(@PathVariable Long id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
		// Se não achar o ID no banco, lança uma exceção com erro 404 (Not Found)
		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		// Se achar, deleta a postagem
		postagemRepository.deleteById(id);
	}

}
