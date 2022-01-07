<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<t:pageTemplate pageTitle="New Order">
    <div class="container-lg">
    <div class="row">
        <div class="col-4">

        </div>
        <div class="col-md-auto">
            <form>
                <div class="form-group row">
                    <label for="productId" class="col-4 col-form-label">Product id</label>
                    <div class="col-8">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <i class="fa fa-jsfiddle"></i>
                                </div>
                            </div>
                            <input id="productId" name="productId" placeholder="Id" type="text" class="form-control" required="required">
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="quantity" class="col-4 col-form-label">Quantity</label>
                    <div class="col-8">
                        <input id="quantity" name="quantity" placeholder="quantity" type="text" class="form-control" required="required">
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

</div>

</t:pageTemplate>