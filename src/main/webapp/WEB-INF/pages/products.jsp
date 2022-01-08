<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="WEB-INF/js/custom_table.js"></script>
</head>
<t:pageTemplate pageTitle="Products">
    <table class="table table-hover w-75 pb-3">
        <thead>
        <tr>
            <th class="th-sm">Name</th>
            <th class="th-sm">Price</th>
            <th class="th-sm">Quantity</th>
            <th class="th-sm">Modify Stock</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="product" items="${products}" varStatus="status">
              <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/ModifyProduct?id=${product.id}" role="button">Modify Stock</a></td>
        </tr>
    </c:forEach>
    </tbody>
        <tfoot>
        
        </tfoot>
    </table>
</t:pageTemplate>
