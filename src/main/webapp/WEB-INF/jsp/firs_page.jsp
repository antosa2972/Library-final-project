<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 09.03.2021
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<div class="main-container">
    <nav class="navbar navbar-light">
        <form class="header" action="Controller" method="post">
            <div class="btn-group buttons" role ="grop" aria-label="Basic Example">
                <button class="btn btn-primary sign-in" type="submit" name="command" value="loadauthpage">Sign in</button>
                <button class="btn btn-primary sign-up" type="submit" name = "command" value="loadregpage">Sign up</button>
            </div>
        </form>
    </nav>
</div>
</body>
</html>
