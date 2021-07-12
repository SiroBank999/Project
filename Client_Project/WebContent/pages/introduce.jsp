
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="index"> <span>Trang chủ</span>
					</a></li>
					<li><span><span style="color: #777777">Giới
								thiệu</span></span></li>
				</ol>
			</div>
		</div>
	</div>
</div>
<!--List Prodct-->

<div class="container">

	<div class="row">
		<div class="col-md-3 d-none d-sm-block d-sm-none d-md-block">
			<div class="sidebar-page">
				<div class="group-menu">
					<div class="page_menu_title title_block">
						<h2>
							Danh mục sản phẩm</span>
						</h2>
					</div>
					<div class="layered layered-category">
						<div class="layered-content card card-body"
							style="border: 0; padding: 0">
							<c:forEach items="${category}" var="category">
								<ul class="menuList-links">
									<li class=""><a href="category?id=${category.id}" title="Trang chủ"><span>${category.categoryname}</span></a>
										<img class="img-cate" src="uploads/category/${category.img}"></li>
									<br>
								</ul>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="box_image visible-lg visible-md">
					<div class="banner">
						<a href=""> <img
							src="//theme.hstatic.net/1000375638/1000480323/14/page_banner.jpg?v=321"
							alt="Runner Inn">
						</a>
					</div>
				</div>
			</div>

		</div>
		<div class="col-md-9 col-sm-12 col-xs-12">
			<div class="page-wrapper">
				<div class="heading-page">
					<h1>Giới thiệu</h1>
				</div>
				<div class="wrapbox-content-page">
					<div class="content-page ">
						<p>Trang giới thiệu giúp khách hàng hiểu rõ hơn về cửa hàng
							của bạn. Hãy cung cấp thông tin cụ thể về việc kinh doanh, về cửa
							hàng, thông tin liên hệ. Điều này sẽ giúp khách hàng cảm thấy tin
							tưởng khi mua hàng trên website của bạn.</p>
						<p>Một vài gợi ý cho nội dung trang Giới thiệu:</p>
						<div>
							<ul>
								<li><span>Bạn là ai</span><br></li>
								<li><span>Giá trị kinh doanh của bạn là gì</span><br></li>
								<li><span>Địa chỉ cửa hàng</span><br></li>
								<li><span>Bạn đã kinh doanh trong ngành hàng này bao
										lâu rồi</span><br></li>
								<li><span>Bạn kinh doanh ngành hàng online được bao
										lâu</span><br></li>
								<li><span>Đội ngũ của bạn gồm những ai</span><br></li>
								<li><span>Thông tin liên hệ</span><br></li>
								<li><span>Liên kết đến các trang mạng xã hội
										(Twitter, Facebook)</span><br></li>
							</ul>
						</div>
						<p>
							Bạn có thể chỉnh sửa hoặc xoá bài viết này tại <a href=""
								style="color: black"><strong>đây</strong></a> hoặc thêm những
							bài viết mới trong phần quản lý <a href="" style="color: black"><strong>Trang
									nội dung</strong></a>.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
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