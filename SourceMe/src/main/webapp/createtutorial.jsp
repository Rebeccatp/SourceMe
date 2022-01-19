<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/createtutorial.css" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
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
	      <a class="nav-link" href="<%=request.getContextPath()%>/tutorial.jsp">All Tutorials</a>
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
					<h2>Create Tutorial</h2>
				</div>
				<form class="create-form" action="createTutorial" method="post">
					<!--Title-->
					<div class="form-row mt-2">
						<div class="col">
							<label class="title-label">Title</label>
							<p class="input-Title"><input type="text" name="title" class="form-control"></p>
						</div>
					</div>
					<!--Content-->
					<div class="form-row mt-2">
						<div class="col">
							<label class="tutorial-label">Content</label>
							<textarea name="content" rows="5" class="form-control" id="tutorial"></textarea>
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