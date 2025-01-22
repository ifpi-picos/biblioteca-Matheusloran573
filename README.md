Sistema de Gerenciamento de Biblioteca



Este projeto é um sistema simples de gerenciamento de uma biblioteca, desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos (POO). Ele permite o cadastro de livros e usuários, além de gerenciar o empréstimo e devolução de livros, bem como listar livros emprestados e consultar o histórico de empréstimos dos usuários.

Estrutura do Projeto.

O projeto está organizado em classes, seguindo os princípios da POO:

Classe Livro

Representa os livros disponíveis na biblioteca.

Gerencia atributos como título, autor, ano de publicação e disponibilidade.

Fornece métodos para obter e modificar informações sobre os livros.

Sobrescreve o método toString() para exibir informações completas do livro, incluindo seu status (disponível ou emprestado).



Classe Usuario

Representa os usuários cadastrados no sistema.

Gerencia informações pessoais, como nome, CPF, e-mail, endereço e telefone.

Permite a operação de aluguel e devolução de livros.

Mantém um histórico de empréstimos com os títulos de todos os livros alugados pelo usuário ao longo do tempo.

Fornece métodos para acessar o histórico de empréstimos e o livro atualmente alugado.



Classe Biblioteca

Gerencia o sistema como um todo.

Contém listas para armazenar livros e usuários.

Possui métodos para:

Cadastrar livros e usuários.

Buscar livros ou usuários pelo título ou nome.

Contar o número de livros disponíveis.

Listar todos os livros emprestados com detalhes.

Centraliza as funcionalidades principais do sistema.



Classe Main

Ponto de entrada do programa.

Apresenta um menu interativo para os usuários executarem as funcionalidades do sistema:

Cadastro de usuários.

Cadastro de livros.

Empréstimo de livros.

Devolução de livros.

Consulta de livros disponíveis.

Listagem de livros emprestados.

Consulta do histórico de empréstimos de um usuário.

Encerramento do programa.

Conecta todas as funcionalidades das classes de maneira intuitiva para o usuário.





[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/w9mRoD7p)
