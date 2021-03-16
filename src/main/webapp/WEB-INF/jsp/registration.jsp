<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 09.03.2021
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        <%@include file="/WEB-INF/css/style_registration.css" %>
    </style>
</head>
<body>
<form action="Controller" method="post">
    <h1 title="Registration form">Registration</h1>
    <div class="group">
        <label for ="">Username:</label>
        <input type="text" name="username">
    </div>
    <div class="group">
        <label for ="">Password:</label>
        <input type="password" name="password">
    </div>
    <div class="group">
        <label for ="">Confirm Password:</label>
        <input type="password">
    </div>
    <div class="group">
        <label for ="">Telephone number:</label>
        <input type="tel" name="telephone">
    </div>
    <div class="group">
        <label for ="">Email:</label>
        <input type="email" name="email">
    </div>
    <div class="group">
        <label for ="">Your Name:</label>
        <input type="text" name="name">
    </div>
    <div class="group">
        <label for ="">Your Surname:</label>
        <input type="text" name="surname">
    </div>
    <div class="group">
        <center><button type="submit" name="command" value="registration">Registration</button></center>
    </div>
    <div class="group">
        <c:out value="${message}"/>
    </div>
</form>
</body>
</html>
