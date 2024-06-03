package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/usuario";
    private static final String USUARIO = "root";
    private static final String SENHA = "fefe21@";

    public static Connection obterConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão estabelecida com o banco de dados");
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Driver do bando de dados não localizado!");

            return null;
        }
    }
}
