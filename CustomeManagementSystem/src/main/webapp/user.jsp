<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="u" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerManagementpage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
crossorigin="anonymous">
</head>
<body>
<form action="userlist" method="post">
<nav class="navbar bg-primary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" >CUSTOMER MANAGEMENT SYSTEM</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="user">Customers</a>
        </li></ul>
        </div>
</nav>
<h3 align="center">CUSTOMER MANAGEMENT SYSTEM</h3>
<hr>
<a class="btn btn-primary btn-sm" href="userform">Add Customer</a><hr>
<table class="table table-striped table-hover">
 <tr>
 <th>ID</th>
 <th>NAME</th><th>EMAIL</th><th>CITY</th><th>ACTION</th>
 </tr>
 <u:forEach var="user" items="${display}">
 <tr>
 <td><u:out value="${user.id }"/></td>
 <td><u:out value="${user.name }"/></td>
 <td><u:out value="${user.email }"/></td>
 <td><u:out value="${user.city }"/></td>
 <td><a href="delete?id=${user.id}" >Delete</a>|<a href="edit?id=${user.id}" >Edit</a></td>
 </tr>
 </u:forEach>
</table></form>
</body>
</html>