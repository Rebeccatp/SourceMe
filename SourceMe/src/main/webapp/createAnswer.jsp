<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css"><%@include file="/css/header.css" %></style>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/createAnswer.css" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
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


<!-- Create an answer container -->
<div class="create-body">
    <div class="container">
    <div>
        <div class="title">
    		<h2>Reply a comment</h2>
		</div>
    <form class="create-form" action="createAnswer" method="post">
   
    	<!--Question-->  
          <div class="form-row mt-2">
            <div class="col">
                <label class="qns-label">Question</label> 
              	<!-- p class="answer" name="question" id="question">1</p -->
              	<input type="text" class="form-control" name="question" value="${question.question}"  readonly> 
            </div>
          </div> 
          
    			<c:if test="${question != null}">
					<input name="qnsId" type="hidden" value="${question.id}" />
				</c:if>
		
 		<!--Username-->  
          <div class="form-row mt-2">
            <div class="col username">
                <label style="font-size: 18px;">Post By</label> 
				<input type="text" class="form-control" name="postBy" value="${sessionScope['userName']}" readonly>     
			</div>
          </div>
          
          <!--My Answer-->  
          <div class="form-row mt-2">
            <div class="col">
                <label style="font-size: 18px;">My Answer</label> 
              <input type="text" class="form-control" name="answer">
            </div>
          </div>
          
         <!-- Submit button -->
      <div class="btn-all">
          <button type="submit" class="button-submit" id="submitAnswer">Submit Answer</button>
      </div> 
        </form>
    </div>
</div>
      
</div>
</body>
</html>