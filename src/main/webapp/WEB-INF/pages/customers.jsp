<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
</head>
<t:pageTemplate pageTitle="Customers">

    <table class="table table-hover w-75">
        <thead>
            <tr>
                <th class="th-sm">Name</th>
                <th class="th-sm">Email</th>
                <th class="th-sm">Position</th>
                    <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                    <th class="th-sm">Edit</th>
                    </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}" varStatus="status">
                <tr >
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.position}</td>
                    <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                        <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}" role="button">Edit User</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</t:pageTemplate>
