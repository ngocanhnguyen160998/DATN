<%--
  Created by IntelliJ IDEA.
  User: tyhuh
  Date: 3/20/2022
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Login or Register</h4>
                <form class="aa-login-form" action="">
                    <label for="">Tài khoản<span>*</span></label>
                    <input type="text" placeholder="Tài khoản">
                    <label for="">Mật khẩu<span>*</span></label>
                    <input type="password" placeholder="Mật khẩu">
                    <button class="aa-browse-btn" type="submit">Đăng nhập</button>

                    <div class="aa-register-now">
                        Don't have an account?<a href="account.html">Đăng ký!</a>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</body>
</html>
