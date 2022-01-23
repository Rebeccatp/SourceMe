<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SourceMe - Update Profile</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/updateProfile.css" crossorigin="anonymous">
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

	<div class="container" style="margin-top:20px">
		<a href="http://localhost:8090/SourceMe/UserServlet/logout" style="float:right"><button class="btn btn-secondary">Logout</button></a>
	</div>
	<div class="container" style="margin-top: 20px">
		<h2>Update Profile</h2>
		<br>
		<form action="update" method="post">
			<table>
				<tr>
					<th>Role: </th>
					<td>
						<select name="role">
							<option>${user.role}</option>
							<option>${user.role == "Admin" ? "User" : "Admin"}</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>First Name: </th>
					<td><input type="text" name="firstName" value="${user.firstName}"></td>
				</tr>
				<tr>
					<th>Last Name: </th>
					<td><input type="text" name="lastName" value="${user.lastName}"></td>
				</tr>
				<tr>
					<th>Contact Details: </th>
					<td><input type="text" name="number" value="${user.number}"></td>
				</tr>
				<tr>
					<th>UserName: </th>
					<td><input type="text" name="userName" value="${user.userName}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>Password: </th>
					<td><input type="password" name="password" value="${user.password}"></td>
				</tr>
				<tr>
					<th>Email: </th>
					<td><input type="text" name="email" value="${user.email}"></td>
				</tr>
			</table>
			<br>
			<input class="button-submit" type="submit" value="Update Profile" />
		</form>
	</div>
	<div class="container" style="margin-top: 40px; margin-bottom: 40px">
		<h2>Delete Account</h2>
		<br>
		<a href="delete?id=${user.id}"><button class="btn btn-danger">Delete Account</button></a>
	</div>

</body>
</html>
