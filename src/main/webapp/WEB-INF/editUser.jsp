<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit User"/>
    </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<!-- Edit User Form -->

<div class="container">
    <h1 class="zen-text-retro">Please enter changes</h1>
    <form action="/user/edit" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user.username}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" value="${sessionScope.user.email}">
        </div>
        <div class="form-group">
            <label for="password">New Password</label>
            <input id="password" name="password" class="form-control" type="password"/>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm New Password</label>
            <input id="confirmPassword" name="confirmPassword" class="form-control" type="password"/>
        </div>
        <div class="d-flex justify-content-end pt-3">
            <input type="hidden" id="userId" name="userId" value="${sessionScope.user.id}">
            <input type="submit" class="btn btn-block zen-btn-outline-primary" value="Submit">
        </div>
    </form>
</div>
</body>
</html>
