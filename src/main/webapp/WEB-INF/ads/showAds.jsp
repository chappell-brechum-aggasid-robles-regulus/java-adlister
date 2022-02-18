<%--
  Created by IntelliJ IDEA.
  User: evabrechum
  Date: 2/14/22
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%shows individual ad that user post --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Current Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1> Here is your ad </h1>

    <h2>${ad.title}</h2>
    <p>Categories:
        <c:forEach var="category" items="${categories}">
            <c:out value="${category.name}"/>
    </c:forEach>
    </p>

    <p>${ad.description}</p>
    <p><a href="/userProfile">${user.username}</a></p>
    <p>${user.email}</p>

</div>
</body>
</html>