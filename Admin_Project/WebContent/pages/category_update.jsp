<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="card modal-content">
				<div class="card-body">
					<h4 class="card-title">Cập nhật danh mục</h4>
					<a href="category_manager"
						class="float-right btn btn-outline-success">Trở lại</a> <br>
					<form class="forms-sample" action="category_update" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="exampleInputUsername1">ID</label> 
							<input type="text"
								class="form-control" name="id_c" readonly="readonly"
								placeholder="ID" value="${pd.id}">
						</div>
						<div class="form-group">
							<label for="exampleInputUsername1">Tên danh mục</label> <input
								type="text" class="form-control" name="categoryname_c"
								placeholder="Tên danh mục" value="${pd.categoryname}">
						</div>
						<div class="form-group">
							<label for="exampleInputUsername1">Ảnh cũ</label> <input
								type="text" class="form-control" name="img1"
								placeholder="Ảnh" value="${pd.img}">
						</div>
						<div class="form-group">
							<label>Ảnh mới</label> <input type="file" name="photo1"
								class="file-upload-default">
							<div class="input-group col-xs-12" style="color: #6c757d">
								<input type="text" class="form-control file-upload-info"
									name="images" disabled placeholder="Upload Image"
									><span
									class="input-group-append">
									<button class="file-upload-browse btn btn-primary"
										type="button">Chọn</button>
								</span>
							</div>
						</div>
						<button type="submit" class="btn btn-success mr-2">Cập
							nhật</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>