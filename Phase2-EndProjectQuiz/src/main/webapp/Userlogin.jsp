<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
display: flex;
justify-content: left;
align-items: left;
height: 100vh;
}
h2 {
text-align: left;
}
form {
text-align: left;
}
input[type="email"],
input[type="password"] {
width: 100%;
padding: 10px;
margin-bottom: 10px;
}
</style>
</head>
<body>
<div align="center">
<h1>Online Quiz Portal</h1>
<h2>User Login</h2>
<form action="userloginServlet" method="post">
Email: <input type="email" name="email"><br>
Password: <input type="password" name="password"><br>
<br>
<input type="submit" value="Login">
</form> <br>
<h3><a href="Index.jsp" class="button">Main</a></h3> 
</div>
</body>
</html>
