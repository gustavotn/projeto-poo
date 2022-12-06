package servlet;

import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cadastrar")
public class CadastrarController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        double preco = Double.parseDouble(req.getParameter("preco"));

        Product product = new Product();

        product.setName(nome);
        product.setDescription(descricao);
        product.setPrice(preco);

        product.Grava();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Dashboard");

        dispatcher.forward(req, resp);
    }
}
