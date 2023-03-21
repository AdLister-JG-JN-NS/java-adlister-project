<%--
  Created by IntelliJ IDEA.
  User: gijoe250
  Date: 3/20/23
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Edit" />
  </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<form action="/edit" method="post">
  <div class="form-group">
    <label for="title">Title</label>
    <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
  </div>
  <div class="form-group">
    <label for="description">Description</label>
    <textarea id="description" name="description" class="form-control" type="text">${ad.description}</textarea>
  </div>

  <div class="form-group">
    <label for="company">Company</label>
    <input id="company" name="company" class="form-control" type="text" value="${ad.company}"/>
  </div>
  <div class="form-group">
    <label for="job_type">Job Type</label>
    <input id="job_type" name="job_type" class="form-control" type="text" value="${ad.job_type}"/>
  </div>
  <div class="form-group">
    <label for="location">Location</label>
    <input id="location" name="location" class="form-control" type="text" value="${ad.location}"/>
  </div>
  <div class="form-group">
    <label for="salary">Salary</label>
    <input id="salary" name="salary" class="form-control" type="number" value="${ad.salary}"/>
  </div>
  <input type="hidden" id="adId" name="adId" value="${ad.id}">
  <input type="hidden" id="userId" name="userId" value="${ad.userId}">
  <input type="submit" class="btn btn-block btn-primary" value="Edit">
</form>
</body>
</html>
