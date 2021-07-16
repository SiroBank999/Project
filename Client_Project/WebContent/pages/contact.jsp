  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <div class="owl-carousel owl-theme owl-carousel-setting">
	<div class="item">
		<img src="templates/images/banner123.jpg" class="d-block w-100"
			alt="...">
	</div>
	<div class="item">
		<img src="templates/images/banner1232.jpg" class="d-block w-100"
			alt="...">
	</div>
</div>
  <div class="breadcrumb-shop">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 pd5">
          <ol class="breadcrumb breadcrumb-arrows">
            <li>
              <a href="index">
                <span>Trang chủ</span>
              </a>
            </li>
            <li>
              <span><span style="color: #777777">Liên hệ</span></span>
            </li>
          </ol>
        </div>
      </div>
    </div>
  </div>
  <section>

    <div class="container">

      <div class="row">
        <div class="col-md-6 col-sm-12 col-xs-12 box-heading-contact">
          <div class="box-map">
        
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3709.742555546721!2d105.8224113144876!3d21.595969985693834!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135271c187393d5%3A0x372fcecc95423953!2zU2hvcCBOZ3V54buFbiBIdeG7hw!5e0!3m2!1svi!2s!4v1625835330575!5m2!1svi!2s"
              width="100%" height="700" frameborder="0" style="border:0" allowfullscreen=""></iframe>
          </div>
        </div>
        <div class="col-md-6 col-sm-12 col-xs-12  wrapbox-content-page-contact">
          <div class="header-page-contact clearfix">
            <h1>Liên hệ</h1>
          </div>
          <div class="box-info-contact">
            <ul class="list-info">
              <li>
                <p>Địa chỉ chúng tôi</p>
                <p><strong>232/6 Nguyễn Huệ, TP.Huế </strong></p>
              </li>
              <li>
                <p>Email chúng tôi</p>
                <p><strong>germeshop@gmail.com</strong></p>
              </li>
              <li>
                <p>Điện thoại</p>
                <p><strong>+84 (028) 38800659</strong></p>
              </li>
              <li>
                <p>Thời gian làm việc</p>
                <p><strong>Thứ 2 đến Thứ 6 từ 8h đến 18h; Thứ 7 và Chủ nhật từ 9h30 đến 17h00 </strong></p>
              </li>
            </ul>
          </div>
          <div class="box-send-contact">
            <h2>Gửi thắc mắc cho chúng tôi</h2>
            <p style="font-size:17px; font-weight: bold; color: #d00000;"> ${fail} </p>
            <p style="font-size:17px; font-weight: bold; color: #0096c7;"> ${success} </p>
            <div id="col-left contactFormWrapper menuList-links">
              <form accept-charset="UTF-8" action="contact" class="contact-form" method="post">
                <div class="contact-form">
                  <div class="row">
                    <div class="col-sm-12 col-xs-12">
                      <div class="input-group">
                        <input name="subject" type="text" class="form-control"
                          placeholder="Tên của bạn">
                      </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">  
                      <div class="input-group">
                        <input name="mail" type="text" class="form-control"
                          placeholder="Email của bạn">
                      </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">
                      <div class="input-group">
                        <input name="phone" type="text" class="form-control"
                          placeholder="Số điện thoại của bạn">
                      </div>
                    </div>
                    <div class="col-sm-12 col-xs-12">
                      <div class="input-group">
                        <textarea name="content" placeholder="Nội dung"></textarea>
                      </div>
                    </div>
                    <div class="col-sm-12">
                      <button class="button dark">Gửi cho chúng tôi</button>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>


    </div>

  </section>
  <!--gallery-->
  <section class="section section-gallery">
		<div class="">
			<div class="hot_sp" style="padding-top: 70px; padding-bottom: 50px;">
				<h2 style="text-align: center; padding-top: 10px">
					<a style="font-size: 28px; color: black; text-decoration: none"
						href="">F5's Styles</a>
				</h2>
			</div>
			<div class="list-gallery clearfix">
				<ul class="shoes-gp">
					<li>
						<div class="gallery_item">
							<img class="img-resize"
								src="templates/images/shoes/gallery_item_1.jpg" alt="">
						</div>
					</li>
					<li>
						<div class="gallery_item">
							<img class="img-resize"
								src="templates/images/shoes/gallery_item_2.jpg" alt="">
						</div>
					</li>
					<li>
						<div class="gallery_item">
							<img class="img-resize"
								src="templates/images/shoes/gallery_item_3.jpg" alt="">
						</div>
					</li>
					<li>
						<div class="gallery_item">
							<img class="img-resize"
								src="templates/images/shoes/gallery_item_4.jpg" alt="">
						</div>
					</li>
					<li>
						<div class="gallery_item">
							<img class="img-resize"
								src="templates/images/shoes/gallery_item_5.jpg" alt="">
						</div>
					</li>
					<li>
						<div class="gallery_item">
							<img class="img-resize"
								src="templates/images/shoes/gallery_item_6.jpg" alt="">
						</div>
					</li>
				</ul>
			</div>
		</div>
	</section>
	    <div class="benefit">
		<div class="container">
			<div class="row benefit_row">
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fa fa-truck" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>MIỄN PHÍ GIAO HÀNG</h6>
							<p>với hóa đơn trên 300k</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fas fa-money-bill" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>GIÁ TIỀN HỢP LÝ</h6>
							<p>đồ đẹp - sang chảnh</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="fa fa-undo" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>HOÀN TRẢ TRONG 30 NGÀY</h6>
							<p>đối với những sản phẩm bị lỗi</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 benefit_col">
					<div class="benefit_item d-flex flex-row align-items-center">
						<div class="benefit_icon"><i class="far fa-clock" aria-hidden="true"></i></div>
						<div class="benefit_content">
							<h6>MỞ CỬA TỪ</h6>
							<p>8h00 - 21h00</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br/>
	<br/>
 