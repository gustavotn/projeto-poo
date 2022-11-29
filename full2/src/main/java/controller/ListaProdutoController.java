package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;

import data.DataAdapter;


public class ListaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaProdutoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("FOI CARALHO");
		
		DataAdapter.getCurrent().Connect();

		request.setAttribute("produtos", Product.ListaTodos());
		RequestDispatcher dispatcher = request.getRequestDispatcher("listaProduto.jsp");
		dispatcher.forward(request, response);

	}
}
