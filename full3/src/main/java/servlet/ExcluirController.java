package servlet;

import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Excluir")
public class ExcluirController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Product product = new Product(Integer.parseInt(id));

        product.Excluir();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/Dashboard");

        dispatcher.forward(req, resp);
    }
}
