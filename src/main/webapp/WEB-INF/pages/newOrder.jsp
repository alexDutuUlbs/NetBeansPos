<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<t:pageTemplate pageTitle="New Order">
    <div class="container-lg">
        <div class="row">
            <div class="col-4">
                <select name="products" id="products">
                    <option id="0" value="0" min="0" max="0">Select</option>
                    <c:forEach var="product" items="${products}" varStatus="status">
                        <option id="${product.id}" value="${product.quantity}" data-price="${product.price}">${product.name}</option>
                    </c:forEach>
                </select>
                <input type="number" id="quantity" name="quantity" min="1" required="required">
                <button type="button" class="btn btn-dark" id="addToCart">Add to cart</button>
                <div class="alert alert-primary" role="alert" id="alert" style="visibility:hidden"></div>

            </div>
            <div class="col-md-auto" id="orderCart">

            </div>
            <div id="subtotal"></div>
            <form method="POST" action="${pageContext.request.contextPath}/NewOrder">
                <input type="hidden" id="order" name="order">
                <button type="submit" class="btn btn-dark">Process order</button>
            </form>
        </div>

    </div>
    <script>
        var subtotal = parseFloat(0);
        var productPrice = parseFloat(0);
        function addProductInOrder() {
            var select = document.getElementById('products');
            var id = select.options[select.selectedIndex].id;
            var quantityValue = parseInt(document.getElementById("quantity").value);
            
            if (parseInt(document.getElementById("quantity").getAttribute("max")) < quantityValue || parseInt(document.getElementById("quantity").getAttribute("min")) > quantityValue) {
                document.getElementById("alert").innerHTML = "Quantity should be less than " + document.getElementById("quantity").getAttribute("max");
                document.getElementById("alert").style.visibility = 'visible';
            } else {
                document.getElementById("alert").style.visibility = 'hidden';
                document.getElementById('order').value = document.getElementById('order').value + id + "#" + quantityValue + "#";
                document.getElementById("orderCart").innerHTML += "<p>" + select.options[select.selectedIndex].innerHTML + " quantity: " + quantityValue + "</p>";
                subtotal+=productPrice*quantityValue;
                document.getElementById("subtotal").innerHTML ="<h3>Total= "+subtotal;
            }

        }
        $(document).ready(function () {

            $("#products").change(function () {
                productPrice = parseFloat($(this).find('option:selected').data('price'));
                var id = $(this).children(":selected").attr("id");
                var value = $(this).children(":selected").attr("value");

                console.log(id);
                console.log(value);
                document.getElementById('quantity').setAttribute("max", value);
            });

            $("#addToCart").click(function () {
                addProductInOrder();
            });
        });
    </script>
</t:pageTemplate>