<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>


</head>
<t:pageTemplate pageTitle="Orders">
    <div class="container-lg">
        <h1>Test</h1>
        <div id="accordion">
            <c:forEach var="orderId" items="${orderIdList}" varStatus="status">
                <div class="card">
                    <div class="card-header" id="card_id${orderId.id}">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                Order with Id ${orderId.id}
                            </button>
                        </h5>
                    </div>
                    <div id="collapse_id${orderid.id}" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
                            <c:forEach var="orderItem" items="${orderList}" varStatus="status">
                                <p>${orderItem.idProduct}</p>
                            </c:forEach>
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
