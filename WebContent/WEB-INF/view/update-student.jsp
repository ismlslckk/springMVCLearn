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
        <h1 class="display-4">Öğrenci Güncelle</h1>
    </div>
    <div class="row col-md-6 col-md-offset-3">
        <form:form action="/student/update" method="post" modelAttribute="student">
            <form:hidden path="id"/>
            <div class="form-group">
                <label>Öğrenci no</label>
                <form:input type="text" class="form-control" path="ogrNo"/>
            </div>
            <div class="form-group">
                <label>İsim</label>
                <form:input type="text" class="form-control" path="name"/>
            </div>
            <div class="form-group">
                <label>Soyisim</label>
                <form:input type="text" class="form-control" path="surname"/>
            </div>
            <div class="form-group">
                <label>Fakülte</label>
                <form:select class="form-control" id="faculty" path="department.faculty"
                             onchange="getDepartmentsByFacultyId()">
                    <form:option value="seciniz">Seçiniz</form:option>
                    <c:forEach var="item" items="${faculties}">
                        <option ${student.department.faculty.id==item.id ? 'selected':''}
                                value="${item.id}">${item.name}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label>Bölüm ( <span onclick="location.href='${pageContext.request.contextPath}/department/list'"
                                     style="cursor: pointer;" class="glyphicon glyphicon-plus"></span> )</label>
                <form:select class="form-control" id="department" path="department">
                    <form:option value="seciniz">Seçiniz.</form:option>
                    <c:if test="${(student.department != null)}">
                        <c:forEach var="item" items="${departments}">
                            <option ${student.department.id==item.id ? 'selected':''}
                                    value="${item.id}">${item.name}</option>
                        </c:forEach>
                    </c:if>
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">Güncelle</button>
        </form:form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function getDepartmentsByFacultyId() {
        var facultyId = $("#faculty").val();
        $.getJSON("/department/list/" + facultyId)
            .done(function (json) {
                var $select = $("#department");
                $select.html('');
                $select.append($("<option />").val("seciniz").text("Seçiniz"));
                $.each(json, function () {
                    $select.append($("<option />").val(this.id).text(this.name));
                });
            })
            .fail(function (jqxhr, textStatus, error) {
                var err = textStatus + ", " + error;
                console.log(err);
            });
    }
</script>
</body>
</html>
