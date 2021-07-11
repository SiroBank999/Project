
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <div class="content">
    <section class="signup">
        <div class="container">
            <div class="signin-left">
                <div class="sign-title">
                    <h1>Tạo tài khoản</h1>
                </div>
            </div>
            <div class="signin-right ">
                <form action="${pageContext.request.contextPath}/signup" method="post">
                <p style="color: red;">${errou}</p>
                    <div class="firstname form-control1 ">
                        <input type="text" name="fullname" value="${signup.fullname}"  id="firstname" placeholder="Họ và tên" required>
                    </div>
                    <div class="lastname form-control1">
                        <input type="text" name="username" value="${signup.username}" id="lastname" placeholder="Tên Tài Khoản" required>
                    </div>
                    <div class="birthday form-control1">
                        <input type="text" name="phone" value="${signup.phone }"  id="Phone" placeholder="Ví dụ: 0123456789" required >
                    </div>
                    <div class="email form-control1">
                        <input type="text" name="email" value="${signup.email}" id="email" placeholder="Ví dụ: a@gmail.com" required>
                    </div>
                    <div class="password form-control1">
                        <input type="password" name="password" value="${signup.password }" size="80"  id="password" placeholder="Mật Khẩu" required>
                    </div>
                    <div class="submit">
                    <input class="btn" type="submit" id="dangnhap" value="Đăng Kí">
                       
                    </div>
                    <div class="backto">
                      <a href="index"><i class="fa fa-long-arrow-alt-left"></i> Quay lại trang chủ</a>
                    </div>
                </form>
            </div>
        </div>
    </section>    
    
   
  </div>
