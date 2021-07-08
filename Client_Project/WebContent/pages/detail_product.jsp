
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<div class="row product-detail-wrapper">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="row product-detail-main pr_style_01">
						<div class="col-md-7 col-sm-12 col-xs-12">
							<div class="product-gallery">
								<div
									class="product-gallery__thumbs-container hidden-sm
                    hidden-xs">
									<div class="product-gallery__thumbs thumb-fix">
										<c:forEach items="${Limages}" var="lista">
											<div class="product-gallery__thumb" id="imgg${lista.id}">
												<a class="product-gallery__thumb-placeholder"
													href="javascript:void(0);"
													data-image="uploads/product/${lista.image}"
													data-zoom-image="uploads/product/${lista.image}"> <img
													src="uploads/product/${lista.image}"
													data-image="uploads/product/${lista.image}"
													alt="Nike Air Max 90 Essential" grape="">
												</a>
											</div>

										</c:forEach>




									</div>
								</div>
								<div
									class="product-image-detail box__product-gallery
                    scroll hidden-xs">
									<ul id="sliderproduct"
										class="site-box-content
                      slide_product">
										<c:forEach items="${Limages}" var="lista">
											<li class="product-gallery-item gallery-item"
												id="imgg${lista.id}a"><img
												class="product-image-feature "
												src="uploads/product/${lista.image}"
												alt="Nike Air Max 90 Essential" grape=""></li>
										</c:forEach>




									</ul>
									<div class="product-image__button">
										<div id="product-zoom-in"
											class="product-zoom
                        icon-pr-fix"
											aria-label="Zoom in" title="Zoom in">
											<span class="zoom-in" aria-hidden="true"> <svg
													version="1.1" xmlns="http://www.w3.org/2000/svg"
													xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													viewBox="0 0 36 36"
													style="enable-background: new 0 0 36 36; width: 30px; height: 30px;"
													xml:space="preserve">
                            <polyline
														points="6,14 9,11 14,16 16,14 11,9
                              14,6 6,6">
                            </polyline>
                            <polyline
														points="22,6 25,9 20,14 22,16 27,11
                              30,14 30,6">
                            </polyline>
                            <polyline
														points="30,22 27,25 22,20 20,22
                              25,27 22,30 30,30">
                            </polyline>
                            <polyline
														points="14,30 11,27 16,22 14,20 9,25
                              6,22 6,30">
                            </polyline>
                          </svg>
											</span>
										</div>
										<div class="gallery-index icon-pr-fix">
											<span class="current">1</span> / <span class="total">8</span>
										</div>
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
									<h1>${product.productname}</h1>
									<span id="pro_sku">MSP: S-0015-${product.id}</span>
								</div>
								<div class="product-price" id="price-preview">
									<span class="pro-price"> <c:set var="saleprice"
											value="${product.sale}" /> <c:choose>
											<c:when test="${saleprice>0 }">
												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${product.sale}" />
												<sup>đ</sup>
												<p class="giaSale">
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${product.price}" />
													<sup>đ</sup>
											</c:when>
											<c:otherwise>

												<fmt:formatNumber type="number" maxFractionDigits="3"
													value="${product.price}" /> đ
										</c:otherwise>
										</c:choose>


									</span>
								</div>
								<h6 style="margin-top: 5px;">Chọn size</h6>
								<div class="styled-select" style="margin-top: -3px;">
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
										<h2>Mô tả</h2>
									</div>
									<div class="description-content">
										<div class="description-productdetail">
											<p>
												<span>${product.describe }</span><br> <br>
											</p>
											<ul>
												<li>${product.describe}</li>

											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="list-productRelated clearfix">
						<div class="heading-title text-center">
							<h2>Sản phẩm liên quan</h2>
						</div>
						<div class="container">
							<div class="row">
								<c:forEach items="${listproduct}" var="lp">
									<div class="col-md-3 col-sm-6 col-xs-6 col-6">
										<div class="product-block">
											<div class="product-img fade-box">
												<a href="#" title="Adidas EQT Cushion ADV"
													class="img-resize"> <img
													src="uploads/product/${lp.image}"
													alt="Adidas EQT Cushion ADV" class="lazyloaded"
													width="100%">
												</a>
											</div>
											<div class="product-detail clearfix">
												<div class="pro-text">
													<a
														style="color: black; font-size: 14px; text-decoration: none;"
														#" title="Adidas EQT Cushion ADV" inspiration pack>
														${lp.productname}</a>
												</div>
												<div class="pro-price">
													<c:set var="saleprice" value="${lp.sale}" />
													<c:choose>
														<c:when test="${saleprice>0 }">
															<p class="">
																<fmt:formatNumber type="number" maxFractionDigits="3"
																	value="${lp.sale}" />
																đ
															</p>
															<p class="giaSale">
																<fmt:formatNumber type="number" maxFractionDigits="3"
																	value="${lp.price}" />
																đ
															</p>
														</c:when>
														<c:otherwise>
															<p class="" style="margin-top: 20px;">
																<fmt:formatNumber type="number" maxFractionDigits="3"
																	value="${lp.price}" />
																đ
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
	<!-- show zoom detail product -->
	<!-- zoom -->
	<div class="product-zoom11">
		<div class="product-zom">
			<div class="divclose">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="owl-carousel owl-theme owl-product1">

				<div class="item">
					<img src="templates/images/detailproduct/1.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/2.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/3.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/4.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/5.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/6.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/7.jpg" alt="">
				</div>
				<div class="item">
					<img src="templates/images/detailproduct/8.jpg" alt="">
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

