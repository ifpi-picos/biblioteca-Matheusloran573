package dao;

import dominio.Emprestimo;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    public void registrarEmprestimo(int idUsuario, int idLivro) {
        String sqlEmprestimo = "INSERT INTO emprestimos (id_usuario, id_livro, data_emprestimo) VALUES (?, ?, ?)";
        String sqlAtualizarLivro = "UPDATE livros SET emprestado = true WHERE id = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmtEmprestimo = conn.prepareStatement(sqlEmprestimo);
             PreparedStatement stmtAtualizarLivro = conn.prepareStatement(sqlAtualizarLivro)) {

            conn.setAutoCommit(false); // Iniciar transação

            stmtEmprestimo.setInt(1, idUsuario);
            stmtEmprestimo.setInt(2, idLivro);
            stmtEmprestimo.setDate(3, Date.valueOf(LocalDate.now()));
            stmtEmprestimo.executeUpdate();

            stmtAtualizarLivro.setInt(1, idLivro);
            stmtAtualizarLivro.executeUpdate();

            conn.commit(); // Confirmar transação

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarDevolucao(int idLivro) {
        String sqlDevolucao = "UPDATE emprestimos SET data_devolucao = ? WHERE id_livro = ? AND data_devolucao IS NULL";
        String sqlAtualizarLivro = "UPDATE livros SET emprestado = false WHERE id = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmtDevolucao = conn.prepareStatement(sqlDevolucao);
             PreparedStatement stmtAtualizarLivro = conn.prepareStatement(sqlAtualizarLivro)) {

            conn.setAutoCommit(false);

            stmtDevolucao.setDate(1, Date.valueOf(LocalDate.now()));
            stmtDevolucao.setInt(2, idLivro);
            stmtDevolucao.executeUpdate();

            stmtAtualizarLivro.setInt(1, idLivro);
            stmtAtualizarLivro.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos WHERE data_devolucao IS NULL";

        try (Connection conn = ConexaoDB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                emprestimos.add(new Emprestimo(
                        rs.getInt("id"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_livro"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getDate("data_devolucao") != null ? rs.getDate("data_devolucao").toLocalDate() : null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }
}
