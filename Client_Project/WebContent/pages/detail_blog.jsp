    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <div>
    <div>
      <img src="templates/images/collection_banner.jpg" alt="Products">
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
              <span><span style="color: #777777">Tin tức</span></span>
            </li>
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
                     
                <c:forEach items= "${listnews }" var="listnews">
                <div class="item-article clearfix">                  
                  <div class="post-image">
                    <a href=""><img src="uploads/news/${listnews.image }" alt="Bài viết mẫu"></a>
                  </div>                 
                  <div class="post-content">
                    <h3>
                      <a href="detailblog?id=${listnews.id}">${listnews.title }</a>
                    </h3>
                    <span class="date">
                      ${listnews.datesub }
                    </span>
                  </div>
                </div>
                </c:forEach>
              </div>
          </div>
          <div class="menu-blog">
            <div class="group-menu">
              <div class="sidebarblog-title title_block">
                <h2>Danh mục blog<span class="fa fa-angle-down"></span></h2>
              </div>
              <div class="layered-category">
                <ul class="menuList-links">
                  <li class=""><a href="home.html" title="Trang chủ"><span>Trang chủ</span></a></li>
                  <li class=""><a href="product.html" title="Bộ sưu tập"><span>Bộ sưu tập</span></a></li>
                  <li class="has-submenu level0 ">
                      <a title="Sản phẩm" >Sản phẩm <span class="icon-plus-submenu" data-toggle="collapse"
                          href="#collapseExample" role="button" aria-expanded="false"
                          aria-controls="collapseExample"></span></a>
                      <div class="collapse" id="collapseExample">
                        <div class="card card-body" style="border:0">
                          <ul class="menu-product">
                            <li><a href="detailproduct.html" title="Sản phẩm - Style 1">Sản phẩm - Style 1</a></li>
                            <li><a href="detailproduct.html" title="Sản phẩm - Style 2">Sản phẩm - Style 2</a></li>
                            <li><a href="detailproduct.html" title="Sản phẩm - Style 3">Sản phẩm - Style 3</a></li>
                          </ul>
                        </div>
                      </div>
                    </li>
                  <li class=""><a href="introduce.html" title="Giới thiệu"><span>Giới thiệu</span></a></li>
                  <li class="active"><a href="blog.html" title="Blog"><span>Blog</span></a></li>
                  <li class=""><a href="contact.html" title="Liên hệ"><span>Liên hệ</span></a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-9 col-sm-12 col-xs-12 article-area">
        <div class="content-page">
          <div class="article-content">
            <div class="box-article-heading clearfix">
          
              <h1 class="sb-title-article">${detail_news.title }</h1>
              <ul class="article-info-more" style="padding-left: 0">
                <li> Người viết: Khanh <time pubdate="" datetime="2019-06-11">${detail_news.datesub }</time></li>
                <li><i class="far fa-file-alt"></i><a style="color:black;text-decoration: none;" href="#"> Tin tức</a> </li>
              </ul>
            </div>
            <div class="article-pages">
            <p>
                <img src="uploads/news/${detail_news.image}" alt="Falcon color block">
                
              </p>
              <p>${detail_news.content }</p>
              
              
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--gallery-->
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
              <img class="img-resize" src="templates/images/shoes/gallery_item_1.jpg" alt="">
            </div>
          </li>
          <li>
            <div class="gallery_item">
              <img class="img-resize" src="templates/images/shoes/gallery_item_2.jpg" alt="">
            </div>
          </li>
          <li>
            <div class="gallery_item">
              <img class="img-resize" src="templates/images/shoes/gallery_item_3.jpg" alt="">
            </div>
          </li>
          <li>
            <div class="gallery_item">
              <img class="img-resize" src="templates/images/shoes/gallery_item_4.jpg" alt="">
            </div>
          </li>
          <li>
            <div class="gallery_item">
              <img class="img-resize" src="templates/images/shoes/gallery_item_5.jpg" alt="">
            </div>
          </li>
          <li>
            <div class="gallery_item">
              <img class="img-resize" src="templates/images/shoes/gallery_item_6.jpg" alt="">
            </div>
          </li>
        </ul>
      </div>
    </div>
  </section>
  