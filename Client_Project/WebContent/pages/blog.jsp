
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
					<li><span><span style="color: #777777">Tin tức</span></span></li>
				</ol>
			</div>
		</div>
	</div>
</div>
<!--List Prodct-->

<div class="container">

	<div class="row">
		<div class="col-md-3 d-none d-sm-block d-sm-none d-md-block">
			<div class="sidebar-blog">
				<div class="news-latest">
					<div class="sidebarblog-title title_block">
						<h2>Bài viết mới nhất</h2>
					</div>
					<div class="list-news-latest layered">

						<c:forEach items="${listnews}" var="listnews">
							<div class="item-article clearfix">
								<div class="post-image">
									<a href="detailblog?id=${listnews.id}"><img
										src="uploads/news/${listnews.image }" alt="Bài viết mẫu"></a>
								</div>
								<div class="post-content">
									<h3>
										<a href="">${listnews.title }</a>
									</h3>

									<span class="date"> ${listnews.datesub} </span>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-9 col-sm-12 col-xs-12">
			<div class="heading-page clearfix">
				<h1>Tin tức</h1>
			</div>
			<div class="blog-content">
				<div class="list-article-content blog-posts">
					<article class="blog-loop">
						<div class="blog-post row">
							<c:forEach items="${listNews}" var="news">
								<div class="col-md-4 col-xs-12 col-sm-12">
									<a href="detailblog.html" class="blog-post-thumbnail"
										title="Bài viết mẫu" rel="nofollow"> <img
										src="uploads/news/${news.image}" style="margin-bottom: 20px"
										alt="">
									</a>
								</div>
								<div class="col-md-8 col-xs-12 col-sm-12">
									<h3 class="blog-post-title">
										<a href="detailblog?id=${news.id}" title="Bài viết mẫu">${news.title }</a>
									</h3>
									<div class="blog-post-meta">
										<span class="author vcard">Người viết: Huni</span> <span
											class="date"> <time pubdate="" datetime="2019-06-10">${news.datesub}</time>
										</span>
									</div>
									<p class="entry-content">${news.describe}</p>
								</div>
								</br>
								</br>
							</c:forEach>
						</div>
					</article>
				</div>
				<div class="text-center">
					<c:if test="${tag >1 }">
						<a class="btn btn-outline-secondary btn-rounded"
							href="blog?index=${tag-1}">&laquo;</a>
					</c:if>

					<c:forEach begin="1" end="${andPag}" var="i">

						<a
							class="${tag == i?'active':''} btn btn-outline-secondary btn-rounded"
							href="blog?index=${i}">${i}</a>
					</c:forEach>
					<c:if test="${tag < andPag }">
						<a class="btn btn-outline-secondary btn-rounded "
							href="blog?index=${tag+1}">&raquo;</a>
					</c:if>
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