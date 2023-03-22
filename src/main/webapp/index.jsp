<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Job Listings!"/>
    </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<!-- Job Listings Page-->

<div class="container">
    <div class="d-flex justify-content-center">
        <div class="wave">
            <span class="zen-text-retro fs-1" style="--i:1">W</span>
            <span class="zen-text-retro fs-1" style="--i:2">E</span>
            <span class="zen-text-retro fs-1" style="--i:3">L</span>
            <span class="zen-text-retro fs-1" style="--i:4">C</span>
            <span class="zen-text-retro fs-1" style="--i:5">O</span>
            <span class="zen-text-retro fs-1" style="--i:6">M</span>
            <span class="zen-text-retro fs-1" style="--i:7">E</span>
        </div>
    </div>

    <div class="d-flex  justify-content-center">
        <img src="img/chair.png">
    </div>
</div>
</body>
</html>
