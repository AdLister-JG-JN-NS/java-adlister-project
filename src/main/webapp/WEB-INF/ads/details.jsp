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
    <title>${ad.title}</title>
</head>
<body>

    <div>
      <h1>${ad.title}</h1><span>$${ad.salary / 1000}K</span>
      <hr>
      <span>☞ ${ad.job_type} ◌ ${ad.company} ◌ ${ad.location}</span>
        <h3>Description:</h3>
        <section>${ad.description}</section>
        <c:if test="${sessionScope.user.id == ad.getUserId()}">
            <form method="post" action="/delete">
                <input type="hidden" id="delete" name="delete" value="${ad.id}">
                <input type="submit" class="btn btn-block btn-primary" value="delete listing...">
            </form>
        </c:if>
    </div>
</body>
</html>
