<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-body-dark">

    <div class="container-fluid">

        <div class="navbar-header">

            <a class="navbar-brand" href="/ads">Job Postings</a>
        </div>
        <div>
            <nav id="mainNav" class="navbar navbar-expand-lg red-hover">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarText">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link " href="/"><i class=""></i> Home</a>
                            </li>
                        </ul>
                        <span class="navbar-text">
            <ul class="navbar-nav mr-auto">
                <c:choose>
                    <c:when test="${sessionScope['user'] != null}">
                        <li class="nav-item active">
                            <a class="nav-link red-hover w-text" href="${pageContext.request.contextPath}/profile">View Profile</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link red-hover w-text"
                               href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link red-hover w-text" href="${pageContext.request.contextPath}/ads/create">Create Job Listings</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item active">
                            <a class="nav-link red-hover w-text"
                               href="${pageContext.request.contextPath}/login">Login</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link red-hover w-text" href="${pageContext.request.contextPath}/register">Register Account</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </span>
                    </div>
                </div>
        </div> <!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->

</nav>
