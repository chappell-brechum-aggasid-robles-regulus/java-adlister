<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Create a new Ad</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" required="required" pattern="^(?!\s*$).+">
            <c:if test="${sessionScope.createTitleFail}">
                <div style="color:red">Title cannot be empty</div>
            </c:if>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" required="required" style="resize: none;"></textarea>
            <c:if test="${sessionScope.createDescriptionFail}">
                <div style="color:red">Description cannot be empty</div>
            </c:if>
        </div>
        <div class="form-group">
            <fieldset>
                <c:forEach var="category" items="${cats}">
                    <input id="<c:out value="${category.name}"/>" type="checkbox" name="category"
                           value="<c:out value="${category.id}"/>">
                    <label for="<c:out value="${category.name}"/>"><c:out value="${category.name}"/></label>
                </c:forEach>
            </fieldset>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
