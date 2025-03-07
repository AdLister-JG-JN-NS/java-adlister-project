<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body class="bg-pattern">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<!---Creating job Ads-->
<div class="container">
    <h1 class="zen-text-retro">Create a new Job Listing</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
            <div class="form-group">
                <label for="company">Company</label>
                <input id="company" name="company" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for="job_type">Job Type</label>
                <input id="job_type" name="job_type" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for="location">Location</label>
                <input id="location" name="location" class="form-control" type="text"/>
            </div>
            <div class="form-group">
                <label for="salary">Salary</label>
                <input id="salary" name="salary" class="form-control" type="number"/>
            </div>
            <div class="d-flex justify-content-end pt-3">
                <input type="submit" class="btn btn-block zen-btn-outline-primary">
            </div>
        </form>
    </div>

</body>
</html>
