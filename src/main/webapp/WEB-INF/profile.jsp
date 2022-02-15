<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, <c:out value="${username}"/>!</h1>
    <div>
        <h4>Registered Email: <c:out value="${email}"/></h4>
        <button>Edit Email</button>
        <button>Apply</button>
    </div>
    <div>
        <button>Delete My Account</button>
    </div>
</div>
<div class="container">
    <h2>Your Ads</h2>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
            <a href="/profile/editAd?id=<c:out value ="${ad.id}"/>"><input type="button"
                                                                           class="btn btn-primary btn-block"
                                                                           value="Edit"></a>
            <input type="button" class="btn btn-primary btn-block" id="update" value="Update">
            <form action="/ads/delete?id=<c:out value = "${ad.id}"/>" method="post">
                <input type="submit" class="btn btn-danger btn-block" name="id" value="Delete">
            </form>
        </div>
    </c:forEach>
</div>


</body>
</html>
