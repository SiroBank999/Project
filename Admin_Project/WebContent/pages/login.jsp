<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Royal Pet Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="templates/admin/vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="templates/admin/vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="templates/admin/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="templates/admin/images/favicon.png" />
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth px-0">
        <div class="row w-100 mx-0">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left py-5 px-4 px-sm-5">
              <div class="brand-logo-mini text-center">
                <img src="templates/admin/images/logo-mini.svg" width="100px" alt="logo">
              </div>
              <br>
              <c:if test="${alert == 1}">
	              	<div class="alert alert-danger " role="alert">
	  					Tài khoản mật khẩu không đúng
				  	</div>
              </c:if>
              <form class="pt-3" action="login" method="post">
                <div class="form-group">
                  <input type="text" class="form-control form-control-lg" id="exampleInputEmail1" name="Username" placeholder="Username">
                </div>
                <div class="form-group">
                  <input type="password" class="form-control form-control-lg" id="exampleInputPassword1" name="Password" placeholder="Password">
                </div>
                <div class="form-group mt-3">
                  <button class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit">ĐĂNG NHẬP</button>
                </div>
               
                
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>

  <script src="templates/admin/vendors/base/vendor.bundle.base.js"></script>
  <script src="templates/admin/js/off-canvas.js"></script>
  <script src="templates/admin/js/hoverable-collapse.js"></script>
  <script src="templates/admin/js/template.js"></script>
  <script src="templates/admin/js/todolist.js"></script>
</body>

</html>
    