<%@page import="database.Conexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Verificação de Conexão</title>
    </head>
    <body>
        <h1>Teste de Conexão com o Banco de Dados</h1>
        <%
            try {
                if (Conexao.getConn() != null) {
                    out.println("<p>Conexão bem-sucedida!</p>");
                } else {
                    out.println("<p>Falha na conexão!</p>");
                }
            } catch (Exception e) {
                out.println("<p>Erro ao conectar: " + e.getMessage() + "</p>");
            }
        %>
    </body>
</html>
