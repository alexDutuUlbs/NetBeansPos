<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<head>

    <link re="stylesheet" href="${pageContext.request.contextPath}/style/custom_table.css">
    <script src="${pageContext.request.contextPath}/js/custom_table.js"></script>
</head>
<t:pageTemplate pageTitle="Returns" template="return-temp">
    <div class="container-lg">
    <div class="row">
        <div class="col-4">

        </div>
        <div class="col-md-auto">
            <form>
                <div class="form-group row">
                    <label for="orderId" class="col-4 col-form-label">OrderId</label>
                    <div class="col-8">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fa fa-address-card"></i>
                                </div>
                            </div>
                            <input id="orderId" name="orderId" type="text" class="form-control" required="required">
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-4 col-8">
                        <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
        </div>
    </div>

</div>

</t:pageTemplate>
