<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head><title>Transfer</title></head>
<body>
<h2>Transfer Money</h2>
<form action="transfer" method="post">
    <label>From Account:</label><input type="text" name="fromAccount" required><br>
    <label>To Account:</label><input type="text" name="toAccount" required><br>
    <label>Amount:</label><input type="number" step="0.01" name="amount" required><br>
    <label>PIN:</label><input type="password" name="pin" required><br>
    <button type="submit">Transfer</button>
</form>
</body>
</html>
