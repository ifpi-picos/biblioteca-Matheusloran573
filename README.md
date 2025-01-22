---

# Sistema de Gerenciamento de Biblioteca

Este projeto é um sistema simples de gerenciamento de uma biblioteca, desenvolvido em **Java**, utilizando conceitos de **Programação Orientada a Objetos (POO)**. Ele permite:  
- Cadastro de livros e usuários.  
- Gerenciamento de empréstimos e devoluções de livros.  
- Listagem de livros emprestados e consulta do histórico de empréstimos dos usuários.

---

## 🗂️ Estrutura do Projeto

O projeto segue os princípios da POO e está organizado nas seguintes classes:

### **1. Classe Livro**
- Representa os livros disponíveis na biblioteca.  
- **Atributos:** título, autor, ano de publicação, disponibilidade.  
- **Funcionalidades:**  
  - Obter e modificar informações dos livros.  
  - Exibir informações completas do livro com o método `toString()`, incluindo seu status (disponível ou emprestado).

---

### **2. Classe Usuario**
- Representa os usuários cadastrados no sistema.  
- **Atributos:** nome, CPF, e-mail, endereço, telefone.  
- **Funcionalidades:**  
  - Alugar e devolver livros.  
  - Manter um histórico de empréstimos, listando os títulos alugados.  
  - Consultar o livro atualmente alugado e o histórico de empréstimos.

---

### **3. Classe Biblioteca**
- Gerencia o sistema como um todo.  
- **Atributos:** listas de livros e usuários.  
- **Funcionalidades:**  
  - Cadastro de livros e usuários.  
  - Busca por livros ou usuários.  
  - Contagem de livros disponíveis.  
  - Listagem de livros emprestados com detalhes.

---

### **4. Classe Main**
- Ponto de entrada do programa.  
- **Funcionalidades:**  
  - Apresenta um menu interativo para os usuários com as seguintes opções:  
    - Cadastro de usuários.  
    - Cadastro de livros.  
    - Empréstimo de livros.  
    - Devolução de livros.  
    - Consulta de livros disponíveis.  
    - Listagem de livros emprestados.  
    - Consulta do histórico de empréstimos de um usuário.  
    - Encerramento do programa.

---

## 🔧 Tecnologias Utilizadas
- Linguagem: **Java**  
- Paradigma: **Programação Orientada a Objetos (POO)**  


---






[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/w9mRoD7p)
