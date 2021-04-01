<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>PayMyBuddy</title>
</head>
<body>
<header>
    <h1>Pay My Buddy</h1>
</header>
<nav>
    <ul>
        <li><a href="<c:url value="/home"/>">Home</a></li>
        <li><a href="#">Transfer</a></li>
        <li><a href="<c:url value="/profile"/>">Profile</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="<c:url value="/logout"/>">Logout</a></li>
    </ul>
</nav>
<section>
    <div>
        <h1>Welcome to PayMyBuddy</h1>
        <b>Hello, ${name} !</b>
        <br><br>
    </div>
    <div>
        <h1>Add a Friend</h1>
        <form th:action="/home/addFriend" modelattribute="email" method="post">
            <div>
                <div>
                    <b th:text="${message}"> !</b>
                </div>
                <label> E-mail: </label>
                <div>
                    <label>
                        <input type="email" name="email"/>
                    </label>
                </div>
                <div>
                    <button type="submit">Add </button>
                </div>
            </div>
        </form>
    </div>
</section>
</body>
</html>