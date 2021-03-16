<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 09.03.2021
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Authorization</title>
    <style>
        <%@include file="/WEB-INF/css/style_authorization.css" %>
    </style>
</head>
<body>
<form action="Controller" method="get">
    <h1 title="Authorization form">Authorization</h1>
    <div class="group">
        <label for ="">Username:</label>
        <input type="text" name="username">
    </div>
    <div class="group">
        <label for ="">Password:</label>
        <input type="password" name="password">
    </div>
    <div class="group">
        <center><button type="submit" name="command" value="authorization">Sign in</button></center>
    </div>
    <div class="group">
        <c:out value="${message}"/>
    </div>
</form>
</body>
</html>
