<%@page import="model.Product" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LGC</title>
    <link href="style/style.css" rel="stylesheet" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Rajdhani:wght@300&display=swap" rel="stylesheet">
</head>
<body>
    <div id="navbar">
        <h1 id="title">LGC</h1>
        <div id="navbar-item">
            <p class="item">Home</p>
            <p class="item">Produtos</p>
            <p class="item">Sobre</p>
        </div>        
    </div>

    <div id="container">
        <h2>Produtos</h2>
       <form action="lista" method="post" class="testes">
            
			<input id="bananaButton" type="submit" name="listar"
						value="Consultar Produto">
			<div id="product-view">
			<%if (true){
				if(request.getAttribute("produtos") != null){
					List<?> produtos = (List<?>)request.getAttribute("produtos");
					for(int contador = 0; contador <(produtos.size()); contador++){
						Product product = (Product) produtos.get(contador);%>
	           <div class="product">
	               <p class="prod-name"><% out.print(product.getName()); %></p>
	               <img src="images/hamburguer.png">
	               <p class="prod-description"><% out.print(product.getDescription()); %></p>
	           </div>
	        <%}}}%>
        	</div>
        </form>
    </div>
</body>
</html>