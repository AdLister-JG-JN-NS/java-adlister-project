<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<!-- Login Form -->

<div class="container">
    <h1 class="zen-text-retro">Please log in</h1>
    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="d-flex justify-content-end pt-3">
            <input type="submit" class="btn zen-btn-outline-primary btn-block" value="Log In">
        </div>
    </form>
</div>
</body>
</html>
