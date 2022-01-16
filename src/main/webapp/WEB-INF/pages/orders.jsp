<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Orders">
    <div class="container-lg">
        <c:forEach var="order" items="${orderIdList}" varStatus="status">
            <table class="table table-hover w-75">
                <thead>
                    <tr>
                        <th class="th-lg">Order id: ${order.id}</th>
                        <th class="th-lg">Total: ${order.total}</th>
                        <th class="th-lg">Date: ${order.getDateAsString()}</th>
                    </tr>
                    <tr>
                        <th class="th-lg w-25">Product Name</th>
                        <th class="th-lg w-25">Product Unit Price</th>
                        <th class="th-lg w-25">Product Quantity</th>   
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${orderDetails}" varStatus="status">
                        <c:if test="${order.id eq product.orderId }">
                            <tr>
                                <td>${product.productNamename}</td>
                                <td>${product.price}</td>
                                <td>${product.getOrderQuantity()}</td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
                <tfoot>
                </tfoot>
            </table>
        </c:forEach>
    </t:pageTemplate>
