package servico;

import dao.EmprestimoDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import dominio.Emprestimo;
import dominio.Livro;
import dominio.Usuario;

import javax.swing.*;

import app.Menu;

import java.util.List;

public class BibliotecaService {
    private LivroDAO livroDAO;
    private UsuarioDAO usuarioDAO;
    private EmprestimoDAO emprestimoDAO;

    public BibliotecaService() {
        this.livroDAO = new LivroDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.emprestimoDAO = new EmprestimoDAO();
    }

   public void exibirMenu() {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
    
    public void cadastrarLivro(String titulo, String autor) {
        Livro livro = new Livro(0, titulo, autor, false);
        livroDAO.cadastrarLivro(livro);
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
    }

    public void listarLivros() {
        List<Livro> livros = livroDAO.listarLivros();
        StringBuilder sb = new StringBuilder("Lista de livros:\n");
        for (Livro livro : livros) {
            sb.append(livro.getTitulo()).append(" - ").append(livro.getAutor())
              .append(livro.isEmprestado() ? " (Emprestado)" : " (Disponível)").append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void listarLivrosEmprestados() {
        List<Emprestimo> emprestimos = emprestimoDAO.listarEmprestimosAtivos();
        if (emprestimos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro emprestado no momento.");
            return;
        }

        StringBuilder sb = new StringBuilder("Livros emprestados:\n");
        for (Emprestimo emprestimo : emprestimos) {
            Livro livro = livroDAO.buscarLivroPorId(emprestimo.getIdLivro());
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(emprestimo.getIdUsuario());

            sb.append(livro.getTitulo()).append(" - ").append(livro.getAutor())
              .append(" | Emprestado para: ").append(usuario.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void pegarEmprestado(String nomeUsuario, String tituloLivro) {
        Usuario usuario = usuarioDAO.buscarOuCriarUsuario(nomeUsuario);
        Livro livro = livroDAO.buscarLivroPorTitulo(tituloLivro);

        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return;
        }
        if (livro.isEmprestado()) {
            JOptionPane.showMessageDialog(null, "Este livro já está emprestado.");
            return;
        }

        emprestimoDAO.registrarEmprestimo(usuario.getId(), livro.getId());
        JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");
    }

    public void devolverLivro(String nomeUsuario, String tituloLivro) {
        Livro livro = livroDAO.buscarLivroPorTitulo(tituloLivro);

        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return;
        }
        if (!livro.isEmprestado()) {
            JOptionPane.showMessageDialog(null, "Este livro já está disponível.");
            return;
        }

        emprestimoDAO.registrarDevolucao(livro.getId());
        JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!");
    }
}
