<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
</head>
<t:pageTemplate pageTitle="Returns">
    <div class="container-lg">
        <div class="row">
            <div class="col-4">
                <form method="POST" action="${pageContext.request.contextPath}/Returns">
                    <div class="form-group row">
                        <label for="orderId" class="col-4 col-form-label">OrderId</label>
                        <div class="col-8">
                            <div class="input-group">
                                <input id="orderId" name="orderId" type="text" class="form-control" required="required">
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="offset-4 col-8">
                            <button name="submit" type="submit" class="btn btn-primary">Search Order</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-auto">
                <table class="table table-hover w-75">
                    <thead>
                        <tr>
                            <th class="th-sm">Product Name</th>
                            <th class="th-sm">Product Unit Price</th>
                            <th class="th-sm">Product Quantity</th>
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
                <c:if>
                    
                </c:if>
            </div>
        </div>

    </div>

</t:pageTemplate>
