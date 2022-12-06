<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>LGC</title>
    <link href="http://localhost:8080/lgc-web/Pages/Home/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="navbar">
        <h1 id="title">LGC</h1>
        <div id="navbar-item">
            <a href="http://localhost:8080/lgc-web/Pages/Home/index.jsp"><p class="item">Home</p></a>
            <a href="#produtos"><p class="item">Produtos</p></a>
            <a href="#quem-somos-title"><p class="item">Quem Somos</p></a>
            <a href="http://localhost:8080/lgc-web/Pages/Login/login.jsp"><p class="item">Sou Fornecedor</p></a>
            <a href="http://localhost:8080/lgc-web/Pages/Produtos/ListaProdutos/listaProduto.jsp"><p class="item">Sou Cliente</p></a>
        </div>        
    </div>

    <div id="container">
        <h2 id="quem-somos-title">Quem Somos</h2>
        <p id="quem-somos">Somos uma plataforma online de vendas para empresas do setor 
            alimentício como restaurantes, lancherias, mercados, etc.
            Nossa missão é conectar você ao seu cliente/consumidor.
            Através da nossa plataforma, você recebe os pedidos dos seus clientes.
            <br><br><br>
            
            <h2 id="produtos"> Alguns produtos</h2>
           <img class="produto" src="http://localhost:8080/lgc-web/Images/client1.png">
           <img class="produto" src="http://localhost:8080/lgc-web/Images/client2.png">
           <img class="produto" src="http://localhost:8080/lgc-web/Images/client3.jpeg">
    </div>

</body>
</html>