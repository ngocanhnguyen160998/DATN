<%@include file="/common/taglib.jsp" %>
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
                        <form action="<c:url value='/wishlist'/>" id="formSubmit" method="get">
                            <div>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <td colspan="6" style="text-align: center">
                                            <h2>DANH SÁCH YÊU THÍCH</h2>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="width: 50px"></th>
                                        <th style="width: 200px"></th>
                                        <th style="width: 350px">Sản Phẩm</th>
                                        <th style="width: 200px">Giá</th>
                                        <th style="width: 120px">Tình Trạng</th>
                                        <th style="width: 200px"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${item}">
                                        <tr>
                                            <td><a class="remove"
                                                   href="/wishlist?id=${item.productId}&action=delete">
                                                <fa class="fa fa-close"></fa>
                                            </a></td>
                                            <td><a href="product-detail?id=${item.productId}"><img
                                                    src="<c:url value="${item.image}" />" alt="img"></a></td>
                                            <td><a class="aa-cart-title"
                                                   href="product-detail?id=${item.productId}">${item.productName}</a>
                                            </td>
                                            <td>
                                                <c:if test="${item.salePrice == 0}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                </c:if>
                                                <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                </c:if>
                                                <c:if test="${item.price <= item.salePrice}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                </c:if>
                                                <c:if test="${item.salePrice > 0}">
                                                    <c:if test="${item.price > item.salePrice}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.salePrice}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
                                                </c:if>

                                            </td>
                                            <td>
                                                <c:if test="${item.amount > 0}">Còn hàng</c:if>
                                                <c:if test="${item.amount <= 0}">Hết hàng</c:if>
                                            </td>
                                            <td><a href="/cart?id=${item.productId}&amount=1&action=insert" class="aa-add-to-cart-btn">Thêm Giỏ Hàng</a></td>
                                        </tr>

                                    </c:forEach>
<%--                                    <tr>--%>
<%--                                        <td colspan="6">--%>
<%--                                            <ul class="pagination" id="pagination"></ul>--%>
<%--                                            <input type="hidden" value="" id="page" name="page"/>--%>
<%--                                        </td>--%>
<%--                                    </tr>--%>
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


<script>
    <%--var totalPages = ${page.totalPage};--%>
    <%--var currentPage = ${page.page};--%>
    <%--$(function () {--%>
    <%--    window.pagObj = $('#pagination').twbsPagination({--%>
    <%--        totalPages: totalPages,--%>
    <%--        visiblePages: 3,--%>
    <%--        startPage: currentPage,--%>
    <%--        onPageClick: function (event, page) {--%>
    <%--            if (currentPage != page) {--%>
    <%--                $('#page').val(page);--%>
    <%--                $('#formSubmit').submit();--%>
    <%--            }--%>
    <%--        }--%>
    <%--    });--%>
    <%--});--%>
</script>

</body>
</html>
