<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<t:pageTemplate pageTitle="Validate User">
    <c:if test="${pageContext.request.isUserInRole('MangerRole')}">
        <form class="needs-validation w-25" novalidate method="POST" action="${pageContext.request.contextPath}/ValidateUser">
            <input type ="hidden" class="form-control" name="username" id="username" placeholder="Username" required value="${user.username}"/>
            <input type="hidden" class="form-control" name="password" id="password" placeholder="Password" required value=""/>
            <input type="hidden" class="form-control" name="email" id="email" placeholder="Email" required value="${user.email}"/>
            <label for="position">Position</label>
            <select class="custom-select d-block w-100" name="position" id="position" required>
                <option value="">Chose...</option>
                <option value="CLIENT">Client</option>
                <option value="ADMINISTRATOR">Administrator</option>
                <option value="MANAGER">Manager</option>
            </select>
            <input type="hidden" name="user_id" id="user_id" value="${user.id}"/>
            <hr>
            <button class="btn btn-primary btn-lg btn-block" type="submit">Assign Role</button>
        </form>
    </c:if>
</t:pageTemplate>