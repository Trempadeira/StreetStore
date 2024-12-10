<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.UsuarioDAO"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/cadastro.css">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <title>Street Store</title>
</head>
<body>
    <%
    UsuarioDAO usuarioDAO = new UsuarioDAO(); 
    ArrayList<Usuario> list = usuarioDAO.getAllUsers();
    for (Usuario u : list) { 
%>
    <div class="container">
        <div class="curved-shape"></div>
        <div class="curved-shape2"></div>
        
        <div class="form-box informacoes">
            <h2 class="animation" style="--D:0; --S:21;">Informa��es</h2>

            <form action="#">
                <div class="input-box animation" style="--D:1; --S:22;">
                    <input type="text" name="name" disabled>
                    <label for="informacoes-name"><%= u.getName() %></label>
                    <i class="bx bxs-user"></i>
                </div>
                <div class="input-box animation" style="--D:2; --S:23;">
                    <input type="text" name="email" disabled>
                    <label for="informacoes-email"><%= u.getEmail() %></label>
                    <i class="bx bxs-envelope"></i>
                </div>
                <div class="input-box animation" style="--D:3; --S:24;">
                    <input type="text" name="password" disabled>
                    <label for="informacoes-password">******</label>
                    <i class="bx bxs-lock-alt"></i>
                </div>
                <div class="input-box animation" style="--D:4; --S:25;">
                    <input type="text" name="city" disabled>
                    <label for="informacoes-city"><%= u.getCity() %></label>
                    <i class="bx bxs-map"></i>
                </div>
                <div class="input-box animation" style="--D:5; --S:26;">
                    <input type="text" name="number" disabled>
                    <label for="informacoes-number"><%= u.getNumber() %></label>
                    <i class="bx bxs-map"></i>
                </div>
                <div class="input-box animation" style="--D:6; --S:27;">
                    <input type="text" name="neighborhood" disabled>
                    <label for="informacoes-neighborhood"><%= u.getNeighborhood() %></label>
                    <i class="bx bxs-map"></i>
                </div>
                <div class="input-box animation" style="--D:7; --S:28;">
                    <input type="text" name="phone" disabled>
                    <label for="informacoes-phone"><%= u.getPhone_number() %></label>
                    <i class="bx bxs-phone"></i>
                </div>

            <!-- Bot�o de cancelar -->
            <form>
                <div class="input-box animation" style="--D:8; --S:29;">
                    <button class="btn" type="submit" formaction="inicio.html">CANCELAR</button>
                </div>
            </form>

        </div>
    </div>

            </form>
            <div class="regi-link animation" style="--D:9; --S:30;">
                <p>ALGO ESTA ERRADO? <a href="#" class="SignUp">ALTERE AQUI</a></p>
            </div>
        </div>

        <div class="info-content informacoes">    
            <h2 class="animation" style="--D:0; --S:20;">VOCÊ SABIA?</h2>
            <p class="animation" style="--D:1; --S:21;">A moda é arte. Arte no sentido de que, quando inspirada, possui uma intenção real de comunicar. Você não precisa de palavras para passar uma sensação, entende? O que você veste pode fazer isso por você</p>
        </div>

        <div class="form-box alterar">
            <h2 class="animation" style="--li:17; --S:0;">Registre-se</h2>
            <form action="#">
                <div class="input-box animation" style="--li:18; --S:1;">
                    <input type="text" id="name" required>
                    <label for="register-name">NOME</label>
                    <i class="bx bxs-user"></i>
                </div>
                <form action="#">
                    <div class="input-box animation" style="--li:19; --S:2;">
                        <input type="email" id="email" required>
                        <label for="register-email">E-MAIL</label>
                        <i class="bx bxs-envelope"></i>
                    </div>
                <div class="input-box animation" style="--li:20; --S:3;">
                    <input type="password" id="password" required>
                    <label for="register-password">SENHA</label>
                    <i class="bx bxs-lock-alt"></i>
                </div>
                <form action="#">
                    <div class="input-box animation" style="--li:21; --S:4;">
                        <input type="text" id="city" required>
                        <label for="register-city">ENDEREÇO</label>
                        <i class="bx bxs-user"></i>
                    </div>
                    <form action="#">
                        <div class="input-box animation" style="--li:22; --S:5;">
                            <input type="email" id="number" required>
                            <label for="register-NUMBER">NUMERO</label>
                            <i class="bx bxs-envelope"></i>
                        </div>
                    <div class="input-box animation" style="--li:23; --S:6;">
                        <input type="password" id="neighborhood" required>
                        <label for="register-neighborhood">BAIRRO</label>
                        <i class="bx bxs-lock-alt"></i>
                    </div>
                    <form action="#">
                        <div class="input-box animation" style="--li:24; --S:7;">
                            <input type="text" id="phone" required>
                            <label for="register-phone">TELEFONE</label>
                            <i class="bx bxs-user"></i>
                        </div>
                <div class="input-box animation" style="--li:25; --S:8;">
                    <button class="btn" type="submit">ALTERAR</button>
                </div>
                <div class="regi-link animation" style="--li:26; --S:9;">
                    <p>NÃO QUER FAZER NENHUMA MUDANÇA?? <a href="#" class="SignIn">CANCELE AQUI</a></p>
                </div>
            </form>
        </div>
 
        <div class="info-content alterar">
            <h2 class="animation" style="--li:17; --S:0;">VOCÊ SABIA?</h2>
            <p class="animation" style="--li:18; --S:1;">Fundada em 1918, Rio Tinto tem a aparência de uma cidade europeia mas fica na Paraíba, a cerca de 70 quilômetros de João Pessoa.</p>
        </div>
    </div>
    <script src="js/index.js"></script>
</body>
</html>
