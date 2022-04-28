<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order Manager</title>

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
                        <h1>Quản lý đơn hàng</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Quản lý đơn hàng</li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>
        <div class="card-footer">
            <div class="form-inline" style="float: left">
                <form:form id="formSearch" action="/admin/order/export-excel" modelAttribute="searchDate" method="post" onsubmit = "return(validate());">
                    Từ ngày:
                    <form:input path="fromDate" class="form-control form-control-sidebar" type="date" title="Từ ngày"
                                placeholder="Tìm kiếm" value=""
                                aria-label="Search" name="search"></form:input>
                    &nbsp;&nbsp;Đến ngày:
                    <form:input path="toDate" class="form-control form-control-sidebar" type="date"
                                placeholder="Tìm kiếm" value=""
                                aria-label="Search" name="search"></form:input>

                    <div class="input-group-append" style="float: right; margin-left: 10px">
                        <button class="btn btn-primary" type="submit">
                            Xuất Excel
                        </button>
                    </div>
                </form:form>
            </div>
            <div class="form-inline" style="float: right">
                <form:form id="formSearch" action="/admin/order/table" modelAttribute="search" method="post">
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
            <label id="validateSearchDate" style="color: red; margin-top: 10px"></label>
        </div>
        <form action="<c:url value='/admin/order/table'/>" id="formSubmit" method="get">
            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <!-- /.card-header -->
                                <div class="card-body" style="overflow: auto">
                                    <table id="example2" class="table table-bordered table-hover" style="width: 150%">
                                        <thead>
                                        <tr style="text-align: center">
                                            <th style="width: 75px">Mã ĐH</th>
                                            <th style="width: 180px">Họ Tên</th>
                                            <th style="width: 110px">SĐT</th>
                                            <th style="width: 400px">Địa Chỉ</th>
                                            <th style="width: 160px">Ngày Tạo</th>
                                            <th style="width: 150px">Tổng Tiền</th>
                                            <th style="width: 130px">Tình trạng</th>
                                        </tr>
                                        </thead>
                                        <c:forEach var="item" items="${item}">
                                        <tbody>
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.firstName} ${item.lastName}</td>
                                            <td>${item.phone}</td>
                                            <td>${item.address}, ${item.commune}, ${item.district}, ${item.province}</td>
                                            <td><fmt:formatDate value="${item.modefinedDate}" pattern="dd-MM-yyyy HH:mm:ss"></fmt:formatDate></td>
                                            <td><fmt:formatNumber value="${item.totalPrice}"
                                                                  type="number"></fmt:formatNumber>đ</td>
                                            <td>
                                                <c:if test="${item.status == 3}">Hoàn thành</c:if>
                                                <c:if test="${item.status == 2}">Đã hủy</c:if>
                                                <c:if test="${item.status == 1}">Đã xác nhận</c:if>
                                                <c:if test="${item.status == 0}">Chưa xác nhận</c:if>
                                            </td>
                                            <td style="width: 240px; text-align: right">
                                                <c:if test="${item.status == 1}">
                                                    <c:url var="confirm" value="/admin/order/finish">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a href="${confirm}" class="btn btn-primary" title="Hoàn thành">
                                                        Hoàn thành
                                                    </a>
                                                </c:if>
                                                <c:if test="${item.status == 0}">
                                                    <c:url var="confirm" value="/admin/order/confirm">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a href="${confirm}" class="btn btn-primary" title="Xác nhận">
                                                        Xác nhận
                                                    </a>
                                                </c:if>
                                                <c:if test="${item.status != 2 && item.status != 3}">
                                                    <c:url var="cancel" value="/admin/order/cancel">
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a href="${cancel}" class="btn btn-primary" title="Hủy">
                                                        Hủy
                                                    </a>
                                                </c:if>
                                                <c:url var="details" value="/admin/order/details">
                                                    <c:param name="id" value="${item.id}"/>
                                                </c:url>
                                                <a href="${details}" class="btn btn-primary" title="Chi tiết">
                                                    Chi tiết
                                                </a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                    <ul class="pagination" id="pagination"
                                        style="=margin-top: 10px"></ul>
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

    function validate() {
        let fromDate = new Date(document.getElementById("fromDate").value.trim());
        let toDate = new Date(document.getElementById("toDate").value.trim());
        if (document.getElementById("fromDate").value.trim() === "" && document.getElementById("toDate").value.trim() !== "") {
            document.getElementById("validateSearchDate").innerHTML = "* Thông tin xuất file Excel không hợp lệ!";
            return false;
        } else if (document.getElementById("toDate").value.trim() === "" && document.getElementById("fromDate").value.trim() !== "") {
            document.getElementById("validateSearchDate").innerHTML = "* Thông tin xuất file Excel không hợp lệ!";
            return false;
        } else if (fromDate > toDate) {
            document.getElementById("validateSearchDate").innerHTML = "* Thông tin xuất file Excel không hợp lệ!";
            return false;
        } else {
            document.getElementById("validateSearchDate").innerHTML = "";
        }
        return true;
    }
</script>
</body>
</html>
