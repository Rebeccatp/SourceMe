<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/createtutorial.css" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	      <a class="nav-link" href="dashboard">All Tutorials</a>
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
	<!-- Create an tutorial container -->
	<div class="create-body">
		<div class="container">
			<div>
				<div class="title">
					<h2>Edit Tutorial</h2>
				</div>
				<form class="create-form" action="update" method="post">
					<!--Title-->
					<div class="form-row mt-2">
						<div class="col">
							<label class="title-label">Title</label>
							<c:if test="${tutorial != null}">
<input name="id"  type="hidden" value="<c:out 
value='${tutorial.id}' />" />
</c:if>
							<p class="input-Title"><input type="text" name="title" class="form-control" value="<c:out value='${tutorial.title}' />"></p>
						</div>
					</div>
					<!--Content-->
					<div class="form-row mt-2">
						<div class="col">
							<label class="tutorial-label">Content</label>
							<textarea name="content" rows="5" class="form-control" id="tutorial"> <c:out value='${tutorial.content}' /></textarea>
						</div>
					</div>
					<div class="submit-btn">
						<button type="submit" class="button-submit" id="submitAnswer">Submit Tutorial</button>
					</div>	
				</form>
			</div>
		</div>
	</div>
</body>
</html>