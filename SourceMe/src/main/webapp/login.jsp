<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		      		<a id="profileNav" class="nav-link" href="<%=request.getContextPath()%>/UserServlet/edit">${sessionScope['userName']}</a>
		    		</li>
		    	</c:when>
					<c:when test="${sessionScope['userId'] == null}">
		   			<li class="nav-item">
		      		<a id="signinNav" class="nav-link" href="<%=request.getContextPath()%>/UserServlet/loginPage">Sign In</a>
		    		</li>
		      	<li class="nav-item">
		     			<a id="signupNav" class="nav-link" href="<%=request.getContextPath()%>/UserServlet/registerPage">Sign Up</a>
		    		</li>
		    	</c:when>
				</c:choose>
		    <li>
		    	<div class="btn-add-qns">
		    		<a href="<%=request.getContextPath()%>/questionServlet/questionForm" class="add-qn-link" >Add Your Question</a>
		    	</div>
		    </li>
		    <c:choose>
		    	<c:when test="${sessionScope['userId'] != null }">
		    		<li>
		    			<div class="logout-btn">
								<a href="<%=request.getContextPath()%>/UserServlet/logout" style="float:right">
									<button class="btn btn-secondary">Logout</button>
								</a>
							</div>
						</li>
		    	</c:when>
		    </c:choose>
		  </ul>
		</nav>
			
		<div class="container" style="margin-top: 20px;">
			<h2 style="margin-left: 520px">Login</h2>
			<br>
			<form action="login" method="post" style="margin-left: 430px">
				<table>
					<div class="username">
						<tr>
							<th>Username: </th>
							<td><input id="loginUsername" type="text" name="userName" size="20"></td>
						</tr>
					</div>
					<br>
					<div class="password">
						<tr>
							<th>Password: </th>
							<td><input id="loginPassword" type="password" name="password" size="20"></td>
						</tr>
					</div>
				</table>
				<br><br>
				<input id="loginBtn" class="btn btn-primary" type="submit" value="Login" style="margin-left: 110px"/>
			</form>
		</div>
		<br><br><br>
		<p style="margin-left: 520px">
			Do not have an account? 
			<a href="<%=request.getContextPath()%>/UserServlet/registerPage">click here</a>
		</p>
	</body>
</html>