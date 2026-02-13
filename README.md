# 📚 Buscador Literário 
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)


O **Buscador literário** é um catálogo de livros interativo que consome a API [Gutendex](https://gutendex.com/) para buscar informações sobre obras literárias, 
permitindo o armazenamento e a gestão de dados em um banco de dados relacional. 

Este projeto foi desenvolvido como um desafio de programação para consolidar conhecimentos em Java, Spring Boot e persistência de dados. 
Desafio proposto na formação Java Alura / Oracle Next Education (ONE).

## 🚀 Funcionalidades

- **Buscar livros por título:** Consulta a API externa e salva livros e autores no banco de dados.
- **Listar livros registrados:** Exibe todos os livros já baixados no sistema.
- **Listar autores registrados:** Lista todos os autores salvos.
- **Filtrar autores vivos:** Busca autores que estavam vivos em um determinado ano informado pelo usuário.
- **Filtrar por idioma:** Lista livros de acordo com o código do idioma (ex: pt, en, fr, es).

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Data JPA**
- **PostgreSQL** 
- **Jackson** 
- **Maven**
- **API Gutendex** 

---
### API Gutendex
A API Gutendex é um catálogo com informações sobre os mais de 70 mil livros presentes no Project Gutenberg (biblioteca online gratuita).
* Link da API: [Gutendex](https://gutendex.com/)
* Repositório da API: [GitHub - garethbjohnson/gutendex: Web API for Project Gutenberg ebook metadata](https://github.com/garethbjohnson/gutendex)
---

## 💎 Práticas e Conceitos Aplicados

Este projeto foi construído seguindo boas práticas e princípios de arquitetura de software:

### 1. Integridade e Atomicidade (ACID)
Utilização da anotação `@Transactional` para garantir que operações complexas no banco de dados (como salvar um autor e um livro simultaneamente) ocorram de forma atômica. 
Se uma parte da operação falhar, o sistema realiza um *rollback* automático, evitando dados "órfãos".

### 2. Princípios SOLID
- **Responsabilidade Única (SRP):** Separação clara entre a visualização (`view`), a lógica de negócio (`service`), o consumo da API (`ConsumoApi`) e o acesso aos dados (`repository`).
- **Inversão de Dependência (DIP):** Uso de interfaces para a conversão de dados, permitindo que a implementação técnica seja alterada sem afetar as regras de negócio.

### 3. Injeção de Dependência
Implementação de injeção de dependência via **construtor**, que é a prática recomendada pelo Spring para garantir a imutabilidade das dependências.

### 4. Otimização de Persistência
- **Mapeamento Objeto-Relacional (ORM):** Uso de relações `@ManyToMany` e `@ElementCollection` para representar fielmente a estrutura de dados literários.
- **Prevenção de Duplicidade:** Implementação de travas de segurança que verificam se o livro ou autor já existem no banco de dados antes de realizar um novo registro, mantendo a integridade do acervo.

### 5. DTOs e Records
Uso de **Java Records** para mapear as respostas da API. Isso garante que a camada de persistência (`Entity`) fique isolada da camada de transporte de dados (`DTO`), protegendo a arquitetura da aplicação.

---

## ⚙️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/amandaconstante/acervo-gutenberg.git
   ```
2. Configure as variáveis de ambiente no seu application.properties ou no sistema:

    - DB_HOST: Endereço do seu banco PostgreSQL.

    - DB_NAME: Nome do banco de dados.

    - USER_NAME: Seu usuário do banco.

    - PASSWORD: Sua senha do banco.

3. Execute a aplicação.
