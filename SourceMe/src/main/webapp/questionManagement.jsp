<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<style type="text/css"><%@include file="/css/header.css" %></style>
		<style type="text/css"><%@include file="/css/questions.css" %></style>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<meta charset="ISO-8859-1">
		<title>SourceMe</title>
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
		
		<div class="row"> 
			<div class="container">
				<h3 class="text-center">List of Questions!!!!!!!!!!!!!</h3>
				<br>
				<table class="table">
					<tbody>
						<c:forEach var="question" items="${listQuestions}">
							<div class="question-con">
								<div class="label-cont">
									<div>
										<div class="alignment">
											<label><b>Title:</b></label>
											<label><c:out value="${question.title}" /></label>
										</div>
										<div class="alignment">
											<label><b>Question:</b></label>
											<label><c:out value="${question.question}" /></label>
										</div>
										<div class="alignment">
											<label><b>Username:</b></label>
											<label><c:out value="${question.username}" /></label>
										</div>
									</div>
									<div class="linksAndButton">
										<c:choose>
									 		<c:when test="${sessionScope['userName'] == question.username}">
												<div class="align">
													<a href="edit?id=<c:out value='${question.id}' />" name="edit" >Edit</a>
													<img src="<%=request.getContextPath()%>/assets/edit.png" width="20px">
												</div>
												<div class="align">
													<a href="delete?id=<c:out value='${question.id}'/>" name="delete" >Delete</a>
													<img src="<%=request.getContextPath()%>/assets/remove.png" width="20px">
												</div>
								    	</c:when>
											<c:when test="${sessionScope['userName'] != question.username}">
											</c:when>
										</c:choose>
										<div class="align">
											<a href="<%=request.getContextPath()%>/answerServlet/viewAnswer?id=<c:out value='${question.id}'/>">View Answer</a>
											<img src="<%=request.getContextPath()%>/assets/question.png" width="20px">
										</div>
										<form action="bookmarkServlet" method="post" class="align">
											<a href="bookmark?id=<c:out value='${question.id}' />">Add to bookmark</a>
											<img src="<%=request.getContextPath()%>/assets/bookmark (1).png" width="20px">
										</form>
									</div>
								</div>
							</div>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>