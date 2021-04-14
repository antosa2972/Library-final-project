<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Antonio
  Date: 08.04.2021
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalog page</title>
    <style><%@include file="/WEB-INF/css/style_mainpage.css"%></style>
</head>
<body>
<form action="Controller" method="post">
    <c:choose>
        <c:when test="${sessionScope.auth==null}">
            <div class="top-bar">
                <button onclick="confirm(event)" class="button" id="my_lib" type="submit" name="command"
                        value="loadfirstpage">My books
                </button>
                <button class="button" id="catalog" type="submit" name="command" value="showbooks">Catalog</button>
                <button class="button" id="reviews" type="submit" name="command" value="loadreviews">Reviews about us
                </button>
                <button class="button" id="contacts" type="submit" name="command" value="loadcontactpage">Contacts
                </button>
            </div>
            <div class="sign-in-up">
                <button id="auth" type="submit" name="command" value="loadfirstpage">Sign in/Sign up</button>
            </div>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${sessionScope.isAdmin==false}">
                    <div class="top-bar">
                        <button class="button" id="my_lib" type="submit" name="command" value="loadfirstpage">My books
                        </button>
                        <button class="button" id="catalog" type="submit" name="command" value="showbooks">Catalog</button>
                        <button class="button" id="reviews" type="submit" name="command" value="loadreviews">Reviews
                            about us
                        </button>
                        <button class="button" id="contacts" type="submit" name="command" value="loadcontactpage">
                            Contacts
                        </button>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="top-bar">
                        <button class="button" id="add_book" type="submit" name="command" value="loadaddingbookpage">Add book</button>
                        <button class="button" id="change_users" type="submit" name="command" value="">Change users</button>
                        <button class="button" id="show_debtors" type="submit" name="command" value="">Show debtors</button>
                        <button class="button" id="add_new_admin" type="submit" name="command" value="loadreviews">Add new admin</button>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="username">
                <label>Welcome, ${login.username}</label>
                <button id="logout" type="submit" name="command" value="logout">Log out</button>
            </div>
        </c:otherwise>
    </c:choose>
    <table border="2" align="center" width="80%" cellspacing="0">
        <tr>
            <th>Book name</th>
            <th>Author</th>
            <th>Genre</th>
            <th>Publishing office</th>
            <th>Rating</th>
            <th>Prod year</th>
            <th>ISBN</th>
        </tr>
        <c:forEach items="${list}" var="book">
            <tr>
                <td>${book.getB_name()}</td>
                <td>${book.getAuthor_id()}</td>
                <td>${book.getGenres_id()}</td>
                <td>${book.getId_pulb_office()}</td>
                <td>${book.getRating()}</td>
                <td>${book.getProd_year()}</td>
                <td>${book.getB_isbn()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
