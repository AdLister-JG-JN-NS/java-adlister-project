<%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/21/23
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit User"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<form action="/user/edit" method="post">
    <div class="form-group">
        <label for="username">Username</label>
        <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user.username}">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <textarea id="email" name="email" class="form-control" type="text">${sessionScope.user.email}</textarea>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input id="password" name="password" class="form-control" type="text" value="${sessionScope.user.password}"/>
    </div>
    <input type="submit" class="btn btn-block btn-primary" value="Edit">
</form>
</body>
</html>
