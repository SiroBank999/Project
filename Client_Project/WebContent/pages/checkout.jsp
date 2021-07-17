
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>F5 Thanh Toán</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/checkout/">

<!-- Bootstrap core CSS -->
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container">
		<br /> <br />
		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Giỏ Hàng</span> <span
						class="badge badge-secondary badge-pill">3</span>
				</h4>
				<ul class="list-group mb-3">
				<c:forEach items ="${sessionScope.order.items}" var="item">
					<li class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<h6 class="my-0">${item.product.productname}</h6>
							<small class="text-muted">${item.size.name}/${item.quantity}</small>
						</div> <span class="text-muted"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${item.price}"></fmt:formatNumber>đ</span>
					</li>
				</c:forEach>
				

					<li class="list-group-item d-flex justify-content-between"><span>Tổng[Bao gồm VAT]</span>
						<strong><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${order.getTotal()}" /> ₫</strong></li>
				</ul>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Thông Tin Khách Hàng</h4>
				<form class="needs-validation" novalidate action="payment" method="post">
					<div class="row">
						<div class="col-md-12 mb-3">
							<label for="firstName">Họ Và Tên</label> <input type="text"
								class="form-control" name="fullname" placeholder="Nhập họ tên"
								value="${sessionScope.user.fullname }" required>
							<div class="invalid-feedback">Vui lòng nhập họ tên.</div>
						</div>
					</div>
					<div class="mb-3">
						<label for="email">Số Điện Thoại </label> <input type="text"
							class="form-control" name="phone" placeholder="Nhập SĐT" value="${sessionScope.user.phone}">
						<div class="invalid-feedback">Vui lòng nhập sđt.</div>
					</div>
					<div class="mb-3">
						<label for="email">Email </label> <input type="email"
							class="form-control" name="email" placeholder="Nhập email" value="${sessionScope.user.email}">
						<div class="invalid-feedback">Vui lòng nhập email.</div>
					</div>

					<div class="mb-3">
						<label for="address">Địa Chỉ</label> <input type="text"
							class="form-control" name="address" placeholder="Nhập Địa Chỉ"
							required>
						<div class="invalid-feedback">Vui lòng nhập địa chỉ.</div>
					</div>


					<hr class="mb-4">

					<h4 class="mb-3">Chọn Hình Thức Thanh Toán</h4>

					<div class="d-block my-3">
						<div class="row">
							<div class="col-md-4">
								<input name="payment" type="radio" value="COD"
									onchange="showStuff('A', this); return false;"  checked="checked"/> COD <i class="fas fa-truck"></i>
							</div>
							<div class="col-md-4">
								<input name="payment" type="radio" value="MOMO"
									onchange="showStuff('B', this); return false;" /> Momo <img src="templates/images/MoMo_Logo.jpg"
									style="width: 25px; height: 25px;">
							</div>
							<div class="col-md-4">
								<input name="payment" type="radio" value="VNPAY"
									onchange="showStuff('C', this); return false;" />VNPAY <img src="templates/images/vnpayqr.jpg"
									style="width: 25px; height: 25px;">
							</div>

							<br /> <br />
						</div>
						<div id="A" style="display: none">
							Bạn chỉ phải thanh toán khi nhận được hàng.
							<p>Được xem hàng, không được thử</p>
						</div>
						<div id="B" style="display: none">Thanh toán nhanh và an
							toàn qua MoMo.</div>
						<div id="C" style="display: none">Thanh toán nhanh và an
							toàn qua VNPAY.</div>

					</div>
					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Thanh
						Toán</button>
				</form>
			</div>
		</div>
		<br /> <br /> <br />
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script
		src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script
		src="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.js"></script>
</body>
</html>
