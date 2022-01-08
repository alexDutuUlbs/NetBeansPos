<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

</head>
<t:pageTemplate pageTitle="Orders">

    <div class="container-lg">
        <h1>Test</h1>
        <div id="accordion">
            <c:forEach var="order" items="${orderIdList}" varStatus="status">
                <div class="card">
                    <div class="card-header" id="card_id${order.id}">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Order with Id ${order.id}
                            </button>
                        </h5>
                    </div>

                    <div id="collapse_id" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
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
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

    </div>
    <script>
        $(document).ready(function () {

            $('.collapse').collapse()
        });

    </script>

</t:pageTemplate>
