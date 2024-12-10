package controller;

import database.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
        String name = request.getParameter("name");
        String senha = request.getParameter("password");

        try {
            Usuario usuario = new Usuario(name, senha);

            if (usuario.login()) {
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Usuario usuario = new Usuario(name, email, password);
            UsuarioDAO dao = new UsuarioDAO();
            dao.setNewUser(usuario);
            response.sendRedirect("index.html?sucesso=cadastro");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("index.html?erro=cadastro");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if ("listar".equals(acao)) {
            listarUsuarios(request, response);
        } else {
            response.sendRedirect("cadastro.html?erro=acao_nao_encontrada");
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.getAllUsers();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("listarInformacoes.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar usuários.");
        }
    }
}
