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

        .add {
            background-color: aliceblue;
            position: relative;
            display: block;
            border-radius: 5%;
        }

        .list {
            background-color: aliceblue;
            position: relative;
            display: block;
            border-radius: 5%;
        }
        .table {
            border-collapse: collapse;
            border-spacing: 0;
        }
        .btn {
            cursor: pointer;
            border-radius: 0.5rem;
            border: 0.125rem solid transparent;
        }
        .btn-x1 {
            padding: 1rem 1.75rem;
            font-size: 1.25rem;
        }
        .btn-primary {
            color: white;
            background-color: #5bb85c;
            border-color: #5bb85c;
        }
        .form-group {
            height: auto;
        }
        .form-control {
            display: block;
            width: 100%;
            font-size: 1rem;
            color : #495057;
            background-color: white;
            background-clip: padding-box;
            border:1px #ced4da;
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
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/home"/>">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/transfer"/>">Transfer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/Profile"/>">Profile</a>
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
        <h1>Hello, ${name} !</h1>
        <b>Welcome to PayMyBuddy</b>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4 mb-5">
            <div class="add mx-auto">
                <h1>Add a Friend</h1>
                <form th:action="/home/addFriend" modelattribute="email" method="post">
                    <div>
                        <div>
                            <b>${message} !</b>
                        </div>
                        <div class="form-group">
                            <label>
                                <input class="form-control" placeholder="Email" type="email" name="email"/>
                            </label>
                        </div>
                        <div>
                            <button class="btn btn-primary btn-x1" id="AddFriend" type="submit" onsubmit="window.location.reload()">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="list col-md-6 col-lg-4 mb-5">
            <h1>Friends List</h1>
            <div class="table-responsive">
                <table class="table table-bordered table-sm table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>E-mail</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listOfFriends}" var="user">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
</body>
</html>