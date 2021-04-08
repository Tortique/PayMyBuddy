<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Login - PayMyBuddy</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .login-form {
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
            background: linear-gradient(90deg, #fdfdfe,#86c04b);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }
        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .login-form h2 {
            margin: 0 0 15px;
        }
        .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
        }
        .btn {
            font-size: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body class="text-center">
<div class="login-form">
    <form th:action="/doLogin" method="post" style="max-width: 400px; margin: 0 auto;" class="box">
            <div class="logo">Pay My Buddy</div>
            <div class="form-group">
                E-mail: <label>
                <input type="email" class="form-control" name="email" required/>
            </label>
            </div>
            <div class="form-group">
                Password: <label>
                <input type="password" class="form-control" name="password" required/>
            </label>
            </div>
            <div class="form-group">
                <input type="submit" value="Login" class="btn btn-primary btn-block"/>
                <input type="hidden" name="_csrf" value=""/>
            </div>
    </form>
</div>
</body>
</html>