<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <c:choose>
        <c:when test="${pageContext.request.getRemoteUser() == null}">
            <head>
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <link rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css">
            </head>
            <body id="LoginForm">
                <div class="container">
                    <div class="login-form">
                        <div class="main-div">
                            <div class="panel">
                                <h1>User Login</h1>
                                <p>Please enter your username and password</p>
                            </div>
                            <form id="Login" method="POST" action="j_security_check">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="username" placeholder="Username" name="j_username">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" id="password" placeholder="Password" name="j_password">
                                </div>
                                <button type="submit" class="btn btn-primary">Login</button>
                            </form>
                            <hr class="separator">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Dashboard" role="button">Visit</a>
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </c:when>
    <c:otherwise>
        <%response.sendRedirect(request.getContextPath() + "/Dashboard");%>
    </c:otherwise>
</c:choose>
