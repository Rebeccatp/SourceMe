<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SourceMe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
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

<!-- Create an answer container -->
<div class="create-body">
    <div class="container">
    <div>
        <div class="title">
    		<h2>Reply a comment</h2>
		</div>
    <form class="create-form" action="createAnswerServlet" method="post">
   
    	<!--Question-->  
          <div class="form-row mt-2">
            <div class="col">
                <label class="qns-label">Question</label> 
              	<!-- <p class="answer" name="question" id="question">1</p> -->
              	<input type="text" class="form-control" name="question">
            </div>
          </div>
          
    	
 		<!--Username-->  
          <div class="form-row mt-2">
            <div class="col username">
                <label style="font-size: 18px;">Username</label> 
              	<!-- <p class="answer" name="username" id="username">jaslynylh</p> -->
              	<input type="text" class="form-control" name="username">
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