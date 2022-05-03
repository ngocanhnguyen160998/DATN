<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Product</title>

    <%@ include file="/common/lib.jsp" %>

</head>
<!-- !Important notice -->
<!-- Only for product page body tag have to added .productPage class -->
<body class="productPage">
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

<!-- product category -->
<section id="aa-product-category">
    <div class="container">
        <div class="row">
            <div class="col-lg-9 col-md-9 col-sm-8 col-md-push-3">
                <div class="aa-product-catg-content">
                    <form action="<c:url value='/product'/>" id="formSubmit" method="get">
                        <div class="aa-product-catg-body">
                            <ul class="aa-product-catg">
                                <!-- start single product item -->
                                <c:forEach var="item" items="${item}">
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="/product-detail?id=${item.id}"><img
                                                    src="<c:url value="${item.image}" />"></a>
                                            <a class="aa-add-card-btn"
                                               href="/cart?id=${item.id}&amount=1&action=insert"><span
                                                    class="fa fa-shopping-cart"></span>Thêm
                                                Giỏ Hàng</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">${item.name}</a></h4>
                                                <c:if test="${item.salePrice == 0}">
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
                                                        <span class="aa-product-price"><del>
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</del></span>
                                                    </c:if>
                                                </c:if>

                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="/wishlist?id=${item.id}&action=insert" data-toggle="tooltip"
                                               data-placement="top"
                                               title="Yêu Thích"><span
                                                    class="fa fa-heart-o"></span></a>
                                        </div>
                                        <!-- product badge -->
                                            <%--                                        <span class="aa-badge aa-sale" href="#">SALE!</span>--%>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <ul class="pagination" id="pagination"
                            style="margin-left: 15%; margin-top: 10px"></ul>
                        <input type="hidden" value="" id="page" name="page"/>
                        <input type="hidden" value="" id="category-id" name="category-id"/>
                        <input type="hidden" value="" id="sort" name="sort"/>
                    </form>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
                <aside class="aa-sidebar">
                    <div class="aa-sidebar-widget">
                        <h3>Sắp Xếp</h3>
                        <ul class="aa-catg-nav">
                            <li><a href="/product?page=1&category-id=${categoryId}&sort=" class="tag-cloud">Mặc Định</a></li>
                            <li><a href="/product?page=1&category-id=${categoryId}&sort=asc" class="tag-cloud">Giá Tăng
                                Dần</a></li>
                            <li><a href="/product?page=1&category-id=${categoryId}&sort=desc" class="tag-cloud">Giá Giảm
                                Dần</a></li>
                        </ul>
                    </div>
                    <!-- single sidebar -->
                    <div class="aa-sidebar-widget">
                        <h3>Thể Loại</h3>
                        <ul class="aa-catg-nav">
                            <c:forEach var="itemCategory" items="${itemCategory}">
                                <li><a href="/product?page=1&category-id=${itemCategory.id}">${itemCategory.name}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </aside>
            </div>

        </div>
    </div>
</section>
<!-- / product category -->

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>

<!-- / footer -->
<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>

<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>

<script>
    var totalPages = ${page.totalPage};
    var currentPage = ${page.page};
    var categoryId = "${categoryId}";
    var sortPrice = "${sortPrice}";

    $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 9,
                startPage: currentPage,
                categoryId: categoryId,
                sort: sortPrice,
                onPageClick: function (event, page) {
                    if (currentPage != page) {
                        $('#page').val(page);
                        $('#category-id').val(categoryId),
                        $('#sort').val(sortPrice),
                        $('#formSubmit').submit();
                    }
                }
            });
        });

</script>

</body>
</html>
