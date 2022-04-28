<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Cart Page</title>

    <%@include file="/common/lib.jsp" %>

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
                    <div class="cart-view-table">
                        <form action="<c:url value='/cart'/>" id="formSubmit" method="get">
                            <div class="table-responsive" style="width: 1000px">
                                <table class="table" >
                                    <thead>
                                    <tr>
                                        <td colspan="6" style="text-align: center">
                                            <h2>GIỎ HÀNG</h2>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 50px"></th>
                                        <th style="width: 150px"></th>
                                        <th style="width: 300px">Sản Phẩm</th>
                                        <th style="width: 150px">Giá</th>
                                        <th style="width: 100px">Số Lượng</th>
                                        <th style="width: 150px">Tổng Tiền</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${item}">
                                        <tr>
                                            <td><a class="remove" href="/cart?page=1&id=${item.productId}&action=delete">
                                                <fa class="fa fa-close"></fa>
                                            </a></td>
                                            <td><a href="product-detail?id=${item.productId}"><img src="<c:url value="${item.image}" />"
                                                                 alt="img"></a></td>
                                            <td><a class="aa-cart-title" href="product-detail?id=${item.productId}">${item.productName}</a></td>
                                            <td><fmt:formatNumber
                                                    value="${item.total/item.amount}"
                                                    type="number"></fmt:formatNumber>đ</td>
                                            <td>
                                                <input class="aa-cart-quantity" type="number" value="${item.amount}" min="1" max="20">
                                            </td>
                                            <td><fmt:formatNumber
                                                    value="${item.total}"
                                                    type="number"></fmt:formatNumber>đ</td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td colspan="6">
                                            <ul class="pagination" id="pagination"></ul>
                                            <input type="hidden" value="" id="page" name="page"/>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <input class="aa-cart-view-btn" type="submit" value="Cập Nhập Giỏ Hàng">

                            </div>
                        </form>
                        <!-- Cart Total view -->
                        <div class="cart-view-total">
                            <h4>Tổng</h4>
                            <table class="aa-totals-table">
                                <tbody>
                                <tr>
                                    <th>Tổng Tiền</th>
                                    <td><fmt:formatNumber
                                            value="${totalPrice}"
                                            type="number"></fmt:formatNumber>đ</td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="#" class="aa-cart-view-btn">Đặt Hàng</a>
                        </div>
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
<!-- Login Modal -->
<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>


<script>
    var totalPages = ${page.totalPage};
    var currentPage = ${page.page};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 3,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#page').val(page);
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>


</body>
</html>
