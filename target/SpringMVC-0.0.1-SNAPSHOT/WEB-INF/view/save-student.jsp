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
    <title>Öğrenci Ekle</title>
    <jsp:include page="include/css.jsp" />

</head>
<body>
<div class="container">
    <jsp:include page="include/menu.jsp" />
    <div style="text-align: center;" class="jumbotron">
        <h1 class="display-4">Öğrenci Kaydet</h1>
    </div>
    <div class="row col-md-6 col-md-offset-3">
        <form:form action="saveStudent" method="post" modelAttribute="student" name="student">
            <div class="form-group">
                <label>Öğrenci no</label>
                <form:input type="number" class="form-control" path="ogrNo"/>
                <form:errors path="ogrNo" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>İsim</label>
                <form:input type="text" class="form-control" path="name"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Soyisim</label>
                <form:input type="text" class="form-control" path="surname"/>
                <form:errors path="surname" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Fakülte ( <span onclick="location.href='${pageContext.request.contextPath}/faculty/list'"
                                       style="cursor: pointer;" class="glyphicon glyphicon-plus"></span> )</label>
                <form:select class="form-control" id="faculty" path="department.faculty" onchange="getDepartmentsByFacultyId()">
                    <form:option value="seciniz">Seçiniz</form:option>
                    <c:forEach var="item" items="${faculties}">
                        <option value="${item.id}">${item.name}</option>
                    </c:forEach>
                </form:select>
                <form:errors path="department.faculty.name" cssClass="error"/>
            </div>
            <div class="form-group">
                <label>Bölüm ( <span onclick="location.href='${pageContext.request.contextPath}/department/list'"
                                     style="cursor: pointer;" class="glyphicon glyphicon-plus"></span> )</label>
                <form:select class="form-control" id="department" path="department">
                    <%-- <c:forEach var="item" items="${departments}">
                         <option value="${item.id}">${item.name}</option>
                     </c:forEach>--%>
                </form:select>
                <form:errors path="department.name" cssClass="error"/>
            </div>
            <button type="submit" class="btn btn-primary">Kaydet</button>
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
