<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 07.04.2021
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Book</title>
    <style><%@include file="/WEB-INF/css/style_adding.css"%></style>
</head>
<body>
<h1>Add new book</h1>
<form action="Controller" method="post">
    <div class="add_book">
        <div class="group">
            <label for="book_name" class="label">Book name:</label>
            <input id="book_name" type="text" class="input" name="book_name">
        </div>
        <div class="group">
            <label for="author_name" class="label">Author name:</label>
            <input id="author_name" type="text" class="input" name="author_name">
        </div>
        <div class="group">
            <label for="genre" class="label">Genre:</label>
            <input id="genre" type="text" class="input" name="genre">
        </div>
        <div class="group">
            <label for="publ" class="label">Publication office:</label>
            <input id="publ" type="text" class="input" name="publ">
        </div>
        <div class="group">
            <label for="rating" class="label">Rating:</label>
            <input id="rating" type="text" class="input" name="rating">
        </div>
        <div class="group">
            <label for="isbn" class="label">Publication office:</label>
            <input id="isbn" type="text" class="input" name="isbn">
        </div>
    </div>
</form>
</body>
</html>
