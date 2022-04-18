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
                        <h1>Chi tiết đơn hàng</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/home">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Chi tiết đơn hàng</li>
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
                            <div class="card-body" style="font-size: 25px">
                                <table>
                                    <tr>
                                        <td style="width: 400px"><label>Mã Đơn Hàng:</label></td>
                                        <td><label>${item.id}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Họ Tên:</label></td>
                                        <td><label>${item.firstName} ${item.lastName}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>SĐT:</label></td>
                                        <td><label>${item.phone}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Email:</label></td>
                                        <td><label>${item.email}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Tỉnh/TP:</label></td>
                                        <td><label>${item.address}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Quận/Huyện:</label></td>
                                        <td><label>${item.district}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Phường/Xã:</label></td>
                                        <td><label>${item.commune}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Ghi Chú:</label></td>
                                        <td><label>${item.specialNotes}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Ngày Lập:</label></td>
                                        <td><label><fmt:formatDate value="${item.modefinedDate}"
                                                                   pattern="dd-MM-yyyy"></fmt:formatDate></label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Thành Tiền:</label></td>
                                        <td><label>${item.totalPrice}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Tình Trạng:</label></td>
                                        <td>
                                            <label>
                                                <c:if test="${item.status == 1}">Đã xác nhận</c:if>
                                                <c:if test="${item.status == 0}">Chưa xác nhận</c:if>
                                            </label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><label>Phương Thức Thanh Toán:</label></td>
                                        <td><label>${item.paymentMethod}</label></td>
                                    </tr>
                                    <tr>
                                        <td><label>Danh Sách Sản Phẩm:</label></td>
                                        <td><label>${item.listProduct}</label></td>
                                    </tr>
                                </table>
                            </div>

                            <a href="/admin/order/table?page=1&search=all" class="btn btn-primary" title="Trở về"
                               style="font-size: 25px">
                                Trở về
                            </a>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!-- right column -->
                    <div class="col-md-6">

                    </div>
                    <!--/.col (right) -->
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
    $(function () {
        $.validator.setDefaults({
            submitHandler: function () {
                alert("Form successful submitted!");
            }
        });
        $('#quickForm').validate({
            rules: {
                email: {
                    required: true,
                    email: true,
                },
                password: {
                    required: true,
                    minlength: 5
                },
                terms: {
                    required: true
                },
            },
            messages: {
                email: {
                    required: "Please enter a email address",
                    email: "Please enter a valid email address"
                },
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 5 characters long"
                },
                terms: "Please accept our terms"
            },
            errorElement: 'span',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.closest('.form-group').append(error);
            },
            highlight: function (element, errorClass, validClass) {
                $(element).addClass('is-invalid');
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).removeClass('is-invalid');
            }
        });
    });

    $('#btnUpdate').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        updateProduct(data);
    });

    function updateProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            <%--success: function (result) {--%>
            <%--    window.location.href = "admin-table-product?type=list&page=1&maxPageItem=10&sortName=null&sortBy=null";--%>
            <%--},--%>
            <%--error: function (error) {--%>
            <%--    window.location.href = "${Userurl}?type=list&maxPageItem=2&page=1&message=error_system";--%>
            <%--}--%>
        });
    }
</script>
</body>
</html>
