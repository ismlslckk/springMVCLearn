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

    <form class="form-signin col-md-4 col-md-offset-4">
        <h2 class="form-signin-heading">Lütfen giriş yapın</h2>
        <label for="inputEmail" class="sr-only">Kullanıcı Adı</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Kullanıcı Adı" required="" autofocus=""><br>
        <label for="inputPassword" class="sr-only">Şifre</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Şifre" required=""><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Giriş Yap</button>
    </form>

</div>
</body>
</html>
