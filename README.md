# 📝 Blog Pessoal - Backend

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-purple?style=for-the-badge)

## 💻 Sobre o Projeto
Uma API RESTful construída com **Java** e **Spring Boot** para o backend de um Blog Pessoal. Este projeto permite a criação, leitura, atualização e exclusão (CRUD) de postagens, temas e usuários, com relacionamentos de banco de dados e autenticação de segurança.

Este projeto está sendo desenvolvido como parte do bootcamp **Java Fullstack da Generation Brasil**. O objetivo é aplicar na prática os conceitos de desenvolvimento Backend, arquitetura de APIs, modelagem de dados (JPA/Hibernate) e boas práticas de programação.

## ⚙️ Funcionalidades (Em implementação)
- [ ] Cadastro e autenticação de Usuários (Spring Security & JWT)
- [ ] CRUD de Temas (Categorias das postagens)
- [ ] CRUD de Postagens
- [ ] Relacionamento entre as tabelas (OneToMany / ManyToOne)
- [ ] Documentação da API com Swagger (OpenAPI)
- [ ] Deploy na nuvem

## 🛠️ Tecnologias e Ferramentas Utilizadas
- **Linguagem:** Java (versão 21+)
- **Framework:** Spring Boot
- **Banco de Dados:** MySQL
- **Gerenciador de Dependências:** Maven
- **IDEs:** Spring Tool Suite (STS) / Visual Studio Code
- **Testes de API:** Insomnia / Postman

## 🚀 Como executar este projeto localmente

### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
* [Git](https://git-scm.com)
* [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Spring Tool Suite (STS)](https://spring.io/tools) ou [VS Code](https://code.visualstudio.com/)
* [MySQL](https://www.mysql.com/)

### Passo a Passo

1. **Clone este repositório**
```bash
git clone https://github.com/Eliane-orlandin/blogpessoal.git
```

2. **Acesse a pasta do projeto no terminal/cmd**
```bash
cd blogpessoal
```

3. **Importe o projeto na sua IDE**
- No STS: `File > Import > Maven > Existing Maven Projects` e selecione a pasta do projeto.
- No VS Code: Abra a pasta do projeto e aguarde a extensão do Java carregar as dependências.

4. **Configure o Banco de Dados**
No arquivo `src/main/resources/application.properties`, configure as credenciais do seu banco de dados MySQL local.

5. **Execute a aplicação**
Rode o arquivo `BlogPessoalApplication.java` como uma aplicação Java. O servidor iniciará por padrão na porta `8080`.

## 👩‍💻 Autora

Desenvolvido por **Eliane Orlandin** 

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/elianeorlandindocarmo/) 
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Eliane-orlandin)
