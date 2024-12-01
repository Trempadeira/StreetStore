package controller;

import database.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet("/usuario-controller")
public class UsuarioController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = request.getParameter("pagina");

        if (pagina != null) {
            switch (pagina) {
                case "login":
                    handleLogin(request, response);
                    break;
                case "cadastro":
                    handleCadastro(request, response);
                    break;
                default:
                    response.sendRedirect("index.html?erro=pagina_nao_encontrada");
            }
        } else {
            response.sendRedirect("index.html?erro=pagina_nao_informada");
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            Usuario usuario = new Usuario(email, senha);
            boolean loginValido = usuario.login();

            if (loginValido) {
                response.sendRedirect("inicio.html");
            } else {
                response.sendRedirect("index.html?erro=login");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("index.html?erro=login");
        }
    }

    private void handleCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            Usuario usuario = new Usuario(nome, email, senha);
            UsuarioDAO dao = new UsuarioDAO();
            dao.setNewUser(usuario);
            response.sendRedirect("index.html?sucesso=cadastro");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("index.html?erro=cadastro");
        }
    }
}
