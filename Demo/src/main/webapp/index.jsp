<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>

<h2>Enter Your Name</h2>

<form action="HelloServlet" method="post">
	Name: <input type="text" name="name">
	<input type="submit" value="Submit">
</form>

</body>
</html>