<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Login - PayMyBuddy</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div>
    <form th:action="/doLogin" method="post" style="max-width: 400px; margin: 0 auto;">
            <div>
                E-mail: <label>
                <input type="email" name="email" required/>
            </label>
            </div>
            <div>
                Password: <label>
                <input type="password" name="password" required/>
            </label>
            </div>
            <div>
                <input type="submit" value="Login"/>
                <input type="hidden" name="_csrf" value=""/>
            </div>
    </form>
</div>
</body>
</html>