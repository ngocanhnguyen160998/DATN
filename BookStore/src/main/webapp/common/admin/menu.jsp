<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/admin/home" class="brand-link">
        <img src="<c:url value="/template/admin/dist/img/AdminLTELogo.png" />" alt="AdminLTE Logo"
             class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Admin</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- SidebarSearch Form -->
        <div class="form-inline">
            <div class="input-group" data-widget="sidebar-search">
                <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-sidebar">
                        <i class="fas fa-search fa-fw"></i>
                    </button>
                </div>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false"
                s>
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <%--                <li class="nav-header">QUẢN LÝ CỬA HÀNG</li>--%>
                <li class="nav-item">

                    <a href="/admin/product/table" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Sản Phẩm
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <i class=""></i>
                    <a href="/admin/warehouse/table" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Kho Hàng
                        </p>
                    </a>
                </li>
                <li class="nav-item"><a href="/admin/order/table" class="nav-link">
                    <i class="nav-icon fas fa-table"></i>
                    <p>
                        Đơn Hàng
                    </p>
                </a>
                </li>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
</body>
</html>
