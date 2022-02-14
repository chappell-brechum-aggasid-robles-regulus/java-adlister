<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jonrob287
  Date: 2/14/22
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <form action="/ads/search" method="post">
        <label for="query">Search: </label>
        <input type="text" name="query" id="query" placeholder="Search">
        <input type="submit" name="submit" value="Submit Search">
    </form>
    <h1>Here are all search results that include <c:out value="${query}"/>!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><c:out value="${ad.title}"/></h2>
            <p><c:out value="${ad.description}"/></p>
        </div>
    </c:forEach>
</div>
</body>
</html>
