<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>


</head>
<t:pageTemplate pageTitle="Dashboard">
    <c:out value="${pageContext.session.getAttribute('userId')}" />
</t:pageTemplate>
