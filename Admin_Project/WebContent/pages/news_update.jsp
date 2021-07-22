<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="card modal-content">
				<div class="card-body">
					<h4 class="card-title">Cập nhật tin tức</h4>
					<a href="news"
						class="float-right btn btn-outline-success">Trở lại</a> <br>
					<form class="forms-sample" action="news_update" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="exampleInputUsername1">ID</label> <input type="text"
								class="form-control" name="id" readonly="readonly"
								placeholder="ID" value="${nw.id}">
						</div>
						<div class="form-group">
							<label for="exampleInputUsername1">Tiêu đề</label> <input
								type="text" class="form-control" name="title"
								placeholder="Tiêu đề" value="${nw.title}">
						</div>


						<div class="form-group">
							<label>Ảnh mới </label> <input type="file" name="photo"
								class="file-upload-default">
							<div class="input-group col-xs-12" style="color: #6c757d">
								<input type="text" class="form-control file-upload-info"
									name="images" disabled value="${nw.image}"> <span
									class="input-group-append">
									<button class="file-upload-browse btn btn-primary"
										type="button">Chọn</button>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Mô tả</label> <input
								type="text" class="form-control" name="describe"
								placeholder="Mô tả" value="${nw.describe}">
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect3">Trạng thái</label> <input
								type="text" class="form-control" name="status"
								placeholder="Trạng thái" value="${nw.status}">
						</div>
						<div class="form-group">
							<label for="exampleTextarea1">Nội dung</label>
							<textarea class="form-control" id="editor" name="content"
								rows="4">${nw.content}</textarea>
							<script type="text/javascript">
								CKEDITOR.replace('editor');
							</script>
						</div>
					
						<button type="submit" class="btn btn-success mr-2">Cập
							nhật</button>
					</form>
				</div>
			</div>
		</div>
	</div>