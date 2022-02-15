<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jonrob287
  Date: 2/15/22
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a new Ad</h1>
    <form action="/ads/edit" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="<c:out value='${ad.id}' />" />
            <label> Title:
                <input type="text" name="title" class="form-control"
                       value="<c:out value='${ad.title}'/>"
                />
            </label>
        </div>
        <div class="form-group">
            <label for="description">Description: </label>
            <textarea id="description" name="description" class="form-control" >value="<c:out value='${ad.description}'/>"</textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary" value="Save">
    </form>
</div>
</body>
</html>
