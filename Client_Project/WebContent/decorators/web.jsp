
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="templates/plugins/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="templates/plugins/animate/animate.min.css">
<link rel="stylesheet" href="templates/plugins/fontawesome/all.css">
<link rel="stylesheet" href="templates/plugins/webfonts/font.css">
<link rel="stylesheet" href="templates/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="templates/css/owl.theme.default.min.css"
	type="text/css">
<link rel="stylesheet" type="text/css" href="templates/css/style.css">
<link rel="shortcut icon" href="uploads/logo.png">
<link rel="stylesheet" href="templates/plugins/uikit/uikit.min.css" />
<link rel="stylesheet" type="text/scss" href="templates/css/sign.scss">
<link rel="stylesheet" type="text/css" href="templates/css/checkout.css">
<link rel="stylesheet" type="text/css"
	href="templates/css/introduce.css">
<link rel="stylesheet" href="templates/css/404.css">
<title>F5 shop</title>

</head>

<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<jsp:include page="../layouts/menu.jsp"></jsp:include>
	<jsp:include page="../pages/${page}.jsp"></jsp:include>
	<jsp:include page="../layouts/footer.jsp"></jsp:include>



	<script async defer crossorigin="anonymous"
		src="templates/plugins/sdk.js"></script>
	<script src="templates/plugins/jquery-3.4.1/jquery-3.4.1.min.js"></script>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
	<script src="templates/plugins/bootstrap/popper.min.js"></script>
	<script src="templates/plugins/bootstrap/bootstrap.min.js"></script>
	<script src="templates/plugins/owl.carousel/owl.carousel.min.js"></script>
	<script src="templates/js/home.js"></script>
	<script src="templates/js/count.js"></script>
	<script src="templates/js/script.js"></script>
	<script src="templates/js/checkout.js"></script>
	<script src="templates/js/drop.js"></script>
	<script src="templates/plugins/uikit/uikit.min.js"></script>
	<script src="templates/plugins/uikit/uikit-icons.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="https://apps.elfsight.com/p/platform.js" defer></script>
	<div class="elfsight-app-b83d94a6-9a15-416d-8109-639e20d9ea81"></div>
</body>

</html>
