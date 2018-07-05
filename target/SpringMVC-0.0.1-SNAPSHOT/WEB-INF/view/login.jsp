<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="include/css.jsp" />

<body>
<div class="container">

    <form:form action="/j_spring_security_check" method="post" modelAttribute="user" class="form-signin col-md-4 col-md-offset-4">
        <h2 class="form-signin-heading">Lütfen giriş yapın</h2>
        <label for="inputEmail" class="sr-only">Kullanıcı Adı</label>
        <form:input type="text" id="inputEmail" class="form-control" path="username"/><br>
        <label class="sr-only">Şifre</label>
        <form:input type="password" class="form-control" placeholder="Şifre" path="password"/><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Giriş Yap</button>
    </form:form>

</div>
</body>
</html>
