<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" data-bs-theme="dark">
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container-fluid text-center">

    <h1>Welcome Back, ${sessionScope.user.username}!</h1>

    <div class="row">
        <div class="card mb-5">
            <div class="card-body">
                <h1 class="card-title">Account Details:</h1>
                <p class="card-text">User: ${sessionScope.user.username}</p>
                <p class="card-text">Email: ${sessionScope.user.email}</p>
                <%--                <p class="card-text">Member since:${sessionScope.user.date}</p>--%>
                <div class="card-text">
                    <ul class="list-group">
                        <c:forEach items="${ads}" var="ad">
                            <c:if test="${sessionScope.user.id == ad.getUserId()}">
                                <li class="list-group-item">
                                    <a href="/ads/details?adid=${ad.id}">${ad.title}</a>
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
                <a href="/edit" class="btn btn-primary text-center">Update/Edit Job Listing</a>
            </div>
        </div>
    </div>


</body>
</html>
