<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
<style type="text/css"><%@include file="/css/retrieveAnswers.css" %></style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

<div>
    <div class="btn-add-answer" onclick="location.href='<%=request.getContextPath()%>/answerServlet/addAnswer?qnsId=<c:out
		value='${question.id}'/>'">Add Your Answer</div>
		<!-- Question -->
		<div class="question-con">
			
			<!-- For each user in the database, display their 
			information accordingly -->
			<div class="label-cont">
			
				
				<div>
					<div class="alignment">
						<label>Title:</label>
						<input type="text" class="form-control" name="title" value="<c:out value='${question.title}' />"  readonly> 
					</div>
					
					<div class="alignment">
						<label>Question:</label> 
						<input type="text" class="form-control" name="question" value="<c:out value='${question.question}' />"  readonly> 
					</div>
					
					<div class="alignment">
						<label>Post By:</label>
		<input type="text" class="form-control" name="username" value="<c:out value='${question.username}' />"  readonly> 			</div>
				</div>
			</div>
			
			
		</div>
		
		<!-- Answer -->
		<label class="comment-header">Comments:</label> 			
		<div class="answer-con">
			
			<!-- For each user in the database, display their 
			information accordingly -->
						 <c:forEach items="${answerList}" var="answer">
						 <c:choose>
						 <c:when test="${question.id == answer.qnsId}">
						 
							<div class="answer-div">
								<div class="align"><p>${answer.answers}</p></div>
								<div class="edit-delete">
									<div class="align"><a href="/SourceMe/answerServlet/editAnswer?id=<c:out value='${answer.id}'/>">Edit</a></div>
									<div class="align"><a href="/SourceMe/answerServlet/deleteAnswer?id=<c:out value='${answer.id}'/>">Delete</a></div>
								</div>
							</div>
							</c:when>
							</c:choose>
						</c:forEach>	 
			
		</div>
		
	   
</div>

</body>
</html>