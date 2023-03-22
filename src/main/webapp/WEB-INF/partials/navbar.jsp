<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg sticky-top">

    <div class="container-fluid">

        <div class="navbar-header">

            <a class="navbar-brand" href="/ads">Job Postings</a>
        </div>
        <div>
            <nav id="mainNav" class="navbar navbar-expand-lg ">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarText">
                        <form class="m-0" id="search-form" action="/ads">

                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search zen-search-icon" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                            </svg>

                            <input id="searchbar" name="searchbar" type="text" placeholder="Search...">

                        </form>
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="/"><i class="bi bi-house"></i> Home</a>
                            </li>
                        </ul>
                        <span class="navbar-text">
            <ul class="navbar-nav mr-auto">
                <c:choose>
                    <c:when test="${sessionScope['user'] != null}">
                        <li class="nav-item active">
                            <a class="nav-link " href="${pageContext.request.contextPath}/profile">View Profile</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/ads/create">Create Job Listings</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item active">
                            <a class="nav-link"
                               href="${pageContext.request.contextPath}/login">Login</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/register">Register Account</a>
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
