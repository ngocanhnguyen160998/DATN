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
                        <h1>Sửa sản phẩm</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                            <li class="breadcrumb-item active">Sửa sản phẩm</li>
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
                            <form:form id="formSubmit" action="/admin/product/edit" modelAttribute="product"
                                       method="post" onsubmit="return(validate());">
                                <div class="card-body">
                                    <div class="form-group">
                                        <form:label path="id">Mã SP</form:label>
                                        <form:input path="id" class="form-control" value="${item.id}" readonly="true"/>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="name">Tên SP</form:label>
                                        <form:input path="name" class="form-control" value="${item.name}"/>
                                        <label id="nameValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="image">Hình Ảnh</form:label>
                                        <form:input path="image" class="form-control" value="${item.image}"/>
                                        <label id="imageValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="info">Thông tin</form:label>
                                        <form:input type="hidden" path="info" class="form-control" value="${item.info}"/>
                                        <textarea id="infoTmp" class="form-control" onchange="textarea_info();" rows="5">${item.info}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="descriptions">Mô tả</form:label>
                                        <form:input type="hidden" path="descriptions" value="${item.descriptions}"/>
                                        <textarea id="descriptionsTmp" class="form-control" onchange="textarea_descriptions();" rows="5">${item.descriptions}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="price">Giá</form:label>
                                        <form:input path="price" class="form-control" value="${item.price}"/>
                                        <label id="priceValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="salePrice">Giá KM</form:label>
                                        <form:input path="salePrice" class="form-control" value="${item.salePrice}"/>
                                        <label id="salePriceValidate" style="color: red;"></label>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="categoryId">Thể Loại</form:label>
                                        <form:select path="categoryId" class="form-control" name="category"
                                                     id="category">
                                            <option value="${chooseCategory.id}">${chooseCategory.name}</option>
                                            <c:forEach var="categoryItem" items="${categoryItem}">
                                                <option value="${categoryItem.id}">${categoryItem.name}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="author">Tác Giả</form:label>
                                        <form:input path="author" class="form-control" value="${item.author}"/>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary" href="">Chỉnh Sửa</button>
                                    <a href="/admin/product/table?page=1&search=all" class="btn btn-primary"
                                       title="Trở về">
                                        Trở về
                                    </a>
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
    let descriptionsTmp = document.getElementById('descriptionsTmp').value;
    function textarea_descriptions() {
        descriptionsTmp = document.getElementById('descriptionsTmp').value;
        document.getElementById("descriptions").value = descriptionsTmp;
    }

    let infoTmp = document.getElementById('infoTmp').value;
    function textarea_info() {
        infoTmp = document.getElementById('infoTmp').value;
        document.getElementById("info").value = infoTmp;
    }

    function validate() {
        let x = true;
        if (document.getElementById("name").value.trim() === "") {
            document.getElementById("nameValidate").innerHTML = "* Tên không hợp lệ!";
            x = false;
        } else {
            document.getElementById("nameValidate").innerHTML = "";
        }

        if (document.getElementById("image").value.trim() === "") {
            document.getElementById("imageValidate").innerHTML = "* Hình ảnh không hợp lệ!";
            x = false;
        } else {
            document.getElementById("imageValidate").innerHTML = "";
        }

        let regexPrice = /^\d{1,15}$/;
        if (document.getElementById("price").value.trim() === "") {
            document.getElementById("priceValidate").innerHTML = "* Giá không được để trống!";
            x = false;
        } else if (!document.getElementById("price").value.trim().match(regexPrice)) {
            document.getElementById("priceValidate").innerHTML = "* Giá phải là kí tự số!";
            x = false;
        } else {
            document.getElementById("priceValidate").innerHTML = "";
        }

        let regexPriceCanEmpty = /^\d*$/;
        if (!document.getElementById("salePrice").value.trim().match(regexPriceCanEmpty)) {
            document.getElementById("salePriceValidate").innerHTML = "* Giá khuyến mại phải là kí tự số!";
            x = false;
        } else {
            document.getElementById("salePriceValidate").innerHTML = "";
        }

        if (x === false) {
            alert("Kiểm tra lại lỗi!")
        }

        return x;
    }

</script>
</body>
</html>
