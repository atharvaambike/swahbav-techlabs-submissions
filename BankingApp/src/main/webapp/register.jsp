<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" href="style.css">
<body>
<h2>User Registration</h2>
<form action="register" method="post">
    <label>Username:</label><input type="text" name="username" required><br>
    <label>Password:</label><input type="password" name="password" required><br>
    <label>PIN (6 digits):</label><input type="password" name="pin" maxlength="6" required><br>
    <button type="submit">Register</button>
</form>
</body>
</html>
