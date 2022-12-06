<%@ page import="model.Product" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>LGC</title>
    <link href="http://localhost:8080/lgc-web/Pages/Dashboard/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <!-- NAVBAR -->
    <div id="navbar">
        <h1 id="title">LGC - Client1</h1>       
    </div>

    <div id="container">
        <h2>Dashboard</h2>
        <div class="dashboard">

                <button class="option_button" type="button" value="NovoProduto"><a href="http://localhost:8080/lgc-web/Pages/Cadastro/cadastro.jsp">Novo Produto</a></button>

                <div class="indicator-container">
                <div class="label"><p class="title-indicator">Produtos Cadastrados</p><p class="indicator"><% out.print(Product.Cadastrados()); %></p></div>
                <div class="label"><p class="title-indicator">Valor Vendas/mês</p><p class="indicator">R$ 0,00.</p></div>
                <div class="label"><p class="title-indicator">Qtd Vendas</p><p class="indicator">0</p></div>
                </div>
                
                
        </div>


        <h2>Seus Produtos</h2>

        <table>
            <thead>
                <tr>
                    <td class="nome">Produto</td>
                    <td class="nome">Descrição</td>
                    <td class="nome">Preço</td>
                    <td class="nome">Excluir</td>
                </tr>
            </thead>
            <tbody>
            <%if(request.getAttribute("produtos") != null){
                List<?> produtos = (List<?>)request.getAttribute("produtos");
                for(int contador = 0; contador <(produtos.size()); contador++){
                    Product product = (Product) produtos.get(contador);%>
                <tr>
                    <td><% out.print(product.getName());%></td>
                    <td><% out.print(product.getDescription());%></td>
                    <td><% out.print(product.getPrice());%></td>
                    <td>
                        <form method="post" action="/lgc-web/Excluir">
                            <input type="hidden" value="<%out.print(product.getCode());%>" name="id">
                            <input type="submit" value="Excluir" name="excluir">
                        </form>
                    </td>
                </tr>
            <%}}%>
            </tbody>
        </table>
    </div>
</body>
</html>