<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>F5 Shop Admin</title>
<link rel="stylesheet"
	href="templates/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet"
	href="templates/vendors/base/vendor.bundle.base.css">
<link rel="stylesheet" href="templates/css/style.css">
<link rel="shortcut icon" href="templates/images/favicon.png" />
<script type="text/javascript"
	src="ckeditor/ckeditor.js"></script>


</head>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper">
			<jsp:include page="../layouts/header.jsp"></jsp:include>
			<jsp:include page="../layouts/menu.jsp"></jsp:include>
			<div class="main-panel">
				<jsp:include page="../pages/${page}.jsp"></jsp:include>
				<jsp:include page="../layouts/footer.jsp"></jsp:include>
			</div>

		</div>
	</div>
	<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
	<script src="templates/vendors/base/vendor.bundle.base.js"></script>
	<script src="templates/vendors/chart.js/Chart.min.js"></script>
	<script src="templates/js/off-canvas.js"></script>
	<script src="templates/js/hoverable-collapse.js"></script>
	<script src="templates/js/template.js"></script>
	<script src="templates/js/todolist.js"></script>
	<script src="templates/js/dashboard.js"></script>
	<script src="templates/js/file-upload.js"></script>
	<script src="templates/js/delete.js"></script>
	<script src="templates/js/delete_cate.js"></script>

</body>
</html>