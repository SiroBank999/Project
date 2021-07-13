<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Quản lý liên hệ</h4>

					<div class="table-responsive pt-3">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Họ tên</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Nội dung</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${contact}" var="list">
									<tr>
										<td>${list.id }</td>
										<td>${list.name}</td>
										<td>${list.email}</td>
										<td>${list.phone}</td>
										<td>${list.content}</td>

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