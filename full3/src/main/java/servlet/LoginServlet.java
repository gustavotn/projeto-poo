package servlet;

import data.DataAdapter;
import model.Product;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Login", "/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userStr = req.getParameter("user");
        String passSrt = req.getParameter("pwd");

        ArrayList<User> users = User.ListaTodos();

        boolean bRet = false;

        for (User user: users) {
            if (userStr.equals(user.getName()) && passSrt.equals(user.getPassword()))
            {
                bRet = true;

                req.setAttribute("valido", bRet);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/Dashboard");

                dispatcher.forward(req, resp);
            }
        }

        if (!bRet)
        {
            req.setAttribute("valido", bRet);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/Pages/Login/login.jsp");

            dispatcher.forward(req, resp);
        }

    }
}
