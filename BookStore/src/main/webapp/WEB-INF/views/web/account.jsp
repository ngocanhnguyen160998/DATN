<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Account Page</title>

    <%@include file="/common/lib.jsp" %>

</head>
<body>

<!-- wpf loader Two -->
<div id="wpf-loader-two">
    <div class="wpf-loader-two-inner">
        <span>Loading</span>
    </div>
</div>
<!-- / wpf loader Two -->
<!-- SCROLL TOP BUTTON -->
<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<%@ include file="/common/web/header.jsp" %>
<!-- / header section -->
<!-- menu -->
<%@ include file="/common/web/menu.jsp" %>
<!-- / menu -->

<!-- catg header banner section -->
<%@ include file="/common/web/banner.jsp" %>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="aa-myaccount">
    <div class="container">
        <div class="row" style="margin-left: 33%">
            <div class="col-md-12">
                <div class="aa-myaccount-area">
                    <div class="row">
                        <div class="col-md-6">
                            <c:if test="${not empty message}">
                                <div class="alert alert-danger" style=" width: 100%">
                                    <div style="font-size: 17px;">${message}</div>
                                </div>
                            </c:if>
                            <div class="aa-myaccount-register">
                                <h4 style="text-align: center">Đăng Ký Tài Khoản</h4>
                                <form:form id="formSubmit" action="/account" modelAttribute="user" method="post" onsubmit = "return(validate());">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <form:label path="userName">Tên Tài Khoản</form:label><label id="userNameValidate" style="color: red;"></label>
                                            <form:input path="userName" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="password">Mật Khẩu</form:label><label id="passwordValidate" style="color: red;"></label>
                                            <form:password path="password" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="fullName">Họ Tên</form:label><label id="fullNameValidate" style="color: red;"></label>
                                            <form:input path="fullName" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="phone">SĐT</form:label><label id="phoneValidate" style="color: red;"></label>
                                            <form:input path="phone" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="email">Email</form:label><label id="emailValidate" style="color: red;"></label>
                                            <form:input path="email" class="form-control"/>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary" id="btnAdd"
                                                style="margin-left: 30%">Đăng Ký
                                        </button>
                                        <a href="/" class="btn btn-primary" title="Trở về">
                                            Trở về
                                        </a>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Cart view section -->

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- / footer -->
<!-- Login Modal -->
<%@ include file="/WEB-INF/views/web/login_modal.jsp" %>

<script>
    function validate() {
        let x = true;

        let regexSpecialCharacters = /^[a-zA-Z0-9]{5,30}$/;
        if (document.getElementById("userName").value.trim() === "") {
            document.getElementById("userNameValidate").innerHTML = "* Tài khoản không được để trống!";
            x = false;
        } else if (!document.getElementById("userName").value.trim().match(regexSpecialCharacters)) {
            document.getElementById("userNameValidate").innerHTML = "* Tài khoản phải có độ dài từ 5 đến 30 kí tự và  không chứa kí tự đặc biệt!";
            x = false;
        } else {
            document.getElementById("userNameValidate").innerHTML = "";
        }

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
