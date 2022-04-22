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
                            <div class="aa-myaccount-register">
                                <h4 style="text-align: center">Đăng Ký Tài Khoản</h4>
                                <form:form id="formSubmit" action="/account" modelAttribute="user" method="post">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <form:label path="userName">Tên Tài Khoản</form:label>
                                            <form:input path="userName" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="password">Mật Khẩu</form:label>
                                            <form:password path="password" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="fullName">Họ Tên</form:label>
                                            <form:input path="fullName" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="phone">Số Điện Thoại</form:label>
                                            <form:input path="phone" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="email">Email</form:label>
                                            <form:input path="email" class="form-control"/>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary" id="btnAdd"
                                                style="margin-left: 35%">Đăng Ký
                                        </button>
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

</body>
</html>
