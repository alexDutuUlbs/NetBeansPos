<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<t:pageTemplate pageTitle="Add User">
    <div class="container-sm">
        <div class="col-md-3">
            <form method="POST" action="${pageContext.request.contextPath}/AddCustomer">
                <div class="form-group row">
                    <label for="username" class="col-4 col-form-label">Username</label> 
                    <div class="col-8">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fa fa-address-card"></i>
                                </div>
                            </div> 
                            <input id="username" name="username" placeholder="user name" type="text" class="form-control" required="required">
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="psoition" class="col-4 col-form-label">Position</label> 
                    <div class="col-8">
                        <input id="position" name="position" placeholder="position" type="text" class="form-control" required="required">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-4 col-form-label">Email</label> 
                    <div class="col-8">
                        <input id="email" name="email" placeholder="email" type="email" class="form-control" required="required">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-4 col-form-label">Password</label> 
                    <div class="col-8">
                        <input id="password" name="password" placeholder="password" type="password" class="form-control" required="required">
                    </div>
                </div> 
                <div class="form-group row">
                    <div class="offset-4 col-8">
                        <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</t:pageTemplate>
