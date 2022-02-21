<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta charset="ISO-8859-1">
		<title>SourceMe</title>
		<style type="text/css"><%@include file="/css/allTutorial.css" %></style>
		<style type="text/css"><%@include file="/css/header.css" %></style>
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
		
		<div class="title">
			<h2>Tutorials</h2>
		</div>
		<div class="viewTutorials">
			<c:choose>
				<c:when test="${sessionScope['role'] == 'Admin'}">
					<div class="btn-add-tutorial" onclick="location.href='create'" id="createTutorial">Create Tutorial</div>
				</c:when>
			</c:choose>
			<c:forEach var="tutorial" items="${listTutorials}">
				<!-- Tutorial container -->
				<div class="create-body">
					<div class="container">
						<div>
							<p class="tutorialTitle"><b><c:out value="${tutorial.title}" /></b></p>
							<p style="white-space: pre-line"><c:out value="${tutorial.content}" /></p>
		 					<c:choose>
			 					<c:when test="${sessionScope['role'] == 'Admin'}">
			 						<div class="actionBtn">
			 							<a href="edit?id=<c:out value='${tutorial.id}'/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
										<a href="delete?id=<c:out value='${tutorial.id}' />">Delete</a>
									</div>
		    				</c:when>
								<c:when test="${sessionScope['role'] != 'Admin'}">
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</body>
</html>