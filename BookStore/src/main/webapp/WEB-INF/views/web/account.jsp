<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Daily Shop | Account Page</title>

  <%@include file="/common/lib.jsp"%>

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
<section id="aa-catg-head-banner">
  <img src="<c:url value="/template/web/img/fashion/fashion-header-bg-8.jpg" />" alt="fashion img">
  <div class="aa-catg-head-banner-area">
    <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Account Page</h2>
        <ol class="breadcrumb">
          <li><a href="index.html">Home</a></li>
          <li class="active">Account</li>
        </ol>
      </div>
    </div>
  </div>
</section>
<!-- / catg header banner section -->

<!-- Cart view section -->
<section id="aa-myaccount">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="aa-myaccount-area">
          <div class="row">
            <div class="col-md-6">
              <div class="aa-myaccount-login">
                <h4>Login</h4>
                <form action="" class="aa-login-form">
                  <label for="">Username or Email address<span>*</span></label>
                  <input type="text" placeholder="Username or email">
                  <label for="">Password<span>*</span></label>
                  <input type="password" placeholder="Password">
                  <button type="submit" class="aa-browse-btn">Login</button>
                  <label class="rememberme" for="rememberme"><input type="checkbox" id="rememberme"> Remember me </label>
                  <p class="aa-lost-password"><a href="#">Lost your password?</a></p>
                </form>
              </div>
            </div>
            <div class="col-md-6">
              <div class="aa-myaccount-register">
                <h4>Register</h4>
                <form action="" class="aa-login-form">
                  <label for="">Username or Email address<span>*</span></label>
                  <input type="text" placeholder="Username or email">
                  <label for="">Password<span>*</span></label>
                  <input type="password" placeholder="Password">
                  <button type="submit" class="aa-browse-btn">Register</button>
                </form>
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
