public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    private Livro livroAlugado;

    public Usuario(String nome, String cpf, String email, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.livroAlugado = null;
    }

    // Getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Livro getLivroAlugado() {
        return livroAlugado;
    }

    public void setLivroAlugado(Livro livroAlugado) {
        this.livroAlugado = livroAlugado;
    }

    public void alugarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            this.livroAlugado = livro;
            livro.setDisponivel(false);
            System.out.println(nome + " alugou o livro: " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível.");
        }
    }

    public void devolverLivro() {
        if (livroAlugado != null) {
            livroAlugado.setDisponivel(true);
            System.out.println(nome + " devolveu o livro: " + livroAlugado.getTitulo());
            livroAlugado = null;
        } else {
            System.out.println(nome + " não tem nenhum livro para devolver.");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Endereço: " + endereco + ", Telefone: " + telefone;
    }
}
