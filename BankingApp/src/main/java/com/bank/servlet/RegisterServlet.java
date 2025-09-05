package com.bank.servlet;

import com.bank.dao.UserDAO;
import com.bank.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "customer";
        String pin = request.getParameter("pin"); // pin comes from form

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        UserDAO dao = new UserDAO();
        boolean success = dao.registerUser(user, pin);

        if (success) {
            response.sendRedirect("login.jsp?registered=1");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }
}
