
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
                <form action="signup" method="post">
                    <div class="firstname form-control1 ">
                        <input type="text" name="fullname"  id="firstname" placeholder="Họ và tên" required>
                    </div>
                    <div class="lastname form-control1">
                        <input type="text" name="username" id="lastname" placeholder="Tên Tài Khoản" required>
                    </div>
                    <div class="birthday form-control1">
                        <input type="text" name="phone" id="Phone" placeholder="sdt" required >
                    </div>
                    <div class="email form-control1">
                        <input type="text" name="email" id="email" placeholder="Email" required>
                    </div>
                    <div class="password form-control1">
                        <input type="password" name="password"  id="password" placeholder="Mật Khẩu" required>
                    </div>
                    <div class="recaptcha form-control1">This site is protected by reCAPTCHA and the Google <a href="">Privacy Policy</a> and <a href="">Terms of Service</a> apply.</div>
                    <div class="submit">
                    <input class="btn" type="submit" id="dangnhap" value="Đăng Kí">
                       
                    </div>
                    <div class="backto">
                      <a href=""><i class="fa fa-long-arrow-alt-left"></i> Quay lại trang chủ</a>
                    </div>
                </form>
            </div>
        </div>
    </section>    
    
   
  </div>
