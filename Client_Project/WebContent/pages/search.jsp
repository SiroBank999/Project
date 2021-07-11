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
<div class="breadcrumb-shop">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 pd5">
				<ol class="breadcrumb breadcrumb-arrows">
					<li><a href="index.html"> <span>Trang chủ</span>
					</a></li>
					<li><a href="Product.html"> <span>Sản phẩm</span>
					</a></li>
					<li><span><span style="color: #777777"><%=request.getParameter("timkiem")%></span></span></li>
				</ol>
			</div>
		</div>
	</div>
</div>
<!--List Prodct-->
<div class="container" style="margin-top: 50px;">
	<div class="row">
		<div class="col-md-3 col-sm-12 col-xs-12 sidebar-fix">
			<div class="wrap-filter">
				<div class="box_sidebar">
					<div class="block left-module">
						<div class=" filter_xs">
							<div class="group-menu">
								<div
									class="title_block d-block d-sm-none d-none d-sm-block d-md-none"
									data-toggle="collapse" href="#collapseExample1" role="button"
									aria-expanded="false" aria-controls="collapseExample1">
									Danh mục sản phẩm <span><i class="fa fa-angle-down"
										data-toggle="collapse" href="#collapseExample1" role="button"
										aria-expanded="false" aria-controls="collapseExample1"></i></span>
								</div>
								<div class="block_content layered-category collapse"
									id="collapseExample1">
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
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-9 col-sm-12 col-xs-12">
			<div class="wrap-collection-title row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<h1 class="title">
						Kết quả tìm kiếm: <span style="color: red;">Có <%=request.getAttribute("tong")%>
							kết quả cho từ khóa <%=request.getParameter("timkiem")%></span>
					</h1>
					<div class="alert-no-filter"></div>
				</div>

			</div>
			<div class="row">
				<c:forEach items="${list_search}" var="list">
					<div class="col-md-3 col-sm-6 col-xs-6 col-6">
						<div class="product-block">
							<div class="product-img fade-box">
								<a
									href="detail_product?id_product=${list.id}&id_category=${list.id_category}"
									title="Áo ${list.productname}" class="img-resize"> <img
									src="<%=request.getContextPath()%>/uploads/product/${list.image}"
									class="lazyloaded">
								</a>
							</div>

							<div class="product-detail clearfix">
								<div class="pro-text">
									<a
										style="text-transform: uppercase; color: black; font-size: 14px; text-decoration: none;"
										href="detail_product?id_product=${list.id}&id_category=${list.id_category}"
										title="Adidas EQT Cushion ADV" inspiration pack>
										${list.productname } </a>
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
					</div>
				</c:forEach>
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