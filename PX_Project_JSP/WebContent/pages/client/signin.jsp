     <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <div class="content">
    <section class="signin ">
        <div class="container">
            <div class="signin-left">
                <div class="sign-title">
                    <h1>Đăng nhập</h1>
                </div>
            </div>
            <div class="signin-right " id="a-sign">
                <form action="">
                    <div class="username form-control1 ">
                        <input type="email"   id="username" placeholder="Email">
                    </div>
                    <div class="password form-control1">
                        <input type="password" id="password" placeholder="Mật khẩu">
                        <div class="error" style="position: absolute; bottom: 0;background: #fff; padding:10px; border:1px solid #ccc; color: red">Please fill out this field </div>
                        
                       
                    </div>
                 
                    <div class="recaptcha form-control1">This site is protected by reCAPTCHA and the Google <a href="">Privacy Policy</a> and <a href="">Terms of Service</a> apply.</div>
                    <div class="submit">
                      <input class="btn" type="submit" id="dangnhap" value="Đăng Nhập">
                    <div class="forgetpassword">
                            <p id="quenmk">Quên mật khẩu?</p> hoặc <a href="">Đăng kí</a>
                      </div>
                       
                    </div>
                    
                </form>
            </div>
            <div class="signin-right " id="b-sign">
                <form action="">
                    <div class="username form-control1 ">
                       <h2>Phục hồi mật khẩu</h2>
                    </div>
                    <div class="password form-control1">
                        <input type="text" id="password" placeholder="Mật khẩu">
                    </div>
                 
                    <div class="recaptcha form-control1">This site is protected by reCAPTCHA and the Google <a href="">Privacy Policy</a> and <a href="">Terms of Service</a> apply.</div>
                    <div class="submit">
                      <input class="btn" type="submit" value="Gửi">
                      <div class="forgetpassword">
                            <a href="" id="huy">Hủy</a>
                      </div>
                       
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