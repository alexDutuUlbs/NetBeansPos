<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Dashboard">
    <h1>Welcome to the Jungle UserId <c:out value="${pageContext.session.getAttribute('userId')}" /> (Semnul exclamarii)</h1>
</t:pageTemplate>
