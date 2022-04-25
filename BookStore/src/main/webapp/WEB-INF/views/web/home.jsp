<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Home</title>

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
<!-- Start slider -->
<section>
    <div class="seq-screen">
        <div class="seq-model">
            <img data-seq src="<c:url value="/template/web/img/slider/banner1.jpg"/>"/>
        </div>
    </div>
</section>
<!-- / slider -->
<!-- Start Promo section -->
<section id="aa-promo">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-promo-area">
                    <div class="row">
                        <!-- promo left -->
                        <div class="col-md-5 no-padding">
                            <div class="aa-promo-left">
                                <div class="aa-promo-banner">
                                    <img src="<c:url value="/template/web/img/vanhoc/vanhoc1.jpg" />" alt="img">
                                    <div class="aa-prom-content">
                                        <h4><a href="/product?page=1&category-id=100001">Văn Học</a></h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- promo right -->
                        <div class="col-md-7 no-padding">
                            <div class="aa-promo-right">
                                <div class="aa-single-promo-right">
                                    <div class="aa-promo-banner">
                                        <img src="<c:url value="/template/web/img/kinhte/kinhte1.jpg" />" alt="img">
                                        <div class="aa-prom-content">
                                            <h4><a href="/product?page=1&category-id=100002">Kinh Tế</a></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="aa-single-promo-right">
                                    <div class="aa-promo-banner">
                                        <img src="<c:url value="/template/web/img/kynangsong/kynangsong1.jpg" />"
                                             alt="img">
                                        <div class="aa-prom-content">
                                            <h4><a href="/product?page=1&category-id=100003">Kỹ Năng Sống</a></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="aa-single-promo-right">
                                    <div class="aa-promo-banner">
                                        <img src="<c:url value="/template/web/img/ngoaingu/ngoaingu1.jpg" />" alt="img"
                                             title="Ngoại Ngữ">
                                        <div class="aa-prom-content">
                                            <h4><a href="/product?page=1&category-id=100007">Ngoại Ngữ</a></h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="aa-single-promo-right">
                                    <div class="aa-promo-banner">
                                        <img src="<c:url value="/template/web/img/tamly/tamly1.jpg" />" alt="img">
                                        <div class="aa-prom-content">
                                            <h4><a href="/product?page=1&category-id=100005">Tâm Lý</a></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Promo section -->
<!-- Products section -->
<section id="aa-product">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-product-area">
                        <div class="aa-product-inner">
                            <!-- start prduct navigation -->
                            <ul class="nav nav-tabs aa-products-tab">
                                <li class="active"><a href="#vanhoc" data-toggle="tab">Văn Học</a></li>
                                <li><a href="#kynangsong" data-toggle="tab">Kỹ Năng Sống</a></li>
                                <li><a href="#giaoduc" data-toggle="tab">Giáo Dục</a></li>
                                <li><a href="#kinhte" data-toggle="tab">Kinh Tế</a></li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <!-- Start men product category -->
                                <div class="tab-pane fade in active" id="vanhoc">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${lstProductVanHoc}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                            src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                    <a class="aa-add-card-btn" href="/product-detail?id=${item.id}"><span
                                                            class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="#">${item.name}</a></h4>
                                                        <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                        </c:if>
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
                                                    <a href="#" data-toggle="tooltip" data-placement="top"
                                                       title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" href="/product?page=1&category-id=100001" style="margin-left: 44%">Xem Thêm <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                                <!-- / men product category -->
                                <!-- start women product category -->
                                <div class="tab-pane fade" id="kynangsong">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${lstProductKyNangSong}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                            src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                    <a class="aa-add-card-btn" href="/product-detail?id=${item.id}"><span
                                                            class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="#">${item.name}</a></h4>
                                                        <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                        </c:if>
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
                                                    <a href="#" data-toggle="tooltip" data-placement="top"
                                                       title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" href="/product?page=1&category-id=100003" style="margin-left: 44%">Xem Thêm <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                                <!-- / women product category -->
                                <!-- start sports product category -->
                                <div class="tab-pane fade" id="giaoduc">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${lstProductGiaoDuc}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                            src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                    <a class="aa-add-card-btn" href="/product-detail?id=${item.id}"><span
                                                            class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="#">${item.name}</a></h4>
                                                        <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                        </c:if>
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
                                                    <a href="#" data-toggle="tooltip" data-placement="top"
                                                       title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" href="/product?page=1&category-id=100004" style="margin-left: 44%">Xem Thêm <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                                <!-- / sports product category -->
                                <!-- start electronic product category -->
                                <div class="tab-pane fade" id="kinhte">
                                    <ul class="aa-product-catg">
                                        <c:forEach var="item" items="${lstProductKinhTe}">
                                            <li>
                                                <figure>
                                                    <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                            src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                    <a class="aa-add-card-btn" href="/product-detail?id=${item.id}"><span
                                                            class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                    <figcaption>
                                                        <h4 class="aa-product-title"><a href="#">${item.name}</a></h4>
                                                        <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                        </c:if>
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
                                                    <a href="#" data-toggle="tooltip" data-placement="top"
                                                       title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                    <a class="aa-browse-btn" href="/product?page=1&category-id=100002" style="margin-left: 44%">Xem Thêm <span
                                            class="fa fa-long-arrow-right"></span></a>
                                </div>
                                <!-- / electronic product category -->
                            </div>
                            <br/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Products section -->
<!-- banner section -->
<section id="aa-banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-banner-area">
                        <a href="#"><img src="<c:url value="/template/web/img/slider/banner2.jpg" />"
                                         alt="fashion banner img"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- popular section -->
<section id="aa-popular-category">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-popular-category-area">
                        <!-- start prduct navigation -->
                        <ul class="nav nav-tabs aa-products-tab">
                            <li class="active"><a href="#hot" data-toggle="tab">HOT</a></li>
                            <li><a href="#sale" data-toggle="tab">Giảm Giá</a></li>
                            <li><a href="#new" data-toggle="tab">Mới</a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <!-- Start men popular category -->
                            <div class="tab-pane fade in active" id="hot">
                                <ul class="aa-product-catg aa-popular-slider">
                                    <c:forEach var="item" items="${lstProductHot}">
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                        src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                <a class="aa-add-card-btn" href="/product-detail?id=${item.id}"><span
                                                        class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="#">${item.name}</a></h4>
                                                    <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
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
                                                <a href="#" data-toggle="tooltip" data-placement="top"
                                                   title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-hot" href="#">HOT!</span>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <a class="aa-browse-btn" href="#" style="margin-left: 44%">Xem Thêm <span
                                        class="fa fa-long-arrow-right"></span></a>
                            </div>
                            <!-- / popular product category -->

                            <!-- start featured product category -->
                            <div class="tab-pane fade" id="sale">
                                <ul class="aa-product-catg aa-featured-slider">
                                    <c:forEach var="item" items="${lstProductSale}">
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                        src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                <a class="aa-add-card-btn" href="#"><span
                                                        class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="/product-detail?id=${item.id}">${item.name}</a></h4>
                                                    <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
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
                                                <a href="#" data-toggle="tooltip" data-placement="top"
                                                   title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sale" href="#">SALE!</span>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <a class="aa-browse-btn" href="#" style="margin-left: 44%">Xem Thêm <span
                                        class="fa fa-long-arrow-right"></span></a>
                            </div>
                            <!-- / featured product category -->

                            <!-- start latest product category -->
                            <div class="tab-pane fade" id="new">
                                <ul class="aa-product-catg aa-latest-slider">
                                    <c:forEach var="item" items="${lstProductNew}">
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="/product-detail?id=${item.id}" style="text-align: center"><img
                                                        src="<c:url value="${item.image}"/>" style="display: inline-block"></a>
                                                <a class="aa-add-card-btn" href="#"><span
                                                        class="fa fa-shopping-cart"></span>Thêm Giỏ Hàng</a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="/product-detail?id=${item.id}">${item.name}</a></h4>
                                                    <c:if test="${item.salePrice == null}">
                                                        <span class="aa-product-price">
                                                            <fmt:formatNumber
                                                                    value="${item.price}"
                                                                    type="number"></fmt:formatNumber>đ</span>
                                                    </c:if>
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
                                                <a href="#" data-toggle="tooltip" data-placement="top"
                                                   title="Yêu Thích"><span class="fa fa-heart-o"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sold-out" href="#">New!</span>
                                        </li>
                                    </c:forEach>
                                </ul>
                                <a class="aa-browse-btn" href="#" style="margin-left: 44%">Xem Thêm <span
                                        class="fa fa-long-arrow-right"></span></a>
                            </div>
                            <!-- / latest product category -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / popular section -->
<!-- Support section -->
<section id="aa-support">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-support-area">
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-truck"></span>
                            <h4>MIỄN PHÍ GIAO HÀNG</h4>
                            <P>Miễn phí giao hàng cho các đơn hàng có giá trị từ 500.000đ trở lên.</P>
                        </div>
                    </div>
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-clock-o"></span>
                            <h4>ĐỔI TRẢ TRONG VÒNG 3 NGÀY</h4>
                            <P>Thực hiện đổi trả sản phẩm mới nếu sản phẩm gặp lỗi từ nhà sản xuất.</P>
                        </div>
                    </div>
                    <!-- single support -->
                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <div class="aa-support-single">
                            <span class="fa fa-phone"></span>
                            <h4>HỖ TRỢ 24/7</h4>
                            <P>Hỗ trợ, tư vấn các sản phẩm cho khách hàng mọi lúc, mọi nơi.</P>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- / footer -->

<!-- Login Modal -->

<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>


</body>
</html>
