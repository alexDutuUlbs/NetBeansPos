<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Products">
    <table class="table table-hover w-75 pb-3">
        <thead>
            <tr>
                <th class="th-sm">Name</th>
                <th class="th-sm">Price</th>
                <th class="th-sm">Quantity</th>
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                    <th class="th-sm">Modify Stock</th>
                    </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}" varStatus="status">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                        <td><a class="btn btn-secondary" href="${pageContext.request.contextPath}/ModifyProduct?id=${product.id}" role="button">Modify Stock</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</t:pageTemplate>
