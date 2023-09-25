<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.mainproject.model.User" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Userform</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
 rel="stylesheet"
  integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
 crossorigin="anonymous">
</head>
<body>
<c:if test="${list==null}">
<form action="insert" method="post">
</c:if>
<c:if test="${list!=null}">
<form action="update" method="post">
</c:if>
<h2 align="center">
<c:if test="${list==null}">
ADD CUSTOMER</c:if>
<c:if test="${list!=null}">
EDIT CUSTOMER</c:if>
</h2>
<br><br>
<div class="row g-3 align-items-center" align="right">
  <div class="col-md-2">
    <input type="hidden" id="name" class="form-control" aria-describedby="passwordHelpInline" name="id" value="${list.id}">
  </div>
 </div>
<div class="row g-3 align-items-center" align="right">
  <div class="col-md-5">
    <label for="name" class="col-form-label">NAME:</label>
  </div>
  <div class="col-md-2">
    <input type="text" id="name" class="form-control" aria-describedby="passwordHelpInline" name="name" value="${list.name}">
  </div>
 </div>
 <br>
 <div class="row g-3 align-items-center" align="right">
  <div class="col-md-5">
    <label for="name" class="col-form-label">EMAIL:</label>
  </div>
  <div class="col-md-2">
    <input type="text" id="name" class="form-control" aria-describedby="passwordHelpInline" name="email" value="${list.email}">
  </div>
 </div><br>
 <div class="row g-3 align-items-center" align="right">
  <div class="col-md-5">
    <label for="name" class="col-form-label">CITY:</label>
  </div>
  <div class="col-md-2">
    <input type="text" id="name" class="form-control" aria-describedby="passwordHelpInline" name="city" value="${list.city}">
  </div>
 </div><br>
 <div class="col-11" align="center">
    <button type="submit" class="btn btn-primary">ADD</button>
  </div>
 
</body>
</html>