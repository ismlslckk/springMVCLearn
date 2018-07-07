<%--
  Created by IntelliJ IDEA.
  User: ismlslck
  Date: 7.07.2018
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
    <jsp:include page="include/css.jsp" />
    <style>
        .alert{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="alert alert-danger" role="alert">
    Bu sayfaya erişim izniniz yoktur!<br>
    <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/"><- Geri dön</a>
</div>

</body>
</html>
