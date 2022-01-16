<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<t:pageTemplate pageTitle="Profile">
    <table class="table table-hover w-75">
        <thead>
            <tr>
                <th class="th-sm">Name</th>
                <th class="th-sm">Email</th>
                <th class="th-sm">Position</th>
            </tr>
        </thead>
        <tbody>
                <tr >
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.position}</td>
                        <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditProfile?id=${user.id}" role="button">Edit Profile</a></td>
                </tr>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</t:pageTemplate>