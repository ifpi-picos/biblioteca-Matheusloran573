package dao;

import dominio.Usuario;

import java.sql.*;

public class UsuarioDAO {
    public Usuario buscarOuCriarUsuario(String nome) {
        String buscarSql = "SELECT id FROM usuarios WHERE nome = ?";
        String inserirSql = "INSERT INTO usuarios (nome) VALUES (?) RETURNING id";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement buscarStmt = conn.prepareStatement(buscarSql)) {
            buscarStmt.setString(1, nome);
            ResultSet rs = buscarStmt.executeQuery();

            if (rs.next()) {
                return new Usuario(rs.getInt("id"), nome);
            } else {
                try (PreparedStatement inserirStmt = conn.prepareStatement(inserirSql)) {
                    inserirStmt.setString(1, nome);
                    ResultSet rsInserir = inserirStmt.executeQuery();
                    rsInserir.next();
                    return new Usuario(rsInserir.getInt("id"), nome);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar ou criar usuário", e);
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
