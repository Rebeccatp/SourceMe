<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SourceMe - Login</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" crossorigin="anonymous">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	  <ul class="navbar-nav col-lg-9">
	    <li class="nav-item active">
	    <img src="<%=request.getContextPath()%>/assets/logo.png" width="120px">
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="#">Home</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="#">All Questions</a>
	    </li>
	         <li class="nav-item">
	      <a class="nav-link" href="#">All Tutorials</a>
	    </li>
	  </ul>
	  <ul class="navbar-nav col-lg-3">
	  	<li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/register.jsp">Register</a>
	    </li>
	        <li class="nav-item">
	      <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Login</a>
	    </li>
	    <li>
	    <div class="btn-add-qns">Add Your Question</div>
	    </li>
	  </ul>
	</nav>
	
	<div class="container" style="margin-top: 20px">
		<h2>Login</h2>
		<br>
		<form action="LoginServlet" method="post">
			<table>
				<tr>
					<th>UserName: </th>
					<td><input type="text" name="userName" size="20"></td>
				</tr>
				<tr>
					<th>Password: </th>
					<td><input type="password" name="password" size="20"></td>
				</tr>
			</table>
			<br>
			<input class="btn btn-primary" type="submit" value="Login" />
	    </form>
	</div>

</body>
</html>

