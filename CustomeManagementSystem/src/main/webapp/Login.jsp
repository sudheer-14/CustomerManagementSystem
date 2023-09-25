<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loginpage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
 rel="stylesheet" 
 integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
 crossorigin="anonymous">
</head>
<body>
<br> 
<h3 align="center" ><font face="Georgia">Login page</font></h3><br><br>
<form action="validate" method="post">
<div class="row g-3 align-items-center" align="right">
  <div class="col-md-5">
    <label for="inputPassword6" class="col-form-label">Username:</label>
  </div>
  <div class="col-md-2">
    <input type="text" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" name="username">
  </div>
 </div>
<div class="row g-3 align-items-center" align="right">
  <div class="col-md-5">
    <label for="inputPassword6" class="col-form-label">Password:</label>
  </div>
  <div class="col-md-2" >
    <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline" name="password">
  </div>
  <div class="col-auto">
    <span id="passwordHelpInline" class="form-text">
      Must be 8-20 characters long.
    </span>
  </div>
</div ><br>
<div class="col-12" align="center">
    <button type="submit" class="btn btn-primary">Login</button>
  </div>
</form>
</body>
</html>