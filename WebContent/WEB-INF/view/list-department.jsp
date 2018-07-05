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
<jsp:include page="include/css.jsp" />
<body>
<div class="container">
    <jsp:include page="include/menu.jsp" />
    <div class="row col-md-6 col-md-offset-3">
        <form:form action="/department/save" method="post" modelAttribute="deparment">
            <div class="form-group">
                <label>Bölüm Adı</label>
                <form:input type="text" class="form-control" path="name"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Fakülte</label>
                <form:select class="form-control" path="faculty">
                    <option>Seçiniz...</option>
                    <c:forEach  var="item" items="${faculties}">
                        <option value="${item.id}">${item.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="faculty" cssClass="error"/>
            </div>
            <button type="submit" class="btn btn-primary">Kaydet</button>
        </form:form>
    </div>
    <div style="text-align: center;" class="jumbotron">
        <h1 class="display-4">Bölümler</h1>
        <h4 class="display-4">${message}</h4>
    </div>
    <table class="table">
        <tr>
            <th>Bölüm İsmi</th>
            <th>Bulunduğu Fakülte</th>
            <th>İşlem</th>
        </tr>
        <c:forEach var="deparment" items="${deparments}">
            <tr>
                <td>${deparment.name}</td>
                <td>${deparment.faculty.name}</td>
                <td><span onclick="location.href='updateForm/${deparment.id}'" class="glyphicon glyphicon-refresh"
                          aria-hidden="true"></span><span onclick="location.href='delete/${deparment.id}'"
                                                          class="glyphicon glyphicon-trash"
                                                          aria-hidden="true"></span></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
