package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection conn;

    private final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USUARIO = "root";
    private static final String SENHA = "fefe21@";

    public UsuarioDao(Connection conn) {
        this.conn = conn;
    }

    public List<Usuarios> obterTodosUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM cadastros";
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setId(rs.getInt("id"));
                usuario.setNome_do_Episodio(rs.getString("nome_do_Episodio"));
                usuario.setNumeroEp(rs.getString("NumeroEp"));
                usuario.setDURACAO(rs.getInt("DURACAO"));
                usuario.setURLRepo(rs.getString("URLRepo"));
                usuario.setProdutor(rs.getString("produtor"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public int salvar(Usuarios usuarios) {
        int status;
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO cadastros (nome_do_Episodio, NumeroEp, DURACAO, URLRepo, produtor) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, usuarios.getNome_do_Episodio());
            st.setString(2, usuarios.getNumeroEp());
            st.setInt(3, usuarios.getDURACAO());
            st.setString(4, usuarios.getURLRepo());
            st.setString(5, usuarios.getProdutor());

            status = st.executeUpdate();
            return status;

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public int excluirPorId(int id) {
        int status;
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM cadastros WHERE id = ?");
            st.setInt(1,id);
            status = st.executeUpdate();
            return status;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuário: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }
}
