<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="card modal-content">
				<div class="card-body">
					<h4 class="card-title">Cập nhật sản phẩm</h4>
					<a href="product_manager"
						class="float-right btn btn-outline-success">Trở lại</a> <br>
					<form class="forms-sample" action="product_update" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="exampleInputUsername1">ID</label> <input type="text"
								class="form-control" name="id" readonly="readonly"
								placeholder="ID" value="${pd.id}">
						</div>
						<div class="form-group">
							<label for="exampleInputUsername1">Tên sản phẩm</label> <input
								type="text" class="form-control" name="productname"
								placeholder="Tên sản phẩm" value="${pd.productname}">
						</div>
						<div class="form-group">
							<label>Ảnh</label> <input type="file" name="photo"
								class="file-upload-default">
							<div class="input-group col-xs-12" style="color: #6c757d">
								<input type="text" class="form-control file-upload-info"
									name="images" disabled placeholder="Upload Image"
									value="${pd.image}"> <span class="input-group-append">
									<button class="file-upload-browse btn btn-primary"
										type="button">Chọn</button>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Đơn giá</label> <input
								type="text" class="form-control" name="price"
								placeholder="Đơn giá" value="${pd.price}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Giảm giá</label> <input
								type="text" class="form-control" name="sale"
								placeholder="Giá giảm" value="${pd.sale}">
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect3">Trạng thái</label> <select
								class="form-control form-control-sm" name="status"
								style="color: #6c757d">
								<option>NEW</option>
								<option>HẾT HÀNG</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputUsername1">Ngày nhập</label> <input
								type="text" class="form-control" name="date"
								placeholder="Tên sản phẩm" value="${pd.date}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Chất liệu</label> <input
								type="text" class="form-control" name="fabric"
								placeholder="Giá giảm" value="${pd.fabric}">
						</div>
						<div class="form-group">
							<label for="exampleTextarea1">Mô tả</label>
							<textarea class="form-control" id="editor" name="describe"
								rows="4">${pd.describe}</textarea>
							<script type="text/javascript">
								CKEDITOR.replace('editor');
							</script>
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect">Danh mục</label> <select
								style="color: #6c757d" class="form-control form-control-sm"
								name="category">
								<c:forEach items="${listcategory}" var="listc">
									<option>${listc.categoryname}</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-success mr-2">Cập
							nhật</button>

					</form>
				</div>
			</div>
		</div>
	</div>