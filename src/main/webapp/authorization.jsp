<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 03.03.2021
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<form method="post" action="AuthorizationServlet" name="AuthorizationForm" onsubmit="return validate();">

    Username :<input type="text" name="username_txt">
    Password :<input type="password" name="password_txt">

    <input type="submit" name="login_button" value="LOGIN">
    <h3>You don't have an account? <a href="${pageContext.request.contextPath}/registration.jsp">Register</a> </h3>
</form>
</html>
