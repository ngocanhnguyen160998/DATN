<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section id="menu">
    <div class="container">
        <div class="menu-area">
            <!-- Navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse">
                    <!-- Left nav -->
                    <ul class="nav navbar-nav">
                        <li><a href="/">Trang chủ</a></li>
                        <li><a href="/product?page=1&category-id=100001">Văn Học </a></li>
                        <li><a href="/product?page=1&category-id=100002">Kinh Tế </a></li>
                        <li><a href="/product?page=1&category-id=100003">Kỹ Năng Sống </a></li>
                        <li><a href="/product?page=1&category-id=100004">Giáo Dục </a></li>
                        <li><a href="/product?page=1&category-id=100005">Tâm Lý </a></li>
                        <li><a href="/product?page=1&category-id=100006">Giới Trẻ </a></li>
                        <li><a href="/product?page=1&category-id=100007">Ngoại Ngữ </a></li>
                        <li><a href="/product?page=1">Xem Thêm <span class="caret"></span></a></li>
                        <li><a href="/contact">Liên hệ</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>
</section>
</body>
</html>
