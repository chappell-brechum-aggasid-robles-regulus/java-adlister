<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Edit Ad</h1>
    <form action="/ads/editAd" method="post">
        <div class="form-group">
            <input type="hidden" name="id" value="<c:out value='${ad.id}' />"/>
            <label> Title:
                <input type="text" name="title" class="form-control"
                       value="<c:out value='${ad.title}'/>"
                />
            </label>
        </div>
        <div class="form-group">
            <label for="description">Description: </label>
            <textarea id="description" name="description" class="form-control"><c:out
                    value='${ad.description}'/></textarea>
        </div>
        <div class="form-group">
            <button formaction="/ads/updateAd?adId=<c:out value="${ad.id}"/>" formmethod="post" class="btn btn-primary btn=block">Save</button>
        </div>
    </form>
</div>
</body>
</html>
