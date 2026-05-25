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

import com.generation.blogpessoal.model.Tema;
import com.generation.blogpessoal.repository.TemaRepository;

import jakarta.validation.Valid;

@RestController // Define que a classe é uma controladora que responde requisições REST (JSON)
@RequestMapping("/temas") // Define a rota/endpoint base (/temas) para consumir este recurso
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permite o acesso de qualquer origem (essencial para conectar o Frontend)
public class TemaController {
    
    @Autowired // Faz a injeção automática do repositório de Temas
    private TemaRepository temaRepository;
    
    @GetMapping // Endpoint GET para listar todos os temas
    public ResponseEntity<List<Tema>> getAll(){
        // Retorna a lista completa com status 200 OK
        return ResponseEntity.ok(temaRepository.findAll());
    }
    
    @GetMapping("/{id}") // Endpoint GET para buscar um tema específico pelo ID passado na URL
    public ResponseEntity<Tema> getById(@PathVariable Long id){
        // Se encontrar o ID, retorna 200 OK. Se não, retorna 404 Not Found
        return temaRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @GetMapping("/descricao/{descricao}") // Endpoint GET para buscar temas por partes do texto da descrição
    public ResponseEntity<List<Tema>> getAllByDescricao(@PathVariable String descricao){
        // Usa o método personalizado do Repository para trazer os resultados (200 OK)
        return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }
    
    @PostMapping // Endpoint POST para criar um novo Tema
    public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema){
    	
    	tema.setId(null); // Garante que o ID comece nulo para forçar o banco a criar um novo registro (e não atualizar)
    	
        // Salva e retorna o tema criado com status 201 Created
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(temaRepository.save(tema));
    }
    
    @PutMapping // Endpoint PUT para atualizar um Tema existente
    public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema){
        // Busca se o ID enviado existe. Se sim, salva as alterações. Se não, retorna 404 Not Found
        return temaRepository.findById(tema.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED) // Dica: pode usar HttpStatus.OK (200) para atualizações
            .body(temaRepository.save(tema)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT) // Define o status 204 No Content se a deleção ocorrer com sucesso
    @DeleteMapping("/{id}") // Endpoint DELETE para remover um tema pelo ID
    public void delete(@PathVariable Long id) {
        Optional<Tema> tema = temaRepository.findById(id);
        
        // Valida se o ID realmente existe. Se estiver vazio, lança erro 404
        if(tema.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        // Deleta o tema do banco de dados
        temaRepository.deleteById(id);              
    }

}