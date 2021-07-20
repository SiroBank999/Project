<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title mb-0 text-center">ĐƠN HÀNG #${order.id}</p>
					<br>
					<form action="order_detail" method="post">
					<div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Họ và tên</label>
                          <div class="col-sm-9">
                            <input type="text" name="fullname" class="form-control" value="${order.fullname}"/>
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Điện thoại</label>
                          <div class="col-sm-9">
                            <input type="text" name="phone" class="form-control" value="${order.phone}" />
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Email</label>
                          <div class="col-sm-9">
                            <input type="text" name ="email" class="form-control" value="${order.email}" />
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Địa chỉ</label>
                          <div class="col-sm-9">
                            <input type="text" name="address" class="form-control" value="${order.address}" />
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Ngày đặt</label>
                          <div class="col-sm-9">
                            <input type="date" class="form-control"  value="${order.date}" />
                          </div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Trạng thái</label>
                          <div class="col-sm-9">
                            <select class="form-control" name="status" >
                              <option style="font-size: 15px;">${order.status}</option>
                              <option>Đang xử lý</option>
                              <option>Đang giao</option>
                              <option>Hoàn thành</option>
                              <option>Đã hủy</option>
                              <option>Đơn mới</option>
                            </select>
                          </div>
                        </div>
                      </div>
                     </div>
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>STT</th>
									<th>Sản phẩm</th>
									<th>Số lượng</th>
									<th>Size</th>
									
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${ListItem}" var="item">
									<tr>
										<td>${item.id}</td>
										<td>${item.productname}</td>
										<td>${item.quantity}</td>
										<td>${item.size}</td>
									</tr>
									</c:forEach>
							</tbody>
							<tfoot>
									<tr>
								    	<th colspan="3">Thành tiền</th>
								    	<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${order.into}" /> đ</td>
								  	</tr>			
							</tfoot>
						</table>
						<div class="text-center">
							<button type="submit" class="btn btn-sm btn-success">Cập nhật</button>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>