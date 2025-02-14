package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_db";
    private static final String USUARIO = "root";
    private static final String SENHA = "senha";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") // Driver do MySQL
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException var1) {
            throw new RuntimeException("Driver JDBC não encontrado!", var1);
        }
    }
}