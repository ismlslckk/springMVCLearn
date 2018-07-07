<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center;" class="jumbotron">
    <h1 class="display-4">Tüm Öğrenciler.</h1>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/student/saveStudentForm"
           role="button">Öğrenci Ekle</a>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/faculty/list"
           role="button">Fakülte Ekle</a>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/department/list"
           role="button">Bölüm Ekle</a>
        <c:url var="logoutUrl" value='/logout'/>
    <form action="${logoutUrl}" method="post">
        <input type="submit" class="btn btn-danger" value="Çıkış"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
    </p>
</div>