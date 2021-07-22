<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Tin tức</h4>
					<p class="card-description float-right">

						<button type="button" class="btn btn-success btn-rounded"
							data-toggle="modal" data-target="#myModal">Thêm tin tức
						</button>
					</p>
					<!-- The Modal -->
					<div class="modal" id="myModal">
						<div class="col-md-12 grid-margin stretch-card modal-dialog">
							<div class="card modal-content">
								<div class="card-body">
									<h4 class="card-title">Thêm tin tức mới</h4>
									<form class="forms-sample" action="news_add" method="post"
										enctype="multipart/form-data">
										<div class="form-group">
											<label for="exampleInputUsername1">Tiêu đề</label> <input
												type="text" class="form-control" name="Title"
												placeholder="Tiêu đề">
										</div>
										<div class="form-group">
											<label>Ảnh</label> <input type="file" name="photo_news"
												class="file-upload-default">
											<div class="input-group col-xs-12">
												<input type="text" class="form-control file-upload-info"
													name="images" disabled placeholder="Upload Image">
												<span class="input-group-append">
													<button class="file-upload-browse btn btn-primary"
														type="button">Chọn</button>
												</span>
											</div>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Mô tả</label> <input
												type="text" class="form-control" name="Describe"
												placeholder="Mô tả">
										</div>
										
								
										<div class="form-group">
											<label for="exampleTextarea1">Nội dung</label>
											<textarea class="form-control" id="editor" name="Content"
												rows="4"></textarea>
											<script type="text/javascript">
								CKEDITOR.replace('editor');
							</script>
										</div>
										
										<div class="form-group">
											<label for="exampleFormControlSelect3">Trạng thái</label> <input
												type="text" class="form-control" name="Status"
												placeholder="Trạng thái">

										</div>
										<button type="submit" class="btn btn-success mr-2">Thêm
											mới</button>

									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered" style="width: 75%;">
							<thead>
								<tr>
									<th>#</th>
									<th>Tiêu đề</th>
									<th>Hình ảnh</th>
									<th>Mô tả</th>
									<th>Nội dung</th>
									<th>Ngày nhập</th>
									<th>Trạng thái</th>
									
									<th></th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${listnews}" var="nw">
									<tr>
										<td><div class="a" style="width: 10px;">${nw.id}</div></td>
										<td>${nw.title}</td>
										<td>
												<img src="./uploads/${nw.image}"
													style="width: 80px; height: 80px" alt=""/>
											</td>
										<td>${nw.describe}</td>
										
										<td>${nw.content}</td>
										<td>${nw.datesub}</td>
										<td><div class="b" style="width: 40px;">${nw.status}</div></td>


										<td><a href="news_delete?id_news=${nw.id}" 
											class="btn btn-danger btn-rounded"><i class="ti-trash"></i></a>
											<a class="btn btn-primary btn-rounded"
											href="news_load_update?id_nw=${nw.id}"><i
												class="ti-pencil-alt"></i></a></td>
									</tr>

								</c:forEach>

							</tbody>
						</table>
						<br>
						<div class="text-center" style="margin-bottom: 14px">
							<c:if test="${tag >1 }">
								<a class="btn btn-outline-dark btn-rounded"
									href="news?index=${tag-1}">&laquo;</a>
							</c:if>

							<c:forEach begin="1" end="${andPag}" var="i">

								<a
									class="${tag == i?'active':''} btn btn-outline-dark btn-rounded"
									href="news?index=${i}">${i}</a>
							</c:forEach>
							<c:if test="${tag < andPag }">
								<a class="btn btn-outline-dark btn-rounded "
									href="news?index=${tag+1}">&raquo;</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>