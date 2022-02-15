<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
    <script>
	    function validate()
	    {
		    var email = document.form.email.value;
		    var username = document.form.username.value;
		    var password = document.form.password.value;
		    var confirm_password= document.form.confirm_password.value;

		    if (username==null || username==="")
		    {
			    alert("Username can't be blank");
			    return false;
		    }
		    else if (email==null || email==="")
		    {
			    alert("Email can't be blank");
			    return false;
		    }
		    else if(password.length<6)
		    {
			    alert("Password must be at least 6 characters long.");
			    return false;
		    }
		    else if (password!==confirm_password)
		    {
			    alert("Confirm Password should match with the Password");
			    return false;
		    }
	    }
    </script>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form name="form" action="/register" method="post" onsubmit="validate()">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
        <c:if test="${sessionScope.userNameExists}">
            <div>Username exists already.</div>
        </c:if>
    </div>
</body>
</html>
