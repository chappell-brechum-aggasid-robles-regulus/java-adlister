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
    <form action="/ads/search" method="get">
        <label for="category">Category:</label>
        <select name="category" id="category">
            <option value="0">All</option>
            <option value="1">Free</option>
            <option value="2">Used</option>
            <option value="3">New</option>
            <option value="4">Jobs</option>
            <option value="5">Services</option>
            <option value="6">Lost</option>
            <option value="7">Wanted</option>
            <option value="8">Electronics</option>
            <option value="9">Vehicles</option>
            <option value="10">Pets</option>
            <option value="11">Furniture</option>
        </select>
        <label for="categorySearch"></label>
        <input type="text" name="query" id="categorySearch" placeholder="Search">
        <input type="submit" id="submit" value="Search By Category">
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
