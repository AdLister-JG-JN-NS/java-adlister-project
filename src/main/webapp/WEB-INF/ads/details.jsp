<%--
  Created by IntelliJ IDEA.
  User: toaster
  Date: 3/20/23
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${ad.title}" />
    </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="zen-card-container">
    <div class="zen-card p-3">
      <section class="d-flex justify-content-between">
          <span class="fs-1">${ad.title}</span>
          <span class="fs-1 fst-italic fw-lighter text-success">$${String.format("%.0f", ad.salary / 1000)}K</span>
      </section>
      <hr>
      <span class="text-muted">☞  ${ad.job_type}  ◌  ${ad.company}  ◌  ${ad.location}</span>
        <div class="d-flex flex-column">
        <span class="fs-3 fw-light my-1">Description:</span>
        <section class="mb-3">${ad.description}</section>
        <c:if test="${sessionScope.user.id == ad.getUserId()}">
            <div class="d-flex justify-content-end">
            <form action="/edit" >
                <input type="hidden" id="edit" name="edit" value="${ad.id}">
                <input type="submit" class="btn btn-outline-warning" value="edit">
            </form>
            <form method="post" action="/delete">
                <input type="hidden" id="delete" name="delete" value="${ad.id}">
                <input type="submit" class="btn btn-outline-danger" value="delete listing...">
            </form>
            </div>
        </c:if>
        </div>
    </div>
</div>
</body>
</html>
