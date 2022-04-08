<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product</title>

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
                        <h1>Sửa Sản Phẩm</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Validation</li>
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
                            <form:form id="formSubmit" action="/admin/product/edit" modelAttribute="product" method="post">
                                <div class="card-body">
                                    <div class="form-group">
                                        <form:label path="id">Mã SP</form:label>
                                        <form:input path="id" class="form-control" value="${item.id}" readonly="true" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="name">Tên SP</form:label>
                                        <form:input path="name" class="form-control" value="${item.name}" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="image">Hình Ảnh</form:label>
                                        <form:input path="image" class="form-control" value="${item.image}" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="info">Thông tin</form:label>
                                        <form:input path="info" class="form-control" value="${item.info}" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="descriptions">Mô tả</form:label>
                                        <form:input path="descriptions" class="form-control" value="${item.descriptions}" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="price">Giá</form:label>
                                        <form:input path="price" class="form-control" value="${item.price}" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="salePrice">Giá KM</form:label>
                                        <form:input path="salePrice" class="form-control" value="${item.salePrice}" />
                                    </div>
                                    <div class="form-group">
                                        <form:label path="categoryId">Thể Loại</form:label>
                                        <form:select path="categoryId" class="form-control" name="category" id="category">
                                            <option value="${chooseCategory.id}">${chooseCategory.name}</option>
                                            <c:forEach var="categoryItem" items="${categoryItem}">
                                                <option value="${categoryItem.id}">${categoryItem.name}</option>
                                            </c:forEach>

                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="author">Tác Giả</form:label>
                                        <form:input path="author" class="form-control" value="${item.author}" />
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary" href="">Chỉnh Sửa</button>
                                </div>
                            </form:form>
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
