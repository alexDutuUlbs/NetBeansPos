<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<t:pageTemplate pageTitle="New Order">
    <div class="container-lg">
        <div class="row">
            <div class="col-4">
                <select name="products" id="products" onclick="changeValue(this)">
                    <option id="0" value="0">Select</option>
                    <c:forEach var="product" items="${products}" varStatus="status">
                        <option id="${product.id}" value="${product.quantity}">${product.name}</option>
                    </c:forEach>
                </select>
                <input type="text" id="quantity" name="quantity" min="1" required="required">
                <button type="button" class="btn btn-dark" onclick="addProductInOrder()">Add to cart</button>
                <div class="alert alert-primary" role="alert" id="alert" style="visibility:hidden"></div>

            </div>
            <div class="col-md-auto" id="orderCart">

            </div>
            <form method="POST" action="${pageContext.request.contextPath}/NewOrder">
                <input type="hidden" id="order">
                <button type="submit" class="btn btn-dark">Process order</button>
            </form>
        </div>

    </div>
    <script>
        var order = "";
        function changeValue(call) {
            var select = document.getElementById('products');
            var id = call.options[select.selectedIndex].id;
            var value = call.options[select.selectedIndex].value;

            console.log(call.options[select.selectedIndex].id);
            console.log(value);
            document.getElementById('quantity').setAttribute("max", value);
        }
        function addProductInOrder() {
            var select = document.getElementById('products');
            var id = select.options[select.selectedIndex].id;
            var quantityValue = document.getElementById("quantity").value;
            if (document.getElementById("quantity").getAttribute("max") < quantityValue || document.getElementById("quantity").getAttribute("min") > quantityValue) {
                document.getElementById("alert").innerHTML = "Quantity should be less than " + document.getElementById("quantity").getAttribute("max");
                document.getElementById("alert").style.visibility = 'visible';
            } else {
                document.getElementById("alert").style.visibility = 'hidden';
                document.getElementById('order').value = document.getElementById('order').value + id + "#" + quantityValue + "#";
                document.getElementById("orderCart").innerHTML += "<p>" + select.options[select.selectedIndex].innerHTML + " quantity: " + quantityValue + "</p>";
            }

        }
        console.log("order" + order);
    </script>
</t:pageTemplate>