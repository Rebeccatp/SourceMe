<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css" crossorigin="anonymous">
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

<form action="RegisterServlet" method="post" >
    First Name: <input type="text" name="firstName" size="20" style="margin-left: 26px"><br>
    Last Name: <input type="text" name="lastName" size="20" style="margin-left: 27px"><br>
    Contact Details: <input type="number" name="number" size="20"><br>
    UserName: <input type="text" name="userName" size="20" style="margin-left: 27px"><br>
    Password: <input type="password" name="password" size="20" style="margin-left: 32px"><br>
    Email: <input type="text" name="email" size= "20" style="margin-left: 58px"><br>
    <input type="submit" value="Register" />
</form>

 
</body>
</html>
