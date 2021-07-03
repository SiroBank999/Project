<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="templates/client/plugins/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="templates/client/plugins/animate/animate.min.css">
  <link rel="stylesheet" href="templates/client/plugins/fontawesome/all.css">
  <link rel="stylesheet" href="templates/client/plugins/webfonts/font.css">
  <link rel="stylesheet" href="templates/client/css/owl.carousel.min.css" type="text/css">
  <link rel="stylesheet" href="templates/client/css/owl.theme.default.min.css" type="text/css">
  <link rel="stylesheet" type="text/css" href="templates/client/css/style.css">

  <!-- UIkit CSS -->
  <link rel="stylesheet" href="templates/client/plugins/uikit/uikit.min.css" />

  <title>Shop thời trang</title>

</head>

<body>
<jsp:include page="../layouts/client/header.jsp"></jsp:include>
<jsp:include page="../layouts/client/menu.jsp"></jsp:include>
<jsp:include page="../pages/client/${page}.jsp"></jsp:include>
<jsp:include page="../layouts/client/footer.jsp"></jsp:include>



<script async defer crossorigin="anonymous" src="templates/client/plugins/sdk.js"></script>
  <script src="templates/client/plugins/jquery-3.4.1/jquery-3.4.1.min.js"></script>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
  <script src="templates/client/plugins/bootstrap/popper.min.js"></script>
  <script src="templates/client/plugins/bootstrap/bootstrap.min.js"></script>
  <script src="templates/client/plugins/owl.carousel/owl.carousel.min.js"></script>
  <script src="templates/client/js/home.js"></script>
  <script src="templates/client/js/script.js"></script>
  <script src="templates/client/plugins/uikit/uikit.min.js"></script>
  <script src="templates/client/plugins/uikit/uikit-icons.min.js"></script>
</body>

</html>
