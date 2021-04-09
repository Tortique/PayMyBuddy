<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <title>Profile - PayMyBuddy</title>
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
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1);
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
        thead {
            background-color: #5cb85c;
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
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/transfer"/>">Transfer</a>
            </li>
            <li class="nav-item active">
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
    <div class="text-center text-secondary mb-0">
        <h1>Profile</h1>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4 mb-5">
            <h1 class="text-center">Account</h1>
            <c:choose>
                <c:when test="${!test}">
                    <b>You don't have balance, click to create one !</b>
                    <form class="form-group" th:action="/profile" method="post">
                        <input class="btn btn-primary btn-x1" type="submit" name="addBalance"/>Add Balance
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="d-flex justify-content-center">
                        <b class="p-2">balance : ${balance} €</b>
                        <form class="p-2 form-row" th:action="/profile" modelattribute="update" method="post">
                            <input type="hidden" name="addBalance" value="put">
                            <div class="col-auto">
                                <label>
                                    <input class="form-control" placeholder="Amount" type="number" name="update"
                                           max="999"
                                           min="1" step="1">
                                </label>
                            </div>
                            <div class="col-auto">
                                <label>
                                    <button class="btn btn-primary btn-x1" type="submit" name="action" value="update">
                                        Add
                                    </button>
                                </label>
                            </div>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div>

    </div>
</section>
</body>
</html>
