<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <title>Profile - PayMyBuddy</title>
</head>
<body>
<header>
    <h1>Pay My Buddy</h1>
</header>
<nav>
    <ul>
        <li><a href="<c:url value="/home"/>">Home</a></li>
        <li><a href="<c:url value="/transfer"/>">Transfer</a></li>
        <li><a href="<c:url value="/profile"/>">Profile</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="<c:url value="/logout"/>">Logout</a></li>
    </ul>
</nav>
<section>
    <div>
        <h1>Profile</h1>
    </div>
    <div>
        <h1>Account</h1>
        <c:choose>
            <c:when test="${!test}">
                <b>You don't have balance, click to create one !</b>
                <form th:action="/profile" method="post">
                    <input type="submit" name="addBalance"/>Add Balance
                </form>
            </c:when>
            <c:otherwise>
                <b> ${balance} €</b>
                <form th:action="/profile" modelattribute="update" method="post">
                    <input type="hidden" name="addBalance" value="put">
                    <div>
                        <label>
                            <input type="number" name="update" max="999" min="1" step="1">
                        </label>
                    </div>
                    <div>
                        <label>
                            <button type="submit" name="action" value="update">Add</button>
                        </label>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
    <div>

    </div>
</section>
</body>
</html>
