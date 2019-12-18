package demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.LoginDAO;

@WebServlet("/Login")
public class LoginController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String un = request.getParameter("username");
        String pw = request.getParameter("password");

        if (LoginDAO.isCorrect(un, pw)) {
            response.sendRedirect("HomeView.jsp");
            return;
        } else {
            request.setAttribute("message", "Sai tai khoan");
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
