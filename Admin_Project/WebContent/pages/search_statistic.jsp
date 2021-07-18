<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div style="margin: 20px 10px 20px 20px;">
<div class="row">
<form method="get" action="${pageContext.request.contextPath}/search_statistic">
  <label >Từ ngày:</label>
  <input type="date" name="dayStart">
  <label >Đến ngày:</label>
  <input type="date" name="dayEnd">
  <input type="submit" value="Tìm kiếm">
</form>
</div>
</div>
<div class="table-responsive">
	<table class="table table-bordered" style="width: 100%;height: 400px;">
		<thead>
			<tr>
				<th style="width: 150px;">Mã đơn hàng</th>
				<th style="width: 150px;">Họ tên KH</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Ngày</th>
				<th>Tổng tiền</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${search_statistic}" var="pr">
				<tr>
					<td><div class="a" style="width: 10px;">${pr.id}</div></td>
					<td>${pr.fullname}</td>
					<td>${pr.phone}</td>
					<td>${pr.address}</td>
					<td>${pr.date}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3"
						value="${pr.into}" />
					đ
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
</div>