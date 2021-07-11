<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<li><a href="product"> <span>Sản phẩm</span>
					</a></li>
					<li><span style="color: #777777">Sản phẩm khuyến mãi</span></li>
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
												<li class=""><a href="category?id=${category.id}" title="${category.categoryname}"><span>${category.categoryname}</span></a>
													<img class="img-cate" src="uploads/category/${category.img}"></li>
												<br>
											</ul>
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="layered">
								<p
									class="title_block d-block d-sm-none d-none d-sm-block d-md-none"
									data-toggle="collapse" href="#collapseExample2" role="button"
									aria-expanded="false" aria-controls="collapseExample2">
									Bộ lọc sản phẩm <span><i class="fa fa-angle-down"
										data-toggle="collapse" href="#collapseExample2" role="button"
										aria-expanded="false" aria-controls="collapseExample2"></i></span>
								</p>
								<div class="block_content collapse" id="collapseExample2">
									<div class="group-filter" aria-expanded="true">
										<div class="layered_subtitle dropdown-filter">
											<span>Giá sản phẩm</span><span class="icon-control"><i
												class="fa fa-minus"></i></span>
										</div>
										<div class="layered-content bl-filter filter-price">
										<form method="get" action="" name="product">
											<ul class="check-box-list" onchange="document.product.submit ()">
												<li><input type="radio" id="p1" name="order-by" value="1"> <label
													for="p1"> <span>Dưới</span> 200,000₫
												</label></li>
												<li><input type="radio" id="p2" name="order-by" value="2"> <label
													for="p2"> 200,000₫ - 400,000₫ </label></li>
												<li><input type="radio" id="p3" name="order-by" value="3"> <label
													for="p3"> 400,000₫ - 800,000₫ </label></li>
												<li><input type="radio" id="p4" name="order-by" value="4"> <label
													for="p4"> Trên 800,000đ </label></li>
											</ul>
											</form>
										</div>
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
				<div class="col-md-8 col-sm-12 col-xs-12">
					<h1 class="title">Sản phẩm khuyến mãi</h1>
					<div class="alert-no-filter"></div>
				</div>
				<div class="col-md-4 d-sm-none d-md-block d-none d-sm-block"
					style="float: left">
					<div class="option browse-tags">
						<span class="custom-dropdown custom-dropdown--grey"> 
						<form method="get" action="" name="productForm"><select name="order-by"
							class="sort-by custom-dropdown__select" onchange="document.productForm.submit ()">
							<option value="macdinh" selected>Mặc định</option>
								<option value="price-ascending" >Giá: Tăng dần</option>
								<option value="price-descending" >Giá: Giảm dần</option>
								<option value="title-ascending" >Tên: A-Z</option>
								<option value="title-descending" >Tên: Z-A</option>
								<option value="created-ascending" >Cũ nhất</option>
								<option value="created-descending">Mới nhất</option>
								<option value="best-selling" disabled="disabled">Bán chạy nhất</option>
						</select>
						</form>
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${hot}" var="hot">
					<div class="col-md-3 col-sm-6 col-xs-6 col-6">
						<div class="product-block">
							<div class="product-img fade-box">
								<a href="detail_product?id_product=${hot.id}&id_category=${hot.id_category}"
									title="${hot.productname}" class="img-resize"> <img
									src="<%=request.getContextPath()%>/uploads/product/${hot.image}"
									alt="${hot.productname}" class="lazyloaded">
								</a>
							</div>
							<div class="product-detail clearfix">
								<div class="pro-text">
									<a
										style="color: black; font-size: 14px; text-decoration: none;"
										href="detail_product?id_product=${hot.id}&id_category=${hot.id_category}"
										title="Adidas EQT Cushion ADV" inspiration pack>
										${hot.productname} </a>
								</div>
								<div class="pro-price">
									<c:set var="saleprice" value="${hot.sale}" />
									<c:choose>
										<c:when test="${saleprice > 0 }">
											<p class="giaSP">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${hot.sale}" />
											</p>
											<p class="giaSale">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${hot.price}" />
											</p>
										</c:when>
										<c:otherwise>
											<p class="giaSP" style="margin-top: 20px;">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${hot.price}" />
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
<div class="pagination">
	<c:if test="${tag > 1}">
		<a href="Product_sale_controller?page=${tag-1}">&laquo;</a>
	</c:if>
	<c:forEach begin="1" end="${endpage}" var="i">
		<a class="${tag==i?"
			active":""}" href="Product_sale_controller?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${tag < endpage}">
		<a href="Product_sale_controller?page=${tag+1}">&raquo;</a>
	</c:if>
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

