<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/api/province" var="provinceApi"/>
<c:url value="/api/district" var="districtApi"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Checkout Page</title>

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
<section id="checkout">
    <div class="container" style="font-weight: bold">
        <div class="row">
            <div class="col-md-12">
                <div class="checkout-area">
                    <form:form action="/checkout" modelAttribute="checkout" method="post">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="checkout-left">
                                    <div class="panel-group" id="accordion">
                                        <!-- Shipping Address -->
                                        <div class="panel panel-default aa-checkout-billaddress">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">
                                                    <a>
                                                        Địa Chỉ Giao Hàng
                                                    </a>
                                                </h4>
                                            </div>
                                            <div id="collapseFour">
                                                <div class="panel-body">
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="firstName" type="text"
                                                                            placeholder="Họ Đệm"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="lastName" type="text"
                                                                            placeholder="Tên"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="email" type="email"
                                                                            placeholder="Email"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="phone" type="tel"
                                                                            placeholder="SĐT"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:select path="provinceId" id="provinceId" cssStyle="height: 50px"
                                                                             onchange="changeProvince()">
                                                                    <option value="0" selected disabled hidden>-- Chọn Tỉnh/TP --</option>
                                                                    <form:options items="${province}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:select path="districtId" id="districtId" cssStyle="height: 50px"
                                                                             onchange="changeDistrict()">
                                                                    <option value="0" selected disabled hidden>-- Chọn Quận/Huyện --</option>
                                                                    <form:options items="${district}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:select path="communeId" id="communeId" cssStyle="height: 50px">
                                                                    <option value="0" selected disabled hidden>-- Chọn Phường/Xã --</option>
                                                                    <form:options items="${commune}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="address" type="text"
                                                                            placeholder="Địa Chỉ"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:textarea path="note" cols="8" rows="3" placeholder="Ghi Chú"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="checkout-right">
                                    <h4>Order Summary</h4>
                                    <div class="aa-order-summary-area">
                                        <table class="table table-responsive">
                                            <thead>
                                            <tr>
                                                <th>Sản Phẩm</th>
                                                <th>Thành Tiền</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>T-Shirt <strong> x 1</strong></td>
                                                <td>$150</td>
                                            </tr>
                                            <tr>
                                                <th>Tổng</th>
                                                <td>$785</td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <h4>Phương Thức Thanh Toán</h4>
                                    <div class="aa-payment-method">
                                        <label for="cashdelivery"><input type="radio" id="cashdelivery"
                                                                         name="optionsRadios" checked> Thanh toán khi nhận hàng </label>
                                        <label for="paypal"><input type="radio" id="paypal" name="optionsRadios"> Paypal
                                        </label>
                                        <img src="https://www.paypalobjects.com/webstatic/mktg/logo/AM_mc_vs_dc_ae.jpg"
                                             border="0" alt="PayPal Acceptance Mark">
                                        <input type="submit" value="Đặt Hàng" class="aa-browse-btn">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
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
    function changeProvince() {
        var id = $('#provinceId').val();
        var data = {
            provinceId: id
        };
        $.ajax({
            url: '${provinceApi}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function (result) {
                var input = document.getElementById("districtId");
                var input1 = document.getElementById("communeId");
                input.innerHTML = result;
                input1.innerHTML = changeDistrict();
            },
            error: function (error) {
                alert(error);
            }
        });
    }

    function changeDistrict() {
        var id = $('#districtId').val();
        var data = {
            districtId: id
        };
        $.ajax({
            url: '${districtApi}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function (result) {
                var input = document.getElementById("communeId");
                input.innerHTML = result;

            },
            error: function (error) {
                alert(error);
            }
        });
    }
</script>

</body>
</html>
