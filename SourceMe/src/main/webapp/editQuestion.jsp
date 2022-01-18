<!-- Designing of the page -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/questions.css" crossorigin="anonymous">
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
    <div class="btn-add-qns">Add Your Question</div>
    </li>
  </ul>
     
  
</nav>

<!-- Create an answer container -->
<div class="create-body">
<div class="container">
<div>
<div class="title">
<h2>Edit my question</h2>
</div>
<form class="create-form" action="questions" method="post">
<!--Remarks-->
<div class="form-row mt-2">
<div class="col">
<input type="text" name="username" class="form-control" id="editText">
<label class="title-label">Edit my title</label>
<input type="text" name="title" class="form-control" id="editText">
</div>
</div>



<!--Remarks-->
<div class="form-row mt-2">
<div class="col">
<label class="question-label">Edit my question</label>
<input type="text" name="question" class="form-control" id="editText">
</div>
</div>

<div class="submit-btn">
<button type="submit" class="button-submit" id="submitQuestion">Save changes</button>
</div>

</form>
</div>

</div>

</div>
</body>
</html>