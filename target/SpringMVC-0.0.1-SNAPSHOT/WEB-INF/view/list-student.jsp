<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h4 class="display-4">${message}</h4>
    <table class="table">
        <tr>
            <th>Öğrenci No</th>
            <th>İsim</th>
            <th>Soyisim</th>
            <th>Bölüm</th>
            <th>Fakülte</th>
            <th>İşlem</th>
        </tr>
        <c:forEach var="tempStudent" items="${students}">
            <tr>
                <td>${tempStudent.ogrNo}</td>
                <td>${tempStudent.name}</td>
                <td>${tempStudent.surname}</td>
                <td>${tempStudent.department}</td>
                <td>${tempStudent.department.faculty.name}</td>
                <td><span onclick="location.href='updateForm/${tempStudent.id}'" class="glyphicon glyphicon-refresh"
                          aria-hidden="true"></span><span onclick="location.href='delete/${tempStudent.id}'"
                                                          class="glyphicon glyphicon-trash"
                                                          aria-hidden="true"></span></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
