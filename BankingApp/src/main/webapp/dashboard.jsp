<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<html>
<head>
    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h2>Welcome, ${sessionScope.username}</h2>
    <div class="menu">
        <a href="transfer.jsp">Transfer Funds</a> | 
        <a href="PassbookServlet">View Passbook</a> |
        <a href="LogoutServlet">Logout</a>
    </div>
</body>
</html>
