<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Quản lý danh mục</h4>

					<div class="table-responsive pt-3">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Tên danh mục</th>
									<th>Hình ảnh</th>
									<th></th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listCate}" var="list">
									<tr>
										<td style="width: 90px;">${list.id }</td>
										<td style="width: 100px;">${list.categoryname}</td>
										<td style="width: 190px;"><center>
												<img src="./uploads/category/${list.img}"
													style="width: 90px; height: 90px;"
													alt="${list.categoryname}">
											</center></td>
										<td style="width: 60px; text-align: center;"><a href="#"
											onclick="delete_cate(${list.id})"
											class="btn btn-danger btn-rounded"><i class="ti-trash"></i></a>
											<a class="btn btn-primary btn-rounded"
											href="category_load_update?id_pd=${list.id}"><i
												class="ti-pencil-alt"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<div class="text-center">
						<c:if test="${tag >1 }">
							<a class="btn btn-outline-secondary btn-rounded"
								href="category_manager?index=${tag-1}">&laquo;</a>
						</c:if>

						<c:forEach begin="1" end="${andPag}" var="i">

							<a
								class="${tag == i?'active':''} btn btn-outline-secondary btn-rounded"
								href="category_manager?index=${i}">${i}</a>
						</c:forEach>
						<c:if test="${tag < andPag }">
							<a class="btn btn-outline-secondary btn-rounded "
								href="category_manager?index=${tag+1}">&raquo;</a>
						</c:if>
					</div>
				</div>

			</div>

		</div>
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Thêm danh mục mới</h4>
					<form class="forms-sample" action="addcategory" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="exampleInputUsername1">Tên danh mục</label> <input
								type="text" class="form-control" id="exampleInputUsername1"
								placeholder="Danh mục" name="categoryname_cate">
						</div>
						<div class="form-group">
							<label>Ảnh</label> <input type="file" name="photo_cate"
								class="file-upload-default">
							<div class="input-group col-xs-12">
								<input type="text" class="form-control file-upload-info"
									name="images" disabled placeholder="Upload Image"> <span
									class="input-group-append">
									<button class="file-upload-browse btn btn-primary"
										type="button">Chọn</button>
								</span>
							</div>
						</div>
						<button type="submit" class="btn btn-primary mr-2">Thêm
							mới</button>
						<button class="btn btn-light">Hủy</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
