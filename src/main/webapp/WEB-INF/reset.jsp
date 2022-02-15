<%--
  Created by IntelliJ IDEA.
  User: ac
  Date: 2/15/22
  Time: 12:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Reset Password" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
  <h1>Reset Password for .</h1>
  <form action="/reset" method="post">
    <div class="form-group">
      <label for="oldpassword">Old Password</label>
      <input id="oldpassword" name="oldpassword" class="form-control" type="password">
      <c:if test="${sessionScope.passwordFail}">
        <div style="color: red">Password is Incorrect</div>
      </c:if>
      <% session.removeAttribute("passwordFail");%>
    </div>
    <div class="form-group">
      <label for="newpassword">NewPassword</label>
      <input id="newpassword" name="newpassword" class="form-control" type="password">
    </div>
    <div class="form-group">
      <label for="confirm_password">Confirm Password</label>
      <input id="confirm_password" name="confirm_password" class="form-control" type="password">
      <c:if test="${sessionScope.newPasswordFail}">
        <div style="color: red">Confirm Password does not match new Password</div>
      </c:if>
      <% session.removeAttribute("newPasswordFail");%>
    </div>
    <input type="submit" class="btn btn-primary btn-block">
    <c:if test="${sessionScope.passChanged}">
      <div style="color: green">Your Password has been Successfully Changed</div>
    </c:if>
    <% session.removeAttribute("newPasswordFail");%>
  </form>
</div>


</body>
</html>
