<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Login - PayMyBuddy</title>
</head>
<body>
<div>
    <form th:action="/doLogin" method="post" style="max-width: 400px; margin: 0 auto;">
        <p>
            E-mail: <label>
            <input type="email" name="email" required/>
        </label>
        </p>
        <p>
            Password: <label>
            <input type="password" name="password" required/>
        </label>
        </p>
        <p>
            <input type="submit" value="Login"/>
            <input type="hidden" name="_csrf" value=""/>
        </p>
    </form>
</div>
</body>
</html>