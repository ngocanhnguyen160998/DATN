<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Manager</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/template/admin/plugins/fontawesome-free/css/all.min.css" />">
    <!-- DataTables -->
    <link rel="stylesheet"
          href="<c:url value="/template/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" />">
    <link rel="stylesheet"
          href="<c:url value="/template/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css" />">
    <link rel="stylesheet"
          href="<c:url value="/template/admin/plugins/datatables-buttons/css/buttons.bootstrap4.min.css" />">
    <!-- Theme style -->
    <link rel="stylesheet" href="<c:url value="/template/admin/dist/css/adminlte.min.css" />">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <%@ include file="/common/admin/menu.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Quản lý sản phẩm</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Quản lý sản phẩm</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <div class="card-footer">
            <a href="/admin/product/insert" class="btn btn-primary" title="Thêm mới">
                Thêm Mới
            </a>
            <div class="form-inline" style="float: right">
                <form:form id="formSearch" action="/admin/product/table" modelAttribute="search" method="post">
                    <form:input path="input" class="form-control form-control-sidebar" type="search"
                                placeholder="Tìm kiếm"
                                aria-label="Search" name="search"></form:input>
                    <div class="input-group-append" style="float: right">
                        <button class="btn btn-navbar" type="submit">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
        <!-- Main content -->
        <form action="<c:url value='/admin/product/table'/>" id="formSubmit" method="get">
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card" >
                                <div class="card-body" style="overflow: auto">
                                    <c:if test="${not empty message}">
                                        <div class="alert alert-${alert}" style=" width: 1900px">
                                            <div style="font-size: 17px;">${message}</div>
                                        </div>
                                    </c:if>
                                    <table id="example2" class="table table-bordered table-hover" style="width: 1900px" >
                                        <thead>
                                        <tr style="text-align: center">
                                            <th style="width: 70px">Mã SP</th>
                                            <th style="width: 250px">Tên SP</th>
                                            <th style="width: 200px">Hình Ảnh</th>
                                            <th style="width: 400px">Thông Tin</th>
                                            <th style="width: 400px">Mô tả</th>
                                            <th style="width: 100px">Giá</th>
                                            <th style="width: 100px">Giá KM</th>
                                            <th style="width: 180px">Thể Loại</th>
                                            <th style="width: 200px">Tác Giả</th>
                                        </tr>
                                        </thead>
                                        <c:forEach var="item" items="${item}">
                                        <tbody>
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td><img src="<c:url value="${item.image}" />"> </td>
                                            <td style="text-align: justify">${item.info}</td>
                                            <td style="text-align: justify">${item.descriptions}</td>
                                            <td><fmt:formatNumber value="${item.price}"
                                                                  type="number"></fmt:formatNumber>đ</td>
                                            <td><fmt:formatNumber value="${item.salePrice}"
                                                                  type="number"></fmt:formatNumber>đ</td>
                                            <td>${item.categoryName}</td>
                                            <td>${item.author}</td>
                                            <td style="width: 170px; text-align: center">
                                                <c:url var="edit" value="/admin/product/edit">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a href="${edit}" class="btn btn-primary" title="Sửa">
                                                    Sửa
                                                </a>
                                                <c:url var="delete" value="/admin/product/delete">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a href="${delete}" class="btn btn-primary" title="Xóa">
                                                    Xóa
                                                </a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="search" name="search"/>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </section>
        </form>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<c:url value="/template/admin/plugins/jquery/jquery.min.js" />"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value="/template/admin/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<!-- DataTables  & Plugins -->
<script src="<c:url value="/template/admin/plugins/datatables/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-buttons/js/dataTables.buttons.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-buttons/js/buttons.bootstrap4.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/jszip/jszip.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/pdfmake/pdfmake.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/pdfmake/vfs_fonts.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-buttons/js/buttons.html5.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-buttons/js/buttons.print.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/datatables-buttons/js/buttons.colVis.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/template/admin/dist/js/adminlte.min.js" />"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/template/admin/dist/js/demo.js" />"></script>
<!-- Page specific script -->
<script src="<c:url value='/template/paging/jquery.twbsPagination.js'/>"></script>
<script>
    var totalPages = ${page.totalPage};
    var currentPage = ${page.page};
    var search="${input}";
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 9,
            startPage: currentPage,
            search:search,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#page').val(page);
                    $('#search').val(search),
                    $('#formSubmit').submit();
                }
            }
        });
    });
</script>
</body>
</html>
