<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class ="nav navbar-nav navbar-left">
            <li><a href="/ads/search">Search</a></li>
            <li><a href="/ads">View Ads</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <c:choose> <c:when test = "${empty username}">
                <li><a href="/login">Login</a></li>
                <li><a href="/register">Register</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="/profile">Profile</a></li>
                <li><a href="/ads/create">Create Ad</a></li>
                <li><a href="/logout">Logout</a></li>
            </c:otherwise></c:choose>


        </ul>

    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
