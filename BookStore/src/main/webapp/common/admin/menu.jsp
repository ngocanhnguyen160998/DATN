<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aside class="main-sidebar sidebar-dark-primary elevation-4" style="position: fixed">
    <!-- Brand Logo -->
    <a href="/admin/home" class="brand-link">
        <img src="<c:url value="/template/admin/dist/img/AdminLTELogo.png" />" alt="AdminLTE Logo"
             class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Admin</span>
    </a>
    <!-- Sidebar -->
    <div class="sidebar">

        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <li class="nav-item">

                    <a href="/admin/category/table?page=1&search=all" class="nav-link">
                        <i class="nav-icon fas fa-calendar-alt"></i>
                        <p>
                            Thể Loại
                        </p>
                    </a>
                </li>
                <li class="nav-item">

                    <a href="/admin/product/table?page=1&search=all" class="nav-link">
                        <i class="nav-icon far fa-image"></i>
                        <p>
                            Sản Phẩm
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <i class=""></i>
                    <a href="/admin/warehouse/table?page=1&search=all" class="nav-link">
                        <i class="nav-icon fas fa-columns"></i>
                        <p>
                            Kho Hàng
                        </p>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/admin/user/table?page=1&search=all" class="nav-link">
                        <i class="nav-icon fas fa-person-booth"></i>
                        <p>
                            Người Dùng
                        </p>
                    </a>
                </li>
                <li class="nav-item"><a href="/admin/order/table?page=1&search=all" class="nav-link">
                    <i class="nav-icon fas fa-table"></i>
                    <p>
                        Đơn Hàng
                    </p>
                </a>
                </li>
                <li class="nav-item"><a href="/admin/order/table?page=1&search=all" class="nav-link">
                    <i class="nav-icon fas fa-book"></i>
                    <p>
                        Thống Kê
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
