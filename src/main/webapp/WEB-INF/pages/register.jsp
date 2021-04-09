<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Register - PayMyBuddy</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .register-form {
            width: 340px;
            margin: 50px auto;
        }
        .logo {
            color: #ffffff;
            margin: 0 auto 30px;
            text-align: center;
            width: 150px;
            height: 30px;
            z-index: auto;
            border-radius: 5%;
            background: linear-gradient(90deg, #61b85a,#86c04b);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }
        .register-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
        }
        .btn {
            font-size: 15px;
            font-weight: bold;
        }
        h1 {
            font-size: 1.5rem;
        }
    </style>
</head>
<body class="text-center">
<div class="register-form">
    <div>
        <h1>User Registration - Sign Up</h1>
    </div>
    <form th:action="/register" modelattribute="user"
          method="post" style="max-width: 600px; margin: 0 auto;">
        <div th:if="${existingUser != null}" role="alert" th:text=${existingUserError}></div>
        <div class="logo">Pay My Buddy</div>
        <div class="form-group">
            <div>
                <label>
                    <input type="email" name="email" class="form-control" placeholder="Email" required/>
                </label>
            </div>
            <div>
                <label>
                    <input class="form-control" type="password" name="password"
                           required minlength="6" maxlength="10" placeholder="Password"/>
                </label>
            </div>
            <div>
                <label>
                    <input class="form-control" type="text" name="name" placeholder="Name"
                           required minlength="2" maxlength="30"/>
                </label>
            </div>
            <div>
                <button class="btn btn-primary btn-block" type="submit">Sign Up</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>