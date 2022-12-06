<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>LGC</title>
    <link href="http://localhost:8080/lgc-web/Pages/Cadastro/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <!-- NAVBAR -->
    <div id="navbar">
        <h1 id="title">LGC - Client1</h1>       
    </div>

    <div id="container">
        <h2>Cadastro</h2>
        <div class="dashboard">
            <input class="option_button" type="button" value="Voltar">
            
            <div class="indicator-container">
                <form action="../../Cadastrar" method="post">
                    <label>Nome</label> <input class="form__input" type="text" name="nome">
                    <label>Descrição</label><input class="form__input" type="text" name="descricao">
                    <label>Preço</label><input class="form__input" type="text" name="preco">

                    <input class="login_button" type="submit" value="Cadastrar">
                </form>
            </div>
                
                
        </div>
    </div>

</body>
</html>