package com.generation.blogpessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotação principal que ativa as configurações automáticas do Spring Boot
public class BlogpessoalApplication {

	// Método principal (ponto de entrada) que inicia qualquer programa em Java
	public static void main(String[] args) {
		
		// Comando que inicializa a aplicação Spring e sobe o servidor local (como o Tomcat)
		SpringApplication.run(BlogpessoalApplication.class, args);
	}

}
