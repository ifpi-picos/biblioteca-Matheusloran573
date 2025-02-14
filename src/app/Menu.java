package app;

import servico.BibliotecaService;

import javax.swing.*;

public class Menu {
    private BibliotecaService bibliotecaService;

    public Menu() {
        this.bibliotecaService = new BibliotecaService();
    }

    public void exibirMenu() {
        String[] opcoes = {"Cadastrar Livro", "Listar Livros", "Listar Emprestados", "Pegar Livro Emprestado", "Devolver Livro", "Sair"};
        while (true) {
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Biblioteca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0 -> {
                    String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
                    String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
                    bibliotecaService.cadastrarLivro(titulo, autor);
                }
                case 1 -> bibliotecaService.listarLivros();
                case 2 -> bibliotecaService.listarLivrosEmprestados();
                case 3 -> {
                    String usuario = JOptionPane.showInputDialog("Digite seu nome:");
                    String livro = JOptionPane.showInputDialog("Digite o título do livro:");
                    bibliotecaService.pegarEmprestado(usuario, livro);
                }
                case 4 -> {
                    String usuario = JOptionPane.showInputDialog("Digite seu nome:");
                    String livro = JOptionPane.showInputDialog("Digite o título do livro:");
                    bibliotecaService.devolverLivro(usuario, livro);
                }
                case 5 -> System.exit(0);
            }
        }
    }
}
