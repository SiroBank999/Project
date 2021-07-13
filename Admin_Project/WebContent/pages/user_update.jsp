<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<div class="card modal-content">
				<div class="card-body">
				<h4 class="card-title">Cập nhật khách hàng</h4>
			
				<form class="forms-sample" action="user_update" method="post"
					>
					
					<div class="form-group">
						<label for="exampleFormControlSelect3">Trạng thái</label> <select
							class="form-control form-control-sm" name="status_1">
							<option>ENABLE</option>
							<option>DISABLE</option>
						</select>
					</div>
					<button type="submit" class="btn btn-success mr-2">Cập
						nhật</button>

				</form>
			</div>
		</div>
	</div>
</div>
</div>