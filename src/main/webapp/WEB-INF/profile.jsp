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


</div>
<div class="container">
    <h2>Your Ads</h2>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
            <form action="/ads/editAd?id=<c:out value="${ad.id}"/>" method="post">
                <input type="submit" class="btn btn-primary btn-block" name="id" value="Edit">
            </form>
            <form action="/ads/delete?id=<c:out value = "${ad.id}"/>" method="post">
                <input type="submit" class="btn btn-danger btn-block" name="id" value="Delete">
            </form>
        </div>
    </c:forEach>
</div>


</body>
</html>
