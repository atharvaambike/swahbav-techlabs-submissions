package com.bank.servlet;

import com.bank.dao.TransactionDAO;
import com.bank.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int fromId = user.getId();
        int toId = Integer.parseInt(request.getParameter("toAccount"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        TransactionDAO dao = new TransactionDAO();
        boolean success = dao.transfer(fromId, toId, amount);

        if (success) {
            response.sendRedirect("passbook.jsp?success=1");
        } else {
            response.sendRedirect("transfer.jsp?error=1");
        }
    }
}
