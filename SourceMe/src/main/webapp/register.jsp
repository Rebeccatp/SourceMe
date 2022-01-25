<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>SourceMe - Register</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"> </script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>



<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
<ul class="navbar-nav col-lg-9">
<li class="nav-item active">
<a href="#"><img src="<%=request.getContextPath()%>/assets/logo.png" width="120px"></a>
</li>
<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>/home">Home</a>
</li>
<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>/tutorialServlet/dashboard">All Tutorials</a>
</li>
</ul>
<ul class="navbar-nav col-lg-3">
<c:choose>
<c:when test="${sessionScope['userId'] != null}">



<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>/UserServlet/edit">${sessionScope['userName']}</a>
</li>

</c:when>
<c:when test="${sessionScope['userId'] == null}">



<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>/UserServlet/loginPage">Sign In</a>
</li>
<li class="nav-item">
<a class="nav-link" href="<%=request.getContextPath()%>/UserServlet/registerPage">Sign Up</a>
</li>
</c:when>
</c:choose>
<li>



<div class="btn-add-qns"><a href="<%=request.getContextPath()%>/questionServlet/questionForm" class="add-qn-link" >Add Your Question</a></div>
</li>
<c:choose>
<c:when test="${sessionScope['userId'] != null }">
<li>
<div class="logout-btn">
<a href="http://localhost:8090/SourceMe/UserServlet/logout" style="float:right"><button class="btn btn-secondary">Logout</button></a>
</div></li>
</c:when>
</c:choose>

</ul>
</nav>
<div class="container" style="margin-top: 20px">
<h2 style="margin-left: 510px;">Register</h2>
<br>
<br>
<form action="register" method="post" style="margin-left: 410px">
<table>
<div>
<tr>
<th>Role: </th>
<td>
<select name="role">
<option>Admin</option>
<option>User</option>
</select>
</td>
</tr>
</div>



<div class="firstName">
<tr>
<th>First Name: </th>
<td><input type="text" name="firstName" size="20"></td>
</tr>
</div>



<div class="lastName">
<tr>
<th>Last Name: </th>
<td><input type="text" name="lastName" size="20"></td>
</tr>
</div>



<div class="number">
<tr>
<th>Contact Details: </th>
<td><input type="text" name="number" size="20"></td>
</tr>
</div>



<div class="username">
<tr>
<th>Username: </th>
<td><input type="text" name="userName" size="20"></td>
</tr>
</div>



<div class="password">
<tr>
<th>Password: </th>
<td><input type="password" name="password" size="20"></td>
</tr>
</div>



<div class="email">
<tr>
<th>Email: </th>
<td><input type="text" name="email" size="20"></td>
</tr>
</div>



</table>
<br>
<br>
<input class="btn btn-primary" type="submit" value="Register" style="margin-left: 120px"/>
</form>
</div>
<br>
<br>
<br>
<p style="margin-left: 520px">Already have an account? <a href="<%=request.getContextPath()%>/UserServlet/loginPage">Login</a></p>



</body>
</html>