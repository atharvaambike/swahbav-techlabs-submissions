package com.bank.servlet;

import com.bank.dao.UserDAO;
import com.bank.dao.TransactionDAO;
import com.bank.model.User;
import com.bank.model.Transaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User admin = (User) session.getAttribute("user");
        if (!"admin".equals(admin.getRole())) {
            response.sendRedirect("dashboard.jsp");
            return;
        }

        UserDAO userDAO = new UserDAO();
        TransactionDAO txDAO = new TransactionDAO();

        List<User> users = userDAO.getAllUsers();
        List<Transaction> transactions = txDAO.getAllTransactions();

        request.setAttribute("users", users);
        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
