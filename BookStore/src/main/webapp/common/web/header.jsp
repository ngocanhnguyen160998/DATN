<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-top-area">
                        <!-- start header top left -->
                        <div class="aa-header-top-left">
                            <!-- start language -->
                            <div class="aa-language">
                                <div class="dropdown">
                                    <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        VIETNAM
                                        <span class="caret"></span>
                                    </a>
                                </div>
                            </div>
                            <!-- / language -->

                            <!-- start currency -->
                            <div class="aa-currency">
                                <div class="dropdown">
                                    <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu3"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        VND
                                        <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li><a href="#"><i class="fa fa-euro"></i>EURO</a></li>
                                        <li><a href="#"><i class="fa fa-jpy"></i>USD</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- / currency -->
                            <!-- start cellphone -->
                            <div class="cellphone hidden-xs">
                                <p><span class="fa fa-phone"></span>0914.663.198</p>
                            </div>
                            <!-- / cellphone -->
                        </div>
                        <!-- / header top left -->
                        <div class="aa-header-top-right">
                            <ul class="aa-head-top-nav-right">
                                <c:if test="${userSession == null}">
                                    <li><a href="/account">Đăng Ký</a></li>
                                    <li class="hidden-xs"><a href="/wishlist?page=1">Yêu thích</a></li>
                                    <li class="hidden-xs"><a href="/cart?page=1">Giỏ hàng</a></li>
                                    <li class="hidden-xs"><a href="/checkout">Thanh toán</a></li>
                                    <li><a href="/login-modal" data-toggle="modal" data-target="#login-modal">Đăng nhập</a></li>
                                </c:if>
                                <c:if test="${userSession != null}">
<%--                                    <li><a href="/account">Đăng Ký</a></li>--%>
                                    <li class="hidden-xs"><a href="/wishlist?page=1">Yêu thích</a></li>
                                    <li class="hidden-xs"><a href="/cart?page=1">Giỏ hàng</a></li>
                                    <li class="hidden-xs"><a href="/checkout">Thanh toán</a></li>
                                    <li><a href="/logout">Đăng xuất</a></li>
                                    <li><a data-toggle="modal" data-target="">Hello, ${userSession.userName}</a></li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header top  -->

    <!-- start header bottom  -->
    <div class="aa-header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-bottom-area">
                        <!-- logo  -->
                        <div class="aa-logo">
                            <!-- Text based logo -->
                            <a href="/">
                                <span class="fa fa-shopping-cart"></span>
                                <p>TrangAnh<strong>Shop</strong> <span>Your Shopping Partner</span></p>
                            </a>
                            <!-- img based logo -->
                            <!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
                        </div>
                        <!-- / logo  -->
                        <!-- search box -->
                        <div class="aa-search-box">
                            <form:form id="formSearch" action="/product" modelAttribute="search" method="post">
                                <form:input path="input" class="form-control form-control-sidebar" type="search"
                                            placeholder="Tìm kiếm"
                                            aria-label="Search" name="search"></form:input>
                                <div class="input-group-append">
                                    <button class="btn btn-navbar" type="submit">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </form:form>
                        </div>
                        <!-- / search box -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header bottom  -->
</header>
</body>
</html>
