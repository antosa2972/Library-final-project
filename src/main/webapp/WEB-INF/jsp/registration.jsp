<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 02.03.2021
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div align="center">
    <h1>Регистрация нового пользователя</h1>
    <form action="<%=request.getContextPath()%>/register" method="post">
        <table style="width: 80%">
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><input type="text" name="surname" /></td>
            </tr>
            <tr>
                <td>username</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>email</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td>telephone</td>
                <td><input type="text" name="telephone" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>