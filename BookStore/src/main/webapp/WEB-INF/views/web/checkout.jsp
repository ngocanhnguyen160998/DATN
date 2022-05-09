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
                    <form:form action="/checkout" modelAttribute="checkout" method="post" onsubmit = "return(validate());">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="checkout-left">
                                    <div class="panel-group" id="accordion">
                                        <!-- Shipping Address -->
                                        <div class="panel panel-default aa-checkout-billaddress">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">
                                                    <a style="font-weight: bold">
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
                                                                            placeholder="Họ Đệm" required="true" cssStyle="color: black; font-weight: bold" />
<%--                                                                <label id="nameValidate" style="color: red;">* Tên không được để trống</label>--%>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="lastName" type="text"
                                                                            placeholder="Tên" required="true" cssStyle="color: black; font-weight: bold" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="email" type="email"
                                                                            placeholder="Email" required="true" cssStyle="color: black; font-weight: bold" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="phone" type="phone"
                                                                            placeholder="SĐT" required="true" cssStyle="color: black; font-weight: bold" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:select path="provinceId" id="provinceId"
                                                                             cssStyle="height: 50px; font-weight: bold; color: black"
                                                                             onchange="changeProvince()">
                                                                    <option value="0" selected disabled hidden>-- Chọn
                                                                        Tỉnh/TP --
                                                                    </option>
                                                                    <form:options items="${province}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:select path="districtId" id="districtId"
                                                                             cssStyle="height: 50px; font-weight: bold; color: black"
                                                                             onchange="changeDistrict()" >
                                                                    <option value="0" selected disabled hidden>-- Chọn
                                                                        Quận/Huyện --
                                                                    </option>
                                                                    <form:options items="${district}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:select path="communeId" id="communeId"
                                                                             cssStyle="height: 50px; font-weight: bold; color: black">
                                                                    <option value="0" selected disabled hidden>-- Chọn
                                                                        Phường/Xã --
                                                                    </option>
                                                                    <form:options items="${commune}"/>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:input path="address" type="text"
                                                                            placeholder="Địa Chỉ" required="true" cssStyle="color: black; font-weight: bold" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="aa-checkout-single-bill">
                                                                <form:textarea path="note" cols="8" rows="3"
                                                                               placeholder="Ghi Chú" cssStyle="color: black; font-weight: bold" />
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
                                    <h4>Tóm Tắt Đơn Hàng</h4>
                                    <div class="aa-order-summary-area">
                                        <table class="table table-responsive">
                                            <thead>
                                            <tr>
                                                <th>Sản Phẩm</th>
                                                <th>Thành Tiền</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="item" items="${lstCartAll}">
                                            <tr>
                                                <td>${item.productName} <strong> x ${item.amount}</strong></td>
                                                <td><fmt:formatNumber
                                                        value="${item.total}"
                                                        type="number"></fmt:formatNumber>đ
                                                </td>
                                            </tr>
                                            </c:forEach>
                                            <tr>
                                                <th>Tổng</th>
                                                <td><fmt:formatNumber
                                                        value="${totalPrice}"
                                                        type="number"></fmt:formatNumber>đ
                                                </td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <h4>Phương Thức Thanh Toán</h4>
                                    <div class="aa-payment-method">
                                        <label for="cod">
                                            <input type="radio" id="cod"
                                                        name="optionsRadios" checked value="COD"> Thanh toán khi nhận hàng
                                        </label>
                                        <label for="paypal">
                                            <input type="radio" id="paypal" name="optionsRadios" value="Paypal" disabled> Paypal
                                        </label>
                                        <form:input path="paymentMethod" type="hidden"></form:input>
                                        <img src="https://www.paypalobjects.com/webstatic/mktg/logo/AM_mc_vs_dc_ae.jpg"
                                             border="0" alt="PayPal Acceptance Mark">
                                        <input type="submit" value="Đặt Hàng" onclick="getPaymentMethod()" class="aa-browse-btn">
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

    function getPaymentMethod() {
        var checkbox = document.getElementsByName("optionsRadios");
        for (var i = 0; i < checkbox.length; i++){
            if (checkbox[i].checked === true){
                document.getElementById("paymentMethod").value = checkbox[i].value;
            }
        }
    }

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

    function validate() {
        let x = true;

        let regexPhone = /^\d{10,15}$/
        if (document.getElementById("phone").value.trim() === "") {
            x = false;
        } else if (!document.getElementById("phone").value.trim().match(regexPhone)) {
            x = false;
        }

        let regexEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*$/;
        if (document.getElementById("email").value.trim() === "") {
            x = false;
        } else if (!document.getElementById("email").value.trim().match(regexEmail)) {
            x = false;
        }

        let selectProvince = document.getElementById('provinceId');
        let valueProvince = selectProvince.options[selectProvince.selectedIndex].value;
        if (valueProvince === "0") {
            x = false;
        }

        let selectDistrict = document.getElementById('districtId');
        let valueDistrict = selectDistrict.options[selectDistrict.selectedIndex].value;
        if (valueDistrict === "0") {
            x = false;
        }

        let selectCommune = document.getElementById('communeId');
        let valueCommune = selectCommune.options[selectCommune.selectedIndex].value;
        if (valueCommune === "0") {
            x = false;
        }

        if (x === false) {
            alert("Thông tin đặt hàng không hợp lệ, vui lòng nhập lại!")
        }
        return x;
    }

</script>

</body>
</html>
