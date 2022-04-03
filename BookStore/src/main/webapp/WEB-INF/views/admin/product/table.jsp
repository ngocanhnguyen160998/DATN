<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | DataTables</title>

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
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Quản lý sản phẩm</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <!-- /.card-header -->
                            <div class="card-footer">
                                <a href="/admin/product/insert" class="nav-link" title="Sửa">
                                    <div class="btn btn-primary">
                                        Thêm Mới
                                    </div>
                                </a>
                            </div>
                            <div class="card-body">

                                <table id="example2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width: 40px">Mã SP</th>
                                        <th style="width: 150px">Tên SP</th>
                                        <th style="width: 200px">Hình Ảnh</th>
                                        <th>Thông Tin</th>
                                        <th style="width: 100px">Mô tả</th>
                                        <th style="width: 50px">Giá</th>
                                        <th style="width: 50px">Giá KM</th>
                                        <th style="width: 60px">Thể Loại</th>
                                        <th style="width: 60px">Tác Giả</th>
                                    </tr>
                                    </thead>
                                    <c:forEach var="item" items="${item}">
                                    <tbody>
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.name}</td>
                                        <td>${item.image}</td>
                                        <td>${item.info}</td>
                                        <td>${item.descriptions}</td>
                                        <td><fmt:formatNumber value="${item.price}" type="currency" ></fmt:formatNumber></td>
                                        <td><fmt:formatNumber value="${item.salePrice}" type="currency" ></fmt:formatNumber></td>
                                        <td>${item.categoryName}</td>
                                        <td>${item.author}</td>
                                        <td style="width: 110px">
                                            <c:url var="edit" value="/admin/product/edit">
                                                <c:param name="id" value="${item.id}"/>
                                            </c:url>
                                            <a href="${edit}" class="nav-link" title="Sửa">
                                                <div class="btn btn-primary">
                                                    Sửa
                                                </div>
                                            </a>
                                            <a href="${edit}" class="nav-link" title="Xóa">
                                                <div class="btn btn-primary">
                                                    Xóa
                                                </div>
                                            </a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                                <div class="container">
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination" id="pagination"></ul>
                                        <input type="hidden" value="" id="page" name="page">
                                        <input type="hidden" value="" id="maxPageItem" name="maxPageItem">
                                        <input type="hidden" value="" id="sortName" name="sortName">
                                        <input type="hidden" value="" id="sortBy" name="sortBy">
                                        <input type="hidden" value="list" id="type" name="type">
                                    </nav>
                                </div>
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
<script>
    var totalPage = ${model.totalPage}; //tong so trang
    var currentPage = ${model.page};     //trang hien tai
    var visiblePages = ${model.maxPageItem};
    var sortName= '${model.sortName}';
    var sortBy= '${model.sortBy}';
    var limit =10;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 10,        //tong so item tren 1 page
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage!= page){
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val(sortName);
                    $('#sortBy').val(sortBy);
                    $('#formSubmit').submit();
                }
            }
        })
    });
</script>
</body>
</html>
