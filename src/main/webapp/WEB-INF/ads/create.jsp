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
            <input id="title" name="title" class="form-control" type="text" required="required">
            <c:if test="${sessionScope.createTitleFail}">
                <div style="color:red">Title cannot be empty</div>
            </c:if>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" required="required"></textarea>
            <c:if test="${sessionScope.createDescriptionFail}">
                <div style="color:red">Description cannot be empty</div>
            </c:if>
        </div>
        <div class="form-group">
            <%--   Start of Categories     --%>
            <fieldset>
                <input id="free" type="checkbox" name="category" value="1">
                <label for="free">Free</label><br>
                <input id="used" type="checkbox" name="category" value="2">
                <label for="used">Used</label><br>
                <input id="new" type="checkbox" name="category" value="3">
                <label for="new">New</label><br>
                <input id="jobs" type="checkbox" name="category" value="4">
                <label for="jobs">Jobs</label><br>
                <input id="services" type="checkbox" name="category" value="5">
                <label for="services">Services</label><br>
                <input id="lost" type="checkbox" name="category" value="6">
                <label for="lost">Lost</label><br>
                <input id="wanted" type="checkbox" name="category" value="7">
                <label for="wanted">Wanted</label><br>
                <input id="electronics" type="checkbox" name="category" value="8">
                <label for="electronics">Electronics</label><br>
                <input id="vehicles" type="checkbox" name="category" value="9">
                <label for="vehicles">Vehicles</label><br>
                <input id="pets" type="checkbox" name="category" value="10">
                <label for="pets">Pets</label><br>
                <input id="furniture" type="checkbox" name="category" value="11">
                <label for="furniture">furniture</label><br>
            </fieldset>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
