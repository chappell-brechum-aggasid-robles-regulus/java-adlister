<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome, <c:out value="${username}"/>!</h1>
    <h2>Edit Your Profile</h2>
    <div>
        <h4>Registered Email: <c:out value="${email}"/></h4>
        <form>
            <label for="newemail">Enter New Email</label>
            <input id="newemail" name="newemail" type="text">
            <c:if test="${sessionScope.emailFail}">
                <div style="color: red">Email cannot be empty</div>
            </c:if>
            <% session.removeAttribute("passwordFail");%>
            <button formaction="/profile-edit" formmethod="post" class="btn btn-secondary mt-1">Apply</button>
            <c:if test="${sessionScope.emailChanged}">
                <div style="color: green">Email Has Been Updated</div>
            </c:if>
            <% session.removeAttribute("emailChanged");%>
        </form>
    </div>
    <hr>
    <div>
        <form>
            <button type="submit" formaction="/resetpass" class="btn btn-secondary btn-lg">Reset My Password</button>
        </form>
        <form>
            <button id="delete" class="btn btn-warning btn-lg">Delete Account</button>
            <button id="delete-user" type="submit" formaction="/profile/delete" formmethod="post" class="btn btn-danger btn-lg">Confirm Delete</button>
        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp" />

</body>
</html>
