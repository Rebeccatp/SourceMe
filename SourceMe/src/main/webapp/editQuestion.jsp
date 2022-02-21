<!-- Designing of the page -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css"><%@include file="/css/header.css" %></style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/editQuestion.css" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  
<title>SourceMe</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav col-lg-9">
    <li class="nav-item active">
    <a href="#"><img src="<%=request.getContextPath()%>/assets/logo.png"  width="120px"></a>
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

<nav class="navbar navbar-expand-md navbar-light">
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/questionServlet/questions"
class="nav-link" name="Back">Back to question</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<p>${question }</p>
<%-- <c:if test="${question != null}"> --%>
<form action="update" method="post">
<%-- </c:if> --%>
<%-- <c:if test="${question == null}"> --%>
<!-- <form action="insert" method="post"> -->
<%-- </c:if> --%>
<caption>
<div class="title">
<h2>
<c:if test="${currentQuestion != null}">
Edit
</c:if>
</h2>
</div>
<br>
<br>
</caption>
<c:if test="${currentQuestion != null}">
<div class="alignment">
<input type="hidden" name="oriId" value="${currentQuestion.id}" />
</c:if>
</div>



<div class="alignment">
<fieldset class="form-group">
<input type="text" value='${currentQuestion.username}' class="form-control" name="username" required="required" readonly>
</fieldset>
</div>



<div class="alignment">
<fieldset class="form-group">
<label class="title-label">Title</label>
<input type="text" value='${currentQuestion.title}' class="form-control" name="title">
</fieldset>
</div>
<div class="alignment">
<fieldset class="form-group">
<label class="question-label">Question</label>
<input type="text" value='${currentQuestion.question}' class="form-control" name="question">
</fieldset>
</div>



<div class="save-btn">
<button type="submit" class="btn btn-success" name="save changes">Save changes</button>
</div>



</form>
</div>
</div>
</div>



</body>
</html>