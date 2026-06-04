package com.generation.blogpessoal.util;

import com.generation.blogpessoal.model.Usuario;
import com.generation.blogpessoal.model.UsuarioLogin;

// Classe utilitária (Builder) usada para facilitar a criação de objetos com dados simulados (mock) para a realização de testes.
public class TestBuilder {
	// Instancia e preenche um objeto do tipo Usuario.
	public static Usuario criarUsuario(Long id, String nome, String usuario, String senha) {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setId(id);
		novoUsuario.setNome(nome);
		novoUsuario.setUsuario(usuario);
		novoUsuario.setSenha(senha);
		novoUsuario.setFoto("-"); // Define uma foto padrão/vazia para testes
		return novoUsuario;
	}

	// Instancia e preenche um objeto do tipo UsuarioLogin.
	public static UsuarioLogin criarUsuarioLogin(String usuario, String senha) {
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		usuarioLogin.setUsuario(usuario);
		usuarioLogin.setSenha(senha);
		return usuarioLogin;
	}
}