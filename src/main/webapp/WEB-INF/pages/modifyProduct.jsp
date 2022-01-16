<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<t:pageTemplate pageTitle="Edit User">
    <form class="needs-validation w-25" novalidate method="POST" action="${pageContext.request.contextPath}/ModifyProduct">
        <label for="productName">Name</label>
        <input type ="text" class="form-control" name="productName" id="productName" placeholder="productName" required value="${product.name}"/>
        <label for="productPrice">Price</label>
        <input type ="text" class="form-control" name="productPrice" id="productPrice" placeholder="productPrice" required value="${product.price}"/>
        <label>Current:${product.quantity}</label>
        <input type="hidden" name="initialQuantity" id="initialQuantity" value="${product.quantity}"/>
        <label for="productQuantity">Quantity to add:</label>
        <input type ="text" class="form-control" name="productQuantity" id="productQuantity" placeholder="Add quantity" required value=""/>
        <input type="hidden" name="productId" id="productId" value="${product.id}"/>  
        <hr>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
    </form>
</t:pageTemplate>