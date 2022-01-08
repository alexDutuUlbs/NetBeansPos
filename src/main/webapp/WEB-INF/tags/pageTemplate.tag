<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@tag description="Page Template" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle"%>

<html>
    <head>
        <title>${pageTitle}</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link rel="canonical" href="https://icons.getbootstrap.com/icons/cart4/">
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link re="stylesheet" href="${pageContext.request.contextPath}/style/template.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row flex-nowrap">
                <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
                    <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                            <a href="/" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                                <span class="fs-5 d-none d-sm-inline">${pageTitle}</span>
                            </a>
                            <li class="nav-item">
                                <a href="${pageContext.request.contextPath}/Dashboard" class="nav-link align-middle px-0">
                                    <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
                                </a>
                            </li>
                            <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                                <li>
                                    <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                                        <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Operations</span> </a>
                                    <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                                        <li class="w-100">
                                            <a href="${pageContext.request.contextPath}/NewOrder" class="nav-link px-0"> <span class="d-none d-sm-inline">New Order</span></a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/Return" class="nav-link px-0"> <span class="d-none d-sm-inline">Return</span></a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/Orders" class="nav-link px-0 align-middle">
                                        <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Orders</span></a>
                                </li>
                            </c:if>
                            <li>
                                <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                                    <i class="fs-4 bi-grid"></i> <span class="ms-1 d-none d-sm-inline">Products</span> </a>
                                <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                                    <li class="w-100">
                                        <a href="${pageContext.request.contextPath}/Products" class="nav-link px-0"> <span class="d-none d-sm-inline">Product List</span></a>
                                    </li>
                                    <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/AddProduct" class="nav-link px-0"> <span class="d-none d-sm-inline">Add Product</span></a>
                                        </li>
                                    </c:if>
                                </ul>
                            </li>
                            <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
                                <li>
                                    <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                                        <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Customers</span> </a>
                                    <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                                        <li class="w-100">
                                            <a href="${pageContext.request.contextPath}/Customers" class="nav-link px-0"> <span class="d-none d-sm-inline">Customers</span></a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/AddCustomer" class="nav-link px-0"> <span class="d-none d-sm-inline">Add Customers</span></a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                        </ul>
                        <hr>
                        <div class="dropdown pb-4">
                            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png" alt="hugenerd" width="30" height="30" class="rounded-circle">
                                <span class="d-none d-sm-inline mx-1">${pageContext.request.getRemoteUser()}</span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                                <c:if test="${pageContext.request.isUserInRole('ManagerRole')}">
                                    <li>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/Pending">Pending</a>
                                    </li>
                                </c:if>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/EditProfile">Profile</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li>
                                    <c:choose>
                                        <c:when test="${pageContext.request.getRemoteUser() == null}">
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Login">Sign In</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Sign out</a>
                                        </c:otherwise>
                                    </c:choose>  
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>


                <jsp:doBody/>
            </div>
        </div>
    </body>
</html>