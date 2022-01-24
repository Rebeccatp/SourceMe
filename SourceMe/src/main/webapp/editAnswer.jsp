<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
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
    <a href="<%=request.getContextPath()%>/home.jsp"><img src="<%=request.getContextPath()%>/assets/logo.png"  width="120px"></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/home.jsp">Home</a>
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


<!-- Create an answer container -->
<div class="create-body">
    <div class="container">
    <div>
        <div class="title">
    		<h2>Edit a comment</h2>
		</div>
    <form class="create-form" action="updateAnswer" method="post">
    	<!-- Answer Id -->
    	<c:if test="${answer != null}">
				<input type="hidden" name="id" value="<c:out
				value='${answer.id}' />" />
		</c:if>
        <c:if test="${answer != null}">
				<input type="hidden" name="ansId" value="<c:out
				value='${answer.id}' />" />
		</c:if>
        <!-- Question Id -->
        <c:if test="${answer != null}">
				<input type="hidden" name="qnsId" value="<c:out
				value='${answer.qnsId}' />" />
		</c:if>
		<!-- Post By -->
		<c:if test="${answer != null}">
				<input type="hidden" name="postBy" value="<c:out
				value='${answer.postBy}' />" />
		</c:if>
		
		
          <!--My Answer-->
          <div class="form-row mt-2">
            <div class="col">
                <label style="font-size: 18px;">My Answer</label> 
              <input type="text" class="form-control" name="answer" value="${answer.answers}">
            </div>
          </div>	 

							
          
         <!-- Submit button -->
      <div class="btn-all">
          <button type="submit" class="button-submit" id="editAnswer">Edit Answer</button>
      </div> 
        </form>
    </div>
</div>
      
</div>



</body>
</html>