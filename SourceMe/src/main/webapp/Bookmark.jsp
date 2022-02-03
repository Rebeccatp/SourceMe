<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bookmark.css" crossorigin="anonymous">
<style type="text/css">
  <%@include file="/css/questions.css" %>
</style>
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
    <img src="<%=request.getContextPath()%>/assets/logo.png" width="120px">
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">All Tutorials</a>
    </li>
  </ul>
  <ul class="navbar-nav col-lg-3">
   <li class="nav-item">
      <a class="nav-link" href="#">Sign In</a>
    </li>
        <li class="nav-item">
      <a class="nav-link" href="#">Sign Up</a>
    </li>
    <li>
    <div class="btn-add-qns"><a href="<%=request.getContextPath()%>/questions.jsp" class="add-qn-link" >Add Your Question</a></div>
    </li>
  </ul>
</nav>

<div class="row"> 
<div class="container">
<h3 class="text-center">Bookmark</h3>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<!-- Pass in the list of users receive via the Servlet’s response to a loop 
-->
<tbody>
<c:forEach var="question" items="${myBookmark}">
<div class="question-con">
	
	<!-- For each user in the database, display their 
	information accordingly -->
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
		<div div class="align">
			<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete/view answer functions -->
			<div class="align"><a href="delete?id=<c:out value='${question.id}' />">Delete</a></div>
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