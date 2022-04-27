<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Wishlist Page</title>

    <%@ include file="/common/lib.jsp" %>

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
<%@ include file="/common/web/banner.jsp" %>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="cart-view">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="cart-view-area">
                    <div class="cart-view-table aa-wishlist-table">
                        <form action="">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                        <th>Sản Phẩm</th>
                                        <th>Giá</th>
                                        <th>Tình Trạng</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
<%--                                    <c:forEach var="item" items="">--%>
                                        <tr>
                                            <td><a class="remove" href="#"><fa class="fa fa-close"></fa></a></td>
                                            <td><a href="#"><img src="<c:url value="/image/hai-van-dam-duoi-bien.png" />" alt="img"></a></td>
                                            <td><a class="aa-cart-title" href="#">OK CON DE</a></td>
                                            <td>$250</td>
                                            <td>In Stock</td>
                                            <td><a href="#" class="aa-add-to-cart-btn">Thêm Giỏ Hàng</a></td>
                                        </tr>
<%--                                    </c:forEach>--%>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>

<!-- / footer -->
<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>


</body>
</html>
