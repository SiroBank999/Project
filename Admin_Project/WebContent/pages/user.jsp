<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Quản lý khách hàng</h4>
					
					<div class="table-responsive pt-3">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Họ tên</th>
									<th>Tên đăng nhập</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Trạng thái</th>
									<th>Thao tác</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listUser}" var="list">
									<tr>
										<td>${list.id }</td>
										<td>${list.fullname}</td>
										<td>${list.username}</td>
										<td>${list.email}</td>
										<td>${list.phone}</td>
										<td>${list.status}</td>
										<td>
											<a href="user_update?id=${list.id}" class="border btn-sm ">
			                        			<i class="ti-eye text-success"></i>                          
			                      			</a>
											
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					
                  
					</div>
					<br>
			
				</div>
				
			</div>
			
		</div>
		
	</div>
</div>
