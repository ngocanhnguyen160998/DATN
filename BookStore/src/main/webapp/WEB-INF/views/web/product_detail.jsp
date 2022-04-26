<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Product Detail</title>

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

<!-- product category -->
<section id="aa-product-details">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-product-details-area">
                    <div class="aa-product-details-content">
                        <div class="row">
                            <!-- Modal view slider -->
                            <div class="col-md-5 col-sm-5 col-xs-12">
                                <div class="aa-product-view-slider">
                                    <div id="demo-1" class="simpleLens-gallery-container">
                                        <div class="simpleLens-container">
                                            <div class="simpleLens-big-image-container"><img
                                                    src="<c:url value="${item.image}" />" class="simpleLens-big-image">
                                            </div>
                                        </div>
                                    </div>
                                    <h4 style="margin-top: 10px; font-style: italic; color: #313894;">Tác giả: ${item.author}</h4>
                                </div>
                            </div>
                            <!-- Modal view content -->
                            <div class="col-md-7 col-sm-7 col-xs-12">
                                <div class="aa-product-view-content">
                                    <h2 style="color: #313894">${item.name}</h2>
                                    <div class="aa-price-block">
                                        <p class="aa-product-avilability" style="color: #313894; font-weight: bold">Tình
                                            trạng:
                                            <c:if test="${warehouse.amount > 0}">
                                                <span style="color: green">Còn hàng</span>
                                            </c:if>
                                            <c:if test="${warehouse.amount <= 0}">
                                                <span style="color: red">Hết hàng</span>
                                            </c:if>
                                        </p>
                                    </div>
                                    <p style="text-align: justify; color: #313894">${item.info}</p>
                                    <div class="aa-prod-quantity" style="color: #313894; font-weight: bold">
                                        Số lượng: &nbsp;
                                        <form action="">
                                            <input class="aa-cart-quantity" type="number" value="1" min="1" max="${warehouse.amount}">
                                        </form>
                                        <p class="aa-prod-category">
                                            Thể loại: ${category.name}
                                        </p><br/>
                                        <span class="aa-product-view-price"
                                              style="color: red; font-weight: bold; font-size: x-large">
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
                                                        <span class="aa-product-price" style="margin-left: 20px"><del>
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</del></span>
                                                </c:if>
                                            </c:if>
                                        </span>
                                    </div>
                                    <div class="aa-prod-view-bottom" style="color: #313894">
                                        <a class="aa-add-to-cart-btn" href="#">Thêm Giỏ Hàng</a>
                                        <a class="aa-add-to-cart-btn" href="#">Yêu Thích</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="aa-product-details-bottom">
                        <ul class="nav nav-tabs" id="myTab2">
                            <li><a href="#description" data-toggle="tab" style="color: #2c3576; font-weight: bold">Mô Tả
                                Sản Phẩm</a></li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="description"
                                 style="text-align: justify; color: #313894">
                                ${item.descriptions}
                            </div>
                        </div>
                        <div class="aa-product-related-item">
                            <h3 style="font-weight: bold; color: #313894">Sản Phẩm Liên Quan</h3>
                            <ul class="aa-product-catg aa-related-item-slider">
                                <c:forEach var="productRelated" items="${productRelated}">
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="/product-detail?id=${productRelated.id}" style="text-align: center"><img
                                                    src="<c:url value="${productRelated.image}" />" style="display: inline-block"
                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="/product-detail?id=${productRelated.id}"><span
                                                    class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">${productRelated.name}</a></h4>
                                                <span class="aa-product-price">
                                                    <c:if test="${productRelated.salePrice == 0}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${productRelated.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
                                                    <c:if test="${productRelated.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${productRelated.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
                                                    <c:if test="${productRelated.price <= productRelated.salePrice}">
                                                                <span class="aa-product-price">
                                                                    <fmt:formatNumber
                                                                            value="${productRelated.price}"
                                                                            type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
                                                    <c:if test="${productRelated.salePrice > 0}">
                                                        <c:if test="${productRelated.price > productRelated.salePrice}">
                                                                <span class="aa-product-price">
                                                                    <fmt:formatNumber
                                                                            value="${productRelated.salePrice}"
                                                                            type="number"></fmt:formatNumber>đ</span>
                                                            <span class="aa-product-price"><del>
                                                                    <fmt:formatNumber
                                                                            value="${productRelated.price}"
                                                                            type="number"></fmt:formatNumber>đ</del></span>
                                                        </c:if>
                                                    </c:if>
                                                </span>

                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="Add to Wishlist"><span class="fa fa-heart-o"></span></a>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
<!-- / product category -->

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- / footer -->
<!-- Login Modal -->
<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>

</body>
</html>
