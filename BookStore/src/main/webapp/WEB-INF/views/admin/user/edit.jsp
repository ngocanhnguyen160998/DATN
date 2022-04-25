<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Manager</title>

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
                        <h1>Sửa thông tin người dùng</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Sửa thông tin người dùng</li>
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
                            <form:form id="formSubmit" action="/admin/user/edit" modelAttribute="user" method="post"
                                       onsubmit="return(validate());">
                                <div class="card-body">
                                    <div class="form-group">
                                        <form:label path="id">Mã Người Dùng</form:label>
                                        <form:input path="id" class="form-control" value="${item.id}" readonly="true"/>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="userName">Tên Tài Khoản</form:label>
                                        <form:input path="userName" class="form-control" value="${item.userName}"
                                                    readonly="true"/>
                                        <label id="userNameValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="password">Mật Khẩu</form:label>
                                        <form:password path="password" class="form-control" value="${item.password}"/>
                                        <label id="passwordValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="fullName">Họ Tên</form:label>
                                        <form:input path="fullName" class="form-control" value="${item.fullName}"/>
                                        <label id="fullNameValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="phone">Số Điện Thoại</form:label>
                                        <form:input path="phone" class="form-control" value="${item.phone}"/>
                                        <label id="phoneValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="email">Email</form:label>
                                        <form:input path="email" class="form-control" value="${item.email}"/>
                                        <label id="emailValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="roleId">Quyền</form:label>
                                        <form:select path="roleId" class="form-control" name="role" id="role">
                                            <option value="${chooseRole.id}">${chooseRole.name}</option>
                                            <c:forEach var="roleItem" items="${roleItem}">
                                                <option value="${roleItem.id}">${roleItem.name}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary" id="btnUpdate">Chỉnh Sửa</button>
                                </div>
                                <a href="/admin/user/table?page=1&search=all" class="btn btn-primary" title="Trở về">
                                    Trở về
                                </a>
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
    function validate() {
        let x = true;

        let regexPassword = /^\S+$/
        if (document.getElementById("password").value === "") {
            document.getElementById("passwordValidate").innerHTML = "* Mật khẩu không được để trống!";
            x = false;
        } else if (!document.getElementById("password").value.match(regexPassword)) {
            document.getElementById("passwordValidate").innerHTML = "* Mật khẩu không được để khoảng trắng!";
            x = false;
        } else {
            document.getElementById("passwordValidate").innerHTML = "";
        }

        if (document.getElementById("fullName").value.trim() === "") {
            document.getElementById("fullNameValidate").innerHTML = "* Họ tên không được để trống!";
            x = false;
        } else {
            document.getElementById("fullNameValidate").innerHTML = "";
        }

        let regexPhone = /^\d{10,15}$/
        if (document.getElementById("phone").value.trim() === "") {
            document.getElementById("phoneValidate").innerHTML = "* Số điện thoại không được để trống!";
            x = false;
        } else if (!document.getElementById("phone").value.trim().match(regexPhone)) {
            document.getElementById("phoneValidate").innerHTML = "* Số điện thoại không hợp lệ! (10 - 15 kí tự số)";
            x = false;
        } else {
            document.getElementById("phoneValidate").innerHTML = "";
        }

        let regexEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*$/;
        if (document.getElementById("email").value.trim() === "") {
            document.getElementById("emailValidate").innerHTML = "* Email không được để trống!";
            x = false;
        } else if (!document.getElementById("email").value.trim().match(regexEmail)) {
            document.getElementById("emailValidate").innerHTML = "* Email không đúng định dạng! (Ví dụ: example@gmail.com)";
            x = false;
        } else {
            document.getElementById("emailValidate").innerHTML = "";
        }
        if (x === false) {
            alert("Kiểm tra lại lỗi!")
        }
        return x;
    }
</script>
</body>
</html>
