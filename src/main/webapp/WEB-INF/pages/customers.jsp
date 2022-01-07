<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
</head>
<t:pageTemplate pageTitle="Customers">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th class="th-sm">Name
            </th>
            <th class="th-sm">Email
            </th>
            <th class="th-sm">Position
            </th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="user" items="${users}" varStatus="status">
              <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>ceva</td>
        </tr>
    </c:forEach>
    </tbody>
        <tfoot>
        
        </tfoot>
    </table>
</t:pageTemplate>
