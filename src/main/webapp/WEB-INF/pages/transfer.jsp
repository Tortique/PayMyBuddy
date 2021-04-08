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
        <li><a href="<c:url value="/transfer"/>">Transfer</a></li>
        <li><a href="<c:url value="/profile"/>">Profile</a></li>
        <li><a href="#">Contact</a></li>
        <li><a href="<c:url value="/logout"/>">Logout</a></li>
    </ul>
</nav>
<section>
    <div>
        <h1>Send Money</h1>
        <a href="<c:url value="/home"/>">
        <button type="button" >Add Connection</button>
        </a>
        <form th:action="/transfer/sendMoney" modelattribute="friend" method="post">
            <div>
                <div>
                    <label>
                        <select name="transactionFriendId">
                            <c:forEach items="${FriendsList}" var="Friend">
                                <option value="${Friend.id}">
                                    ${Friend.name}
                                    ${Friend.email}
                                </option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
                <div>
                    <label>
                        <input type="number" name="value" step="1">
                    </label>
                </div>
                <div>
                    <label>
                        <input type="text" name="comment"/>
                    </label>
                </div>
                <div>
                    <label>
                        <button type="submit" onsubmit="window.location.reload()">Pay</button>
                    </label>
                </div>
            </div>
        </form>
        <div>
            <h1>My Transactions</h1>
            <table>
                <tr>
                    <th>Connections</th>
                    <th>Description</th>
                    <th>Amount</th>
                </tr>
                <c:forEach items="${transactions}" var="transaction">
                    <tr>
                        <td>${transaction.friendName}</td>
                        <td>${transaction.comment}</td>
                        <td>${transaction.value} euros</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
</body>
</html>