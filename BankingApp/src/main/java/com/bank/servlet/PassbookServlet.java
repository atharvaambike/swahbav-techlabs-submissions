package com.bank.servlet;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;
import com.bank.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/passbook")
public class PassbookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        TransactionDAO dao = new TransactionDAO();
        List<Transaction> transactions = dao.getTransactionsByUser(user.getId());

        request.setAttribute("transactions", transactions);
        request.getRequestDispatcher("passbook.jsp").forward(request, response);
    }
}
