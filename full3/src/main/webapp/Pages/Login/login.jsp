<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>LGC</title>
    <link href="http://localhost:8080/lgc-web/Pages/Login/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="navbar">
        <h1 id="title">LGC</h1>
    </div>

    <div id="container">
        <h2>Login</h2>
        <form action="../../Login" method="post" class="testes">
            <label>Usuário:</label>
            <input class="form__input" type="text" name="user"><br>

            <label>Senha:</label>
            <input class="form__input" type="password" name="pwd">

            <input class="login_button" type="submit" value="Login">
        </form>
    </div>

</body>
</html>