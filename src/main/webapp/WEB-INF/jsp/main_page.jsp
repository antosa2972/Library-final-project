<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <style>
        <%@include file="/WEB-INF/css/style_mainpage.css"%>
    </style>
</head>
<body>
<form action="Controller" method="post">
    <c:choose>
        <c:when test="${sessionScope.auth==null}">
            <div class="sign-in-up">
                <button id="auth" type="submit" name="command" value="loadfirstpage">Sign in/Sign up</button>
            </div>
        </c:when>
        <c:otherwise>
            <div class="username">
                <label>Welcome, ${login.username}</label>
                <button id="logout" type="submit" name="command" value="logout">Log out</button>
            </div>
        </c:otherwise>
    </c:choose>
</form>
</body>
</html>