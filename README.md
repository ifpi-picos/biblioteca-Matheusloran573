# 📚 *Biblioteca *  

Este é um sistema desenvolvido em **Java** utilizando **MySQL** para gerenciar uma biblioteca, permitindo o cadastro, consulta e gerenciamento de livros e usuários.  

## 📂 *Estrutura do Projeto*  

O projeto segue a seguinte organização de pastas:  

- **`src/`**: Contém o código-fonte do projeto.  
- **`lib/`**: Armazena as dependências do projeto.  
- **`bin/`**: Contém os arquivos compilados gerados automaticamente.  

## 🔗 *Gerenciamento de Dependências*  

As dependências do projeto são gerenciadas pelo **Maven**.  

### 📦 *Dependência principal*  

Este projeto utiliza o **MySQL Connector** para conectar-se ao banco de dados MySQL:  

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>