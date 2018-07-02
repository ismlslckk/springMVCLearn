<%--
  Created by IntelliJ IDEA.
  User: ismlslck
  Date: 20.04.2018
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Öğrenci Güncelle</title>
    <jsp:include page="include/css.jsp" />

</head>
<body>
<div class="container">
    <div style="text-align: center;" class="jumbotron">
        <h1 class="display-4">Bölüm Güncelle</h1>
    </div>
    <div class="row col-md-6 col-md-offset-3">
        <form:form action="/department/update" method="post" modelAttribute="department">
            <form:hidden path="id"/>
            <div class="form-group">
                <label>Bölüm İsmi</label>
                <form:input type="text" class="form-control" path="name"/>
            </div>

            <div class="form-group">
                <label>Fakülte</label>
                <form:select class="form-control" id="faculty" path="faculty">
                    <form:option value="seciniz">Seçiniz</form:option>
                    <c:forEach var="item" items="${faculties}">
                        <option ${department.faculty.id==item.id ? 'selected':''} value="${item.id}">${item.name}</option>
                    </c:forEach>
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">Güncelle</button>
        </form:form>
    </div>
</div>
</body>
</html>
