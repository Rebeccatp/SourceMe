<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
<style type="text/css"><%@include file="/css/allTutorial.css" %></style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!-- NAV BAR -->
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
      <a class="nav-link" href="tutorialServlet">All Tutorials</a>
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
    <div class="btn-add-qns">Add Your Question</div>
    </li>
  </ul>  
</nav>
<div class="title">
	<h2>Tutorials</h2>
</div>
<div>
<div class="btn-add-tutorial" onclick="location.href='create'">Create Tutorial</div>
<c:forEach var="tutorial" items="${listTutorials}">
<!-- Tutorial container -->
<div class="create-body">
	<div class="container">
		<div>
<!-- For each user in the database, display their
information accordingly -->
<p class="tutorialTitle"><b><c:out value="${tutorial.title}" /></b></p>
<p style="white-space: pre-line"><c:out value="${tutorial.content}" /></p>
<div class="actionBtn"><a href="edit?id=<c:out value='${tutorial.id}'/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?id=<c:out value='${tutorial.id}' />">Delete</a></div>
		</div>
	</div>
</div>
</c:forEach>
</div>
</body>
</html>