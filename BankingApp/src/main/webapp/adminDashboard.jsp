<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Passbook</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h2>Your Transaction History</h2>
    <table border="1">
        <tr>
            <th>Date</th>
            <th>Type</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="txn" items="${transactions}">
            <tr>
                <td>${txn.date}</td>
                <td>${txn.type}</td>
                <td>${txn.amount}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="dashboard.jsp">Back</a>
</body>
</html>
