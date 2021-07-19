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
    <h1>Please update your information.</h1>
    <form action="/updateProfile" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" placeholder="${username}" value="${username}" readonly>
        </div>
        <div class="form-group">
            <label for="email">Email${userEmailExistsHTML}</label>
            <input id="email" name="email" class="form-control" type="text" placeholder="${userEmailExistsMessage}${invalidEmailMessage}">
        </div>
        <div class="form-group">
            <label for="password">Password${noPasswordMatchAlert}</label>
            <input id="password" name="password" class="form-control" type="password" placeholder="${noPasswordMatchMessage}" required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password${noPasswordMatchAlert}</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>

</body>
</html>
