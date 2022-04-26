<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Statistic Manager</title>

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
                        <h1>Thống kê doanh thu theo ngày</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Thống kê doanh thu theo ngày</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <div class="card-footer">
            <div class="form-inline" style="float: left">
                <form:form id="formSearch" action="/admin/statistic-product/table" modelAttribute="search" method="post" onsubmit = "return(validate());">
                    Từ ngày:
                    <form:input path="fromDate" class="form-control form-control-sidebar" type="date" title="Từ ngày"
                                placeholder="Tìm kiếm" value=""
                                aria-label="Search" name="search"></form:input>
                    &nbsp;&nbsp;Đến ngày:
                    <form:input path="toDate" class="form-control form-control-sidebar" type="date"
                                placeholder="Tìm kiếm" value=""
                                aria-label="Search" name="search"></form:input>
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
            <label id="validateSearchDate" style="color: red; margin-top: 10px; float: left"></label>
        </div>
        <form action="<c:url value='/admin/statistic-product/table'/>" id="formSubmit" method="get">
            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <label>Thống kê doanh thu theo ngày</label>
                                    <table id="example2" class="table table-bordered table-hover">
                                        <thead>
                                        <tr style="text-align: center">
                                            <th style="width: 75px">Mã SP</th>
                                            <th style="width: 180px">Tên SP</th>
                                            <th style="width: 180px">Ngày Lập</th>
                                            <th style="width: 160px">Số Tiền Thu Được</th>
                                        </tr>
                                        </thead>
                                        <c:forEach var="item" items="${item}">
                                        <tbody>
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.name}</td>
                                            <td><fmt:formatDate value="${item.modefinedDate}" pattern="dd-MM-yyyy HH:mm:ss"></fmt:formatDate></td>
                                            <td><fmt:formatNumber value="${item.totalPrice}"
                                                                  type="number"></fmt:formatNumber>đ</td>
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

    function validate() {
        let fromDate = new Date(document.getElementById("fromDate").value.trim());
        let toDate = new Date(document.getElementById("toDate").value.trim());
        if (document.getElementById("fromDate").value.trim() === "" && document.getElementById("toDate").value.trim() !== "") {
            document.getElementById("validateSearchDate").innerHTML = "* Thông tin tìm kiếm không hợp lệ!";
            return false;
        } else if (document.getElementById("toDate").value.trim() === "" && document.getElementById("fromDate").value.trim() !== "") {
            document.getElementById("validateSearchDate").innerHTML = "* Thông tin tìm kiếm không hợp lệ!";
            return false;
        } else if (fromDate > toDate) {
            document.getElementById("validateSearchDate").innerHTML = "* Thông tin tìm kiếm không hợp lệ!";
            return false;
        } else {
            document.getElementById("validateSearchDate").innerHTML = "";
        }
        return true;
    }
</script>
</body>
</html>
