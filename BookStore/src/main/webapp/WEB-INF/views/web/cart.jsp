<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Cart Page</title>

    <%@include file="/common/lib.jsp"%>

</head>
<body>

<!-- wpf loader Two -->
<div id="wpf-loader-two">
    <div class="wpf-loader-two-inner">
        <span>Loading</span>
    </div>
</div>
<!-- / wpf loader Two -->
<!-- SCROLL TOP BUTTON -->
<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
<!-- END SCROLL TOP BUTTON -->


<!-- Start header section -->
<%@ include file="/common/web/header.jsp" %>
<!-- / header section -->
<!-- menu -->
<%@ include file="/common/web/menu.jsp" %>
<!-- / menu -->

<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="<c:url value="/template/web/img/fashion/fashion-header-bg-8.jpg" />" alt="fashion img">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Cart Page</h2>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                    <li class="active">Cart</li>
                </ol>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="cart-view">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="cart-view-area">
                    <div class="cart-view-table">
                        <form action="">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                        <th>Product</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                                        <td><a href="#"><img src="<c:url value="/template/web/img/man/polo-shirt-1.png" />" alt="img"></a></td>
                                        <td><a class="aa-cart-title" href="#">Polo T-Shirt</a></td>
                                        <td>$250</td>
                                        <td><input class="aa-cart-quantity" type="number" value="1"></td>
                                        <td>$250</td>
                                    </tr>
                                    <tr>
                                        <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                                        <td><a href="#"><img src="<c:url value="/template/web/img/man/polo-shirt-2.png" />" alt="img"></a></td>
                                        <td><a class="aa-cart-title" href="#">Polo T-Shirt</a></td>
                                        <td>$150</td>
                                        <td><input class="aa-cart-quantity" type="number" value="1"></td>
                                        <td>$150</td>
                                    </tr>
                                    <tr>
                                        <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                                        <td><a href="#"><img src="<c:url value="/template/web/img/man/polo-shirt-3.png" />"alt="img"></a></td>
                                        <td><a class="aa-cart-title" href="#">Polo T-Shirt</a></td>
                                        <td>$50</td>
                                        <td><input class="aa-cart-quantity" type="number" value="1"></td>
                                        <td>$50</td>
                                    </tr>
                                    <tr>
                                        <td colspan="6" class="aa-cart-view-bottom">
                                            <div class="aa-cart-coupon">
                                                <input class="aa-coupon-code" type="text" placeholder="Coupon">
                                                <input class="aa-cart-view-btn" type="submit" value="Apply Coupon">
                                            </div>
                                            <input class="aa-cart-view-btn" type="submit" value="Update Cart">
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                        <!-- Cart Total view -->
                        <div class="cart-view-total">
                            <h4>Cart Totals</h4>
                            <table class="aa-totals-table">
                                <tbody>
                                <tr>
                                    <th>Subtotal</th>
                                    <td>$450</td>
                                </tr>
                                <tr>
                                    <th>Total</th>
                                    <td>$450</td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="#" class="aa-cart-view-btn">Proced to Checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->

<!-- Subscribe section -->
<%@ include file="/common/web/subscribe.jsp" %>
<!-- / Subscribe section -->

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- / footer -->
<!-- Login Modal -->
<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>





</body>
</html>
