<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Register - PayMyBuddy</title>
</head>
<body>
<div>
    <div>
        <h1>User Registration - Sign Up</h1>
    </div>
    <form th:action="/register" modelattribute="user"
          method="post" style="max-width: 600px; margin: 0 auto;">
        <div th:if="${existingUser != null}" role="alert" th:text=${existingUserError}></div>
        <div>
            <div>
                <label>E-mail: </label>
                <div>
                    <label>
                        <input type="email" name="email" class="form-control" required/>
                    </label>
                </div>
            </div>
            <div>
                <label>Password: </label>
                <div>
                    <label>
                        <input type="password" name="password"
                               required minlength="6" maxlength="10"/>
                    </label>
                </div>
            </div>
            <div>
                <label>Full Name: </label>
                <div>
                    <label>
                        <input type="text" name="name"
                               required minlength="2" maxlength="30"/>
                    </label>
                </div>
            </div>
            <div>
                <button type="submit">Sign Up</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>