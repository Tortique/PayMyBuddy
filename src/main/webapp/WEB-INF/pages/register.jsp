<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Register - PayMyBuddy</title>
</head>
<body>
<div class="container text-center">
    <div>
        <h1>User Registration - Sign Up</h1>
    </div>
    <form th:action="/register" modelattribute="user"
          method="post" style="max-width: 600px; margin: 0 auto;">
        <div th:if="${existingUser != null}" role="alert" th:text=${existingUserError}></div>
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">E-mail: </label>
                <div class="col-8">
                    <label>
                        <input type="email" name="email" class="form-control" required />
                    </label>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Password: </label>
                <div class="col-8">
                    <label>
                        <input type="password" name="password" class="form-control"
                               required minlength="6" maxlength="10"/>
                    </label>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Full Name: </label>
                <div class="col-8">
                    <label>
                        <input type="text" name="name" class="form-control"
                               required minlength="2" maxlength="30"/>
                    </label>
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Sign Up</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>