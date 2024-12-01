package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    public ArrayList<Usuario> getAllUsers() throws SQLException, ClassNotFoundException {
        ArrayList<Usuario> list = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try (Connection conn = Conexao.getConn();
             PreparedStatement prep = conn.prepareStatement(query);
             ResultSet res = prep.executeQuery()) {

            while (res.next()) {
                Usuario user = new Usuario();
                user.setId(res.getInt("id"));
                user.setNome(res.getString("nome"));
                user.setEmail(res.getString("email"));
                user.setSenha(res.getString("senha"));
                list.add(user);
            }
        }
        return list;
    }

    public void setNewUser(Usuario user) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, SHA1(?))";

        try (Connection conn = Conexao.getConn();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, user.getNome());
            prep.setString(2, user.getEmail());
            prep.setString(3, user.getSenha());
            prep.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = Conexao.getConn();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);
            prep.executeUpdate();
        }
    }

    public Usuario getOneUser(int id) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        Usuario user = null;

        try (Connection conn = Conexao.getConn();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setInt(1, id);
            try (ResultSet res = prep.executeQuery()) {
                if (res.next()) {
                    user = new Usuario();
                    user.setId(res.getInt("id"));
                    user.setNome(res.getString("nome"));
                    user.setEmail(res.getString("email"));
                    user.setSenha(res.getString("senha"));
                }
            }
        }
        return user;
    }

    public Usuario getOneUserByEmail(String email) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM usuarios WHERE email = ?";
        Usuario user = null;

        try (Connection conn = Conexao.getConn();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, email);
            try (ResultSet res = prep.executeQuery()) {
                if (res.next()) {
                    user = new Usuario();
                    user.setId(res.getInt("id"));
                    user.setNome(res.getString("nome"));
                    user.setEmail(res.getString("email"));
                    user.setSenha(res.getString("senha"));
                }
            }
        }
        return user;
    }

    public void updateUser(Usuario user) throws SQLException, ClassNotFoundException {
        String query = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.getConn();
             PreparedStatement prep = conn.prepareStatement(query)) {

            prep.setString(1, user.getNome());
            prep.setString(2, user.getEmail());
            prep.setInt(3, user.getId());
            prep.executeUpdate();
        }
    }
}
