<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Warehouse Manager</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<c:url value="/template/admin/plugins/fontawesome-free/css/all.min.css" />">
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
                        <h1>Nhập thông tin kho hàng</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Nhập thông tin kho hàng</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <!-- form start -->
                            <form:form id="formSubmit" action="/admin/warehouse/input_warehouse" modelAttribute="warehouse"
                                       method="post" onsubmit="return(validate());">
                                <div class="card-body">
                                    <div class="form-group">
                                        <form:label path="id">Mã Kho</form:label>
                                        <form:input path="id" class="form-control" value="${item.id}" readonly="true"/>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="productName">Tên SP</form:label>
                                        <form:input path="productName" class="form-control" value="${item.productName}"
                                                    readonly="true"/>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="inputAmount">Số Lượng Nhập</form:label>
                                        <form:input path="inputAmount" class="form-control"/>
                                        <label id="inputAmountValidate" style="color: red;"></label>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Cập Nhật</button>
                                </div>
                            </form:form>
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
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
<!-- jquery-validation -->
<script src="<c:url value="/template/admin/plugins/jquery-validation/jquery.validate.min.js" />"></script>
<script src="<c:url value="/template/admin/plugins/jquery-validation/additional-methods.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/template/admin/dist/js/adminlte.min.js" />"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/template/admin/dist/js/demo.js" />"></script>
<!-- Page specific script -->
<script>
    function validate() {
        let x = true;

        let regexAmount = /^\d{1,5}$/
        if (document.getElementById("inputAmount").value.trim() === "") {
            document.getElementById("inputAmountValidate").innerHTML = "* Số lượng nhập không được để trống!";
            x = false;
        } else if (!document.getElementById("inputAmount").value.trim().match(regexAmount)){
            document.getElementById("inputAmountValidate").innerHTML = "* Số lượng nhập phải là kí tự số!";
            x = false;
        } else {
            document.getElementById("amountValidate").innerHTML = "";
        }
        return x;
    }
</script>
</body>
</html>
