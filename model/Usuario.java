package model;

import database.UsuarioDAO;
import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;

public class Usuario {
    private int id;
    private String name;
    private String email;
    private String password;
    private String city;
    private String phone_number;
    private String neighborhood;

    public Usuario() {}

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password; 
    }

    public Usuario(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Usuario(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login() throws ClassNotFoundException, SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.getOneUserByEmail(this.email);

        if (usuario != null && usuario.getPassword().equals(DigestUtils.sha1Hex(this.password))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + '}';
    }
}
