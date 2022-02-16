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
            <button formaction="/profile-edit" formmethod="post" class="btn btn-secondary btn-lg">Apply</button>
        </form>
    </div>
    <hr>
    <div>
        <form>
            <button type="submit" formaction="/resetpass" class="btn btn-secondary btn-lg">Reset My Password</button>
        </form>
        <form>
            <button type="submit" formaction="/deactivate" class="btn btn-danger btn-lg">Delete My Account</button>
        </form>
    </div>
</div>

</body>
</html>
