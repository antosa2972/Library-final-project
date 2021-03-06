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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/js_mainpage.js"></script>
</form>
</body>
</html>