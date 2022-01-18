<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateProfileServlet" method="post">
    First Name: <input type="text" name="firstName" size="20"><br>
    Last Name: <input type="text" name="lastName" size="20"><br>
    Contact Details: <input type="number" name="number" size="20"><br>
    UserName: <input type="text" name="userName" size="20"><br>
    Password: <input type="password" name="password" size="20"><br>
    Email: <input type="text" name="email" size= "20"><br>
    <input type="submit" value="updateProfile" />
</form>

</body>
</html>
