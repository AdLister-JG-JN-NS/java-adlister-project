<%--
  Created by IntelliJ IDEA.
  User: toaster
  Date: 3/20/23
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>

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

    </div>

</body>
</html>
