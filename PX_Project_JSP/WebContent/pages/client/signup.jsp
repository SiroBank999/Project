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
                <form action="">
                    <div class="firstname form-control1 ">
                        <input type="text"   id="firstname" placeholder="Họ">
                    </div>
                    <div class="lastname form-control1">
                        <input type="text" id="lastname" placeholder="Tên">
                    </div>
                    <div class="sex form-control1">
                       <div class="female">
                         
                          <input type="radio" id="female" checked  name="sex">
                          <label for="female">Nữ</label>
                       </div>
                       <div class="male">
                        
                        <input type="radio" id="male"  name="sex">
                        <label for="male" >Nam</label>
                     </div>
                    </div>
                    <div class="birthday form-control1">
                        <input type="text" id="birthday" placeholder="mm/dd/yyyy">
                    </div>
                    <div class="email form-control1">
                        <input type="email"  id="email" placeholder="Email">
                    </div>
                    <div class="password form-control1">
                        <input type="password"  id="password" placeholder="Password">
                    </div>
                    <div class="recaptcha form-control1">This site is protected by reCAPTCHA and the Google <a href="">Privacy Policy</a> and <a href="">Terms of Service</a> apply.</div>
                    <div class="submit">
                      <p>Đăng kí</p>
                       
                    </div>
                    <div class="backto">
                      <a href=""><i class="fa fa-long-arrow-alt-left"></i> Quay lại trang chủ</a>
                    </div>
                </form>
            </div>
        </div>
    </section>    
    <section class="section section-gallery">
      <div class="">
        <div class="hot_sp" style="padding-top: 70px;padding-bottom: 50px;">
          <h2 style="text-align:center;padding-top: 10px">
            <a style="font-size: 28px;color: black;text-decoration: none" href="">Khách hàng và Runner Inn</a>
          </h2>
        </div>
        <div class="list-gallery clearfix">
          <ul class="shoes-gp">
            <li>
              <div class="gallery_item">
                <img class="img-resize" src="templates/client/images/shoes/gallery_item_1.jpg" alt="">
              </div>
            </li>
            <li>
              <div class="gallery_item">
                <img class="img-resize" src="templates/client/images/shoes/gallery_item_2.jpg" alt="">
              </div>
            </li>
            <li>
              <div class="gallery_item">
                <img class="img-resize" src="templates/client/images/shoes/gallery_item_3.jpg" alt="">
              </div>
            </li>
            <li>
              <div class="gallery_item">
                <img class="img-resize" src="templates/client/images/shoes/gallery_item_4.jpg" alt="">
              </div>
            </li>
            <li>
              <div class="gallery_item">
                <img class="img-resize" src="templates/client/images/shoes/gallery_item_5.jpg" alt="">
              </div>
            </li>
            <li>
              <div class="gallery_item">
                <img class="img-resize" src="templates/client/images/shoes/gallery_item_6.jpg" alt="">
              </div>
            </li>
          </ul>
        </div>
      </div>
    </section>
   
  </div>