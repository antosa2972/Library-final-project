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
    <title>Library-Sign in</title>
    <style>
        <%@include file="/WEB-INF/css/style_firstpage.css"%>
    </style>

</head>
<body>
<form action="Controller" method="post">
    <div class="langBut">
        <button>Russian</button>
        <button>English</button>
    </div>
    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign
            In</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
            <div class="login-form">
                <div class="sign-in-htm">
                    <div class="group">
                        <label for="username" class="label">Username</label>
                        <input id="username" type="text" class="input" name="username">
                    </div>
                    <div class="group">
                        <label for="password" class="label">Password</label>
                        <input id="password" type="password" class="input" data-type="password" name="password">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" checked>
                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                    </div>
                    <div class="group">
                        <input type="submit" name="command" class="button" value="authorization">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="#forgot">Forgot Password?</a>
                    </div>
                </div>
                <div class="sign-up-htm">
                    <div class="group">
                        <label for="username" class="label">Username</label>
                        <input id="username_reg" type="text" class="input" name="username_reg">
                    </div>
                    <div class="group">
                        <label for="password" class="label">Password</label>
                        <input id="password_reg" type="password" class="input" data-type="password" name="password_reg">
                    </div>
                    <div class="group">
                        <label for="password_confirm" class="label">Repeat Password</label>
                        <input id="password_confirm" type="password" class="input" data-type="password"
                               name="password_confirm" onkeyup="valid(event)">
                    </div>
                    <div class="group">
                        <label for="email" class="label">Email Address</label>
                        <input id="email" type="text" class="input" name="email">
                    </div>
                    <div class="group">
                        <label for="telephone" class="label">Telephone number</label>
                        <input id="telephone" type="tel" class="input" name="telephone">
                    </div>
                    <div class="group">
                        <label for="name" class="label">Name</label>
                        <input id="name" type="text" class="input" name="name">
                    </div>
                    <div class="group">
                        <label for="surname" class="label">Surname</label>
                        <input id="surname" type="text" class="input" name="surname">
                    </div>
                    <div class="group">
                        <input type="submit" class="button" name="command" value="registration">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a><label for="tab-1">Already Member?</label></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/js_firstpage.js">
    </script>
</form>
</body>
</html>
