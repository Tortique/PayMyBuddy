<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>PayMyBuddy</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .logo {
            color: #ffffff;
            margin: auto;
            text-align: center;
            width: 150px;
            height: 45px;
            z-index: auto;
            border-radius: 5%;
            padding-top: 10px;
            background: linear-gradient(90deg, #61b85a, #86c04b);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }

        .page-section {
            padding-top: 100px;
        }

        h1 {
            font-size: 1.5rem;
        }

        .row {
            display: flex;
            flex-wrap: wrap;
            margin-right: auto;
            margin-left: auto;
            padding-top: 50px;
        }

        .send {
            background-color: #f5f5f5;
            position: relative;
            display: block;
            border-radius: 5%;
            width: 75%;
            margin-bottom: 3rem;
        }
        .head {
            background-color: white;
        }
        .btnAdd {
            cursor: pointer;
            border-radius: 0.5rem;
            border: 0.125rem solid transparent;
        }
        .btn-primary2 {
            color: white;
            background-color: #0275d8;
            border-color: #0275d8;
        }
        .list {
            background-color: #f5f5f5;
            position: relative;
            display: block;
            width: 75%;
        }
        .table {
            border-collapse: collapse;
            border-spacing: 0;
        }
        thead {
            background-color:#5cb85c;
            color: white;
        }
        .btn {
            cursor: pointer;
            border-radius: 0.5rem;
            border: 0.125rem solid transparent;
        }

        .btn-x1 {
            font-size: 1.25rem;
        }

        .btn-primary {
            color: white;
            background-color: #5bb85c;
            border-color: #5bb85c;
        }

        .form-row {
            height: auto;
            padding-top: 1.5rem;
            padding-right: 2px;
            padding-left: 2px;
        }

        .form-control {
            display: block;
            width: 100%;
            font-size: 1rem;
            color: #495057;
            background-color: white;
            background-clip: padding-box;
            border: 1px #ced4da;
            border-radius: 0.25rem;

        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="logo">Pay My Buddy</div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav ">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/home"/>">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/transfer"/>">Transfer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/profile"/>">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Contact</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<section class="page-section">
    <div class="row justify-content-center">
        <div class="send">
            <div class="mx-auto">
                <div class="head d-flex justify-content-end">
                <h1 class="p-2">Send Money</h1>
                <a class="ml-auto p-2" href="<c:url value="/home"/>">
                    <button class="btnAdd btn-primary2" type="button">Add Connection</button>
                </a>
                </div>
                <form th:action="/transfer/sendMoney" modelattribute="friend" method="post">
                    <div class="form-row">
                        <div class="col-auto">
                            <label>
                                <select class="form-control" name="transactionFriendId">
                                    <c:forEach items="${FriendsList}" var="Friend">
                                        <option value="${Friend.id}">
                                                ${Friend.name}
                                                ${Friend.email}
                                        </option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <div class="col-auto">
                            <label>
                                <input class="form-control" placeholder="Amount" type="number" name="value" step="1">
                            </label>
                        </div>
                        <div class="col-auto">
                            <label>
                                <input class="form-control" placeholder="Comment" type="text" name="comment"/>
                            </label>
                        </div>
                        <div class="col-auto">
                            <label>
                                <button class="btn btn-primary btn-x1" type="submit"
                                        onsubmit="window.location.reload()">Pay
                                </button>
                            </label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="list">
            <h1>My Transactions</h1>
            <div class="table-responsive">
                <table class="table table-bordered table-sm table-hover">
                    <thead>
                    <tr>
                        <th>Connections</th>
                        <th>Description</th>
                        <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${transactions}" var="transaction">
                        <tr>
                            <td>${transaction.friendName}</td>
                            <td>${transaction.comment}</td>
                            <td>${transaction.value} euros</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
</section>
</body>
</html>