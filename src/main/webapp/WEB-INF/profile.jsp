<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container-fluid text-center bg-transparent">

    <h1>Welcome Back, ${sessionScope.user.username}!</h1>

    <div class="card bg-transparent">
        <h2 class="card-title">Account Details:</h2>
        <p class="card-text ">User: ${sessionScope.user.username}</p>
        <p class="card-text">Email: ${sessionScope.user.email}</p>

        <form method="post" action="/user/delete">
            <input type="hidden" id="delete" name="deleteUsername" value="${sessionScope.user.username}">
            <input type="submit" class="btn btn-outline-danger" value="Delete Account">
        </form>

        <form action="/user/edit">
            <input type="hidden" id="edit" name="username" value="${sessionScope.user.username}">
            <input type="submit" class="btn btn-outline-danger" value="Edit Account">
        </form>

        <h2>Here are your current job postings:</h2>

        <ul class="list-group">
            <c:forEach items="${ads}" var="ad">
                <c:if test="${sessionScope.user.id == ad.getUserId()}">
                    <li class="list-group-item bg-transparent">
                        <a href="/ads/details?adId=${ad.id}">${ad.title}</a>
                        <p>Job Description: ${ad.description}</p>
                        <p>Job Location: ${ad.location}</p>
                        <p>Company: ${ad.company}</p>
                        <p>Job Type: ${ad.job_type}</p>
                        <p>Starting Salary: $${ad.salary}</p>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </div>
</div>
</div>
</div>


</body>
</html>
