<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<t:pageTemplate pageTitle="Pending">
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
                <c:if test="${user.position eq 'INVALID'}">
                    <tr >
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.position}</td>
                        <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                            <td>
                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ValidateUser?id=${user.id}" role="button">Assign Role</a>
                            </td>
                        </c:if>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</t:pageTemplate>
