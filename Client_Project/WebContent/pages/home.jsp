
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<!--Content-->
<section>
		<div class="content">
			<div class="container">
				<div class="hot_sp">
					<h2 style="text-align: center;">
						<a style="font-size: 28px; color: black; text-decoration: none"
							href="Product_new_controller">Sản phẩm mới</a>
					</h2>
					<div class="view-all" style="text-align: center;">
						<a style="color: black; text-decoration: none" href="Product_new_controller">Xem
							thêm</a>
					</div>
				</div>
			</div>
		</div>
		<!--Product-->
		<div class="container product" style="width: 100%; margin: auto;">
			<div class="row">
				<c:forEach items="${productnew}" var="list">
					<div class="col-md-3 col-sm-6 col-xs-6 col-6" style="margin-top:25px">
						<div class="product-block">
							<div class="product-img">
								<a href="detail_product?id_product=${list.id}&id_category=${list.id_category}"> <img src="uploads/product/${list.image}"
									alt="${list.productname}" width=100%/>
								</a>
							</div>
						</div>
						<div class="product-detail clearfix">
							<div class="pro-text">
								<a style="color: black; font-size: 14px; text-decoration: none;"
									href="detail_product?id_product=${list.id}&id_category=${list.id_category}" title="${list.productname}">
									${list.productname} </a>
							</div>
							<div class="gia">
								<c:set var="saleprice" value="${list.sale}" />
								<c:choose>
									<c:when test="${saleprice>0 }">
										<p class="giaSP">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${list.sale}" />
											<sup>đ</sup>
										</p>
										<p class="giaSale">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${list.price}" />
											<sup>đ</sup>
										</p>
									</c:when>
									<c:otherwise>
										<p class="giaSP" style="margin-top: 20px;">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${list.price}" />
											<sup>đ</sup>
										</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<section class="section wrapper-home-banner" style="margin-top:70px">
		<div class="container-fluid" style="padding-bottom: 50px;">
			<div class="row">
				<c:forEach items="${cate}" var="cate">
					<div class="col-xs-12 col-sm-2 home-banner-pd">
						<div class="block-banner-category">
							<a href="category?id=${cate.id}" class="link-banner wrap-flex-align flex-column">
								<div class="fg-image fade-box">
									<img class="lazyloaded" src="uploads/category/${cate.img}"
										alt="">
								</div>
								<figcaption class="caption_banner site-animation">
									<p>${cate.categoryname}</p>
									<h2></h2>
								</figcaption>
							</a>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>
	
	
	<div class="content">
	<div class="container">
		<div class="hot_sp" style="padding-bottom: 10px;">
			<h2 style="text-align: center; padding-top: 10px">
				<a style="font-size: 28px; color: black; text-decoration: none"
					href="Product_sale_controller">Sản phẩm khuyến mãi</a>
			</h2>
			<div class="view-all" style="text-align: center; padding-top: -10px;">
				<a style="color: black; text-decoration: none" href="Product_sale_controller">Xem thêm</a>
			</div>
		</div>
	</div>
	<!--Product-->
	<div class="container" style="padding-bottom: 50px;">
		<div class="row">

			<c:forEach items="${productsale}" var="list">
				<div class="col-md-3 col-sm-6 col-xs-6 col-6">
					<div class="product-block">
						<div class="product-img">
							<a href="detail_product?id_product=${list.id}&id_category=${list.id_category}"> <img src="uploads/product/${list.image}"
								alt="${list.productname}" width=100%>
							</a>
						</div>
					</div>
					<div class="product-detail clearfix">
						<div class="pro-text">
							<a style="color: black; font-size: 14px; text-decoration: none;"
								href="detail_product?id_product=${list.id}&id_category=${list.id_category}" title="${list.productname}" inspiration pack>
								${list.productname} </a>
						</div>
						<div class="gia">
							<c:set var="saleprice" value="${list.sale}" />
								<c:choose>
									<c:when test="${saleprice>0 }">
										<p class="giaSP">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${list.sale}" />
											<sup>đ</sup>
										</p>
										<p class="giaSale">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${list.price}" />
											<sup>đ</sup>
										</p>
									</c:when>
									<c:otherwise>
										<p class="giaSP" style="margin-top: 20px;">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${list.price}" />
											<sup>đ</sup>
										</p>
									</c:otherwise>
								</c:choose>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<section class="">
		<div class="content">
			<div class="container">
				<div class="hot_sp">
					<h2 style="text-align: center; padding-top: 10px">
						<a style="font-size: 28px; color: black; text-decoration: none"
							href="">Bài viết mới nhất</a>
					</h2>
					<br />
				</div>
			</div>
		</div>
		<!--New-->
		<div>
		<div class="container">

				<div class="row">

					<c:forEach items="${listnews}" var="listnews">
						<div class="col-md-4">
							<div class="post_item">
								<div class="post_featured">
									<a href="#" title="Adidas EQT Cushion ADV"> <img
										class="img-resize" style="padding-bottom: 15px;"
										src="uploads/news/${listnews.image}"
										alt="">
									</a>
								</div>
								<div class="pro-text">
									<span class="post_info_item"> ${listnews.datesub} </span>
								</div>
								<div class="pro-text">
									<h3 class="post_title">
										<a
											style="color: black; font-size: 18px; text-decoration: none;"
											href="detailblog?id=${listnews.id}"> ${listnews.title} </a>
									</h3>
								</div>
								<div style="text-align: center; padding-bottom: 30px;">
									<span>${listnews.describe}</span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
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
</div>

