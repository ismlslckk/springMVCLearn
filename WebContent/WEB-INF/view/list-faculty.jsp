<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ismlslck
  Date: 12.04.2018
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>
<div class="container">
    <jsp:include page="include/menu.jsp" />
    <div class="row col-md-6 col-md-offset-3">
        <form:form action="save" method="post" modelAttribute="faculty">
            <div class="form-group">
                <label>Fakülte Adı</label>
                <form:input type="text" class="form-control" path="name"/>
            </div>
            <button type="submit" class="btn btn-primary">Kaydet</button>
        </form:form>
    </div>
    <div style="text-align: center;" class="jumbotron">
        <h1 class="display-4">Fakülteler</h1>
        <h4 class="display-4">${message}</h4>
    </div>
    <table class="table">
        <tr>
            <th>Fakülte İsmi</th>
            <th>İşlem</th>
        </tr>
        <c:forEach var="faculty" items="${faculties}">
            <tr>
                <td>${faculty.name}</td>
                <td><span onclick="location.href='updateForm/${faculty.id}'" class="glyphicon glyphicon-refresh"
                          aria-hidden="true"></span><span onclick="location.href='delete/${faculty.id}'"
                                                          class="glyphicon glyphicon-trash"
                                                          aria-hidden="true"></span></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
