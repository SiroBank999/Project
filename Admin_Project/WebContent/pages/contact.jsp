<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title mb-0">THÔNG TIN LIÊN HỆ</p>
					<div class="table-responsive">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Họ tên</th>
									<th>Số điện thoại</th>
									<th>Địa chỉ email</th>
									<th>Nội dung</th>
									<th>Tình trạng</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${contact }" var="list">
									<tr>
										<td>${list.id }</td>
										<td>${list.name}</td>
										<td>${list.phone }</td>
										<td>${list.email }</td>
										<td>${list.content }</td>
										<td>${list.status }</td>
										<td><a class="btn btn-primary btn-rounded"
											href="contact_update?id=${list.id}"><i
												class="ti-pencil-alt"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>