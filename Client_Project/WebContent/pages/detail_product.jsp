
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main class="">

	<div id="product" class="productDetail-page">

		<!--  menu header seo -->
		<div class="breadcrumb-shop">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 pd5">
						<ol class="breadcrumb breadcrumb-arrows">
							<li><a href="home.html"> <span">Trang chủ</span>
							</a></li>
							<li><a href=""> <span>Sản phẩm</span>
							</a></li>
							<li class="active"><span> <span itemprop="name">${product.productname}</span>
							</span>
								<meta itemprop="position" content="3"></li>

						</ol>
					</div>
				</div>
			</div>
		</div>


		<!-- detail product chính -->
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="row">
						<div class="col-md-7 col-sm-12 col-xs-12">
							<div class="carousel">
								<div id="carousel-simple" class="carousel slide"
									data-ride="carousel">
									<div class="carousel-inner" role="listbox">

										<div class="carousel-item active">
											<center>
												<img
													src="<%=request.getContextPath()%>/uploads/product/${product.image}">
											</center>
										</div>
										<c:forEach items="${Limages}" var="Limages">
											<div class="carousel-item">
												<center>
													<img
														src="<%=request.getContextPath()%>/uploads/product/${Limages.image}">
												</center>
											</div>
										</c:forEach>
										<!-- nút điều khiển -->
										<a class="carousel-control-prev" href="#carousel-simple"
											data-slide="prev"> <span
											class="carousel-control-prev-icon"></span>
										</a> <a class="carousel-control-next" href="#carousel-simple"
											data-slide="next"> <span
											class="carousel-control-next-icon"></span>
										</a>
									</div>
								</div>
							</div>
						</div>
						<div
							class="col-md-5 col-sm-12 col-xs-12
                product-content-desc"
							id="detail-product">
							<div class="product-content-desc-1">
								<div class="product-title">
									<h1 style="font-size: 23px">${product.productname}</h1>
									<span id="pro_sku" style="color: #495057; font-size: 16px">Mã: S-0015-${product.id}</span>
								</div>
								<c:set var="saleprice" value="${product.sale}" />
								<c:choose>
									<c:when test="${saleprice > 0 }">
										<div class="product-price" id="price-preview"
											style="color: #545051; font-size: 15px; font-weight: bold">
											Giá sale: <s style="margin-right: 16px"> <fmt:formatNumber
													type="number" maxFractionDigits="3" value="${product.price}" />
												<sup>đ</sup>
											</s> <b class="product-price" id="price-preview"
												style="color: #d02b28; font-size: 19px; font-weight: bold">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${product.sale}" /> <sup>đ</sup>
											</b>
										</div>
									</c:when>
									<c:otherwise>
										<div class="product-price" id="price-preview"
											style="color: #000000; font-size: 19px; font-weight: bold">
											Giá:
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${product.price}" />
											<sup>đ</sup>
										</div>
									</c:otherwise>
								</c:choose>											
								<h6 style="margin-top: 5px;">Chọn size</h6>
								<div class="styled-select" style="margin-top: -3px; font-size: 17px">
									<select>
										<c:forEach items="${sz}" var="size">
											<option>${size.name}</option>
										</c:forEach>
									</select> <span class="fa fa-sort-desc" style="margin-top: 3px;"><i
										class="fas fa-caret-down"></i></span>
								</div>
								<form id="add-item-form" action="/cart/add" method="post"
									class="variants clearfix" style="margin-top: -3px;">
									<div class="selector-actions">
										<div class="quantity-area clearfix">
											<div class="quantity buttons_added">
												<input type="button" value="-" class="minus"> <input
													type="number" step="1" min="1" max="8" name="quantity"
													value="1" title="Qty" class="input-text qty text" size="4"
													pattern="" inputmode=""> <input type="button"
													value="+" class="plus">
											</div>
										</div>
										<div class="wrap-addcart clearfix">
											<div class="row-flex">
												<button type="button"
													class="button btn-addtocart addtocart-modal">Thêm
													vào</button>
												<button type="button" class="buy-now button"
													style="display: block;">Mua ngay</button>
											</div>
										</div>
									</div>
								</form>
								<div class="product-description">
									<div class="title-bl">
										<h2 style="font-size: 17px">Mô tả</h2>
									</div>
									
									<div class="description-content">
										<div class="description-productdetail">
											<p style="font-size: 16px; text-align: justify;">
											<span> <b> Chất
													liệu:</b> ${product.fabric}</span><br> <br>
												<span>${product.describe}</span> 
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="list-productRelated clearfix">
						<div class="heading-title text-center" style="margin-top: 40px">
							<h2>Sản phẩm liên quan</h2>
						</div>
						<div class="container">
							<div class="row">
								<c:forEach items="${listproduct}" var="list">
									<div class="col-md-3 col-sm-6 col-xs-6 col-6">
										<div class="product-block">
											<div class="product-img fade-box">
												<a href="detail_product?id_product=${list.id}&id_category=${list.id_category}"
													title="${list.productname}" class="img-resize"> <img
													src="<%=request.getContextPath()%>/uploads/product/${list.image}">
												</a>
											</div>
											<div class="product-detail clearfix">
												<div class="pro-text">
													<a
														style="color: black; font-size: 14px; text-decoration: none;"
														href="detail_product?id_product=${list.id}&id_category=${list.id_category}" title="${list.productname}" inspiration pack>
														${list.productname} </a>
												</div>
												<div class="gia">
													<c:set var="saleprice" value="${list.sale }" />
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
			</div>
		</div>
	</div>

</main>
<!--gallery-->
<section class="section section-gallery">
	<div class="">
		<div class="hot_sp" style="padding-top: 70px; padding-bottom: 50px;">
			<h2 style="text-align: center; padding-top: 10px">
				<a style="font-size: 28px; color: black; text-decoration: none"
					href="">Khách hàng và Runner Inn</a>
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





