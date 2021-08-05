
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <html lang="en">
  <head>
  	<title>M3NS ĐĂNG KÍ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="templates/css/sign.css">

	</head>
	<body class="img js-fullheight" style="background-image: url(templates/images/login.jpg);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<a href="index"><h1 class="heading-section">F5'S SHOP</h1></a>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
		      	<h3 class="mb-4 text-center">ĐĂNG KÍ</h3>
		      	<form action="${pageContext.request.contextPath}/signup" method="post" class="signin-form">
		      	<p style="color:#d00000; font-weight: 500;">${errou}</p>
		      		<div class="form-group">
		      			<input type="text" name="fullname" value="${signup.fullname}" class="form-control" placeholder="Họ Và Tên" required>
		      		</div>
		      		<div class="form-group">
		      			<input type="text" name="phone" value="${signup.phone }" class="form-control" placeholder="Số Điện Thoại" required>
		      		</div>
		      		<div class="form-group">
		      			<input type="text" name="email" value="${signup.email}" class="form-control" placeholder="Email" required>
		      		</div>
		      		<div class="form-group">
		      			<input type="text" name="username" value="${signup.username}" class="form-control" placeholder="Tên Đăng Nhập" required>
		      		</div>
	            <div class="form-group">
	              <input id="password-field"  name="password" value="${signup.password }" size="80" class="form-control" placeholder="Mật Khẩu" required>
	              
	            </div>
	            <div class="form-group">
	            	<button type="submit" class="form-control btn btn-primary submit px-3">Tạo Tài Khoản</button>
	            </div>
	          </form>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="templates/Client/login/jquery.min.js"></script>
  <script src="templates/Client/login/popper.js"></script>
  <script src="templates/Client/login/bootstrap.min.js"></script>
  <script src="templates/Client/login/main.js"></script>

	</body>
</html>
