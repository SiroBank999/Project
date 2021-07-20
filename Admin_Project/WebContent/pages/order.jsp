<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title mb-0">ĐƠN HÀNG</p>
					<div class="row">
						<div class="col-md-4">
							<ul class="navbar-nav mr-lg-2">
								<li class="nav-item nav-search d-none d-lg-block">
									<div class="input-group">
										<div class="input-group-prepend hover-cursor"
											id="navbar-search-icon">
											<span class="input-group-text" id="search"> <i
												class="ti-search"></i>
											</span>
										</div>
										<input type="text" class="form-control"
											id="navbar-search-input" placeholder="Tìm kiếm..."
											aria-label="search" aria-describedby="search">
									</div>
								</li>
							</ul>
						</div>
						<div class="col-md-6"></div>
						<div class="col-md-2">
							<form method="get" action="" name="productForm">
								<select name="donhang"
									onchange="document.productForm.submit ()">
									<option value="tatca">Tất cả</option>
									<option value="donmoi">Đơn mới</option>
									<option value="dangxuli">Đang xử lí</option>
									<option value="hoanthanh">Hoàn thành</option>
									<option value="dahuy">Đã hủy</option>
								</select>
							</form>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Mã đơn hàng</th>
									<th>Họ tên</th>
									<th>SĐT</th>
									<th>Ngày</th>
									<th>Địa chỉ</th>
									<th>Thành tiền</th>
									<th>Trạng thái</th>
									<th>Thao tác</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listOrderNew}" var="pr">
									<tr>
										<td>${pr.id }</td>
										<td>${pr.fullname }</td>
										<td>${pr.phone }</td>
										<td>${pr.date }</td>
										<td>${pr.address }</td>
										<td class="text-danger">${pr.into }</td>
										<c:set var="status" value="${pr.status }" />
										<c:choose>
											<c:when test="${status=='Đơn mới' }">
												<td><label class="badge badge-info">${pr.status }</label></td>
											</c:when>
											<c:when test="${status=='Đang xử lí' }">
												<td><label class="badge badge-warning">${pr.status }</label></td>
											</c:when>
											<c:when test="${status=='Đã hủy' }">
												<td><label class="badge badge-danger">${pr.status }</label></td>
											</c:when>
											<c:when test="${status=='Hoàn thành' }">
												<td><label class="badge badge-success">${pr.status }</label></td>
											</c:when>
										</c:choose>
										<td><a class="border btn-sm " href="order_detail?id=${pr.id}"> <i
												class="ti-eye text-success"></i>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<c:if test="${luachon==NULL }">
							<div class="text-center">
								<c:if test="${tag >1 }">
									<a class="btn btn-outline-secondary btn-rounded"
										href="order_manager?index=${tag-1}">&laquo;</a>
								</c:if>

								<c:forEach begin="1" end="${andPag}" var="i">

									<a
										class="${tag == i?'active':''} btn btn-outline-secondary btn-rounded"
										href="order_manager?index=${i}">${i}</a>
								</c:forEach>
								<c:if test="${tag < andPag }">
									<a class="btn btn-outline-secondary btn-rounded "
										href="order_manager?index=${tag+1}">&raquo;</a>
								</c:if>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>