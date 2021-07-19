 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="content">
    <section class="signup">
        <div class="container">
            <div class="signin-left">
                <div class="sign-title">
                    <h1>Thông tin cá nhân</h1>
                </div>
            </div>
            <div class="signin-right ">
            
                <form action="info" method="post">
                	
                    <div class="firstname form-control1 ">
                        <input type="text" id="firstname" name="Username" value="${sessionScope.user.username}" disabled>
                    </div>
                    <div class="lastname form-control1">
                        <input type="text" id="lastname" name="Fullname" value="${sessionScope.user.fullname}">
                    </div>
                   
                    <div class="birthday form-control1">
                        <input type="text" id="birthday" name="Phone"value="${sessionScope.user.phone}">
                    </div>
                    <div class="email form-control1">
                        <input type="email"  id="email"name= "Email"value="${sessionScope.user.email}">
                    </div>
                    <div class="password form-control1">
                        <input type="password"  id="password" name ="Password"value="${sessionScope.user.password}">
                    </div>
                     <div class="password form-control1">
                        <input type="password"  id="password" name ="RePassword"value="${sessionScope.user.password}">
                    </div>
                    <div class="recaptcha form-control1">This site is protected by reCAPTCHA and the Google <a href="">Privacy Policy</a> and <a href="">Terms of Service</a> apply.</div>
                    <button  type="submit"  class="btn btn-danger">Cập nhật thông tin cá nhân</button>
                      
                    
                </form>
            </div>
        </div>
    </section>    

    
  </div>
 