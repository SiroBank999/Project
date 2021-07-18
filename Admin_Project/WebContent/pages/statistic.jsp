<%@page import="Model.Statistic"%>
<%@page import="Service.Statistic_service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
Statistic_service statistic = new Statistic_service();
%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Tháng');
		data.addColumn('number', 'Tổng');
		<%for (Statistic rv : statistic.getRevenueMonth()) {%>
		data.addRows([ [ 'Tháng <%=rv.getMonth()%>',<%=rv.getTotals()%>
	] ]);
<%}%>
	var options = {
			'title' : 'DOANH THU THEO THÁNG (Năm hiện tại)',
			'width' : 1050,
			'height' : 400
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
<div style="margin: 20px 10px 20px 20px;">
	<div class="row">
		<div class="col-md-8" style="margin-top: 7px;">
			<form method="get"
				action="${pageContext.request.contextPath}/search_statistic">
				<label>Từ ngày:</label> <input type="date" name="dayStart">
				<label>Đến ngày:</label> <input type="date" name="dayEnd"> <input
					type="submit" value="Tìm kiếm">
			</form>
		</div>
		<div class="col-md-2">
			<button class="btn btn-success btn-rounded" data-toggle="modal"
				data-target="#dialog1">Doanh thu tháng</button>
		</div>
		<div class="col-md-2">
			<button class="btn btn-success btn-rounded" data-toggle="modal"
				data-target="#dialog2">Doanh thu năm</button>
		</div>
	</div>
</div>

<div class="table-responsive">
	<table class="table table-bordered" style="width: 100%;">
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

			<c:forEach items="${listOrder}" var="pr">
				<tr>
					<td><div class="a" style="width: 10px;">${pr.id}</div></td>
					<td>${pr.fullname}</td>
					<td>${pr.phone}</td>
					<td>${pr.address}</td>
					<td>${pr.date}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3"
							value="${pr.into}" /> đ</td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
	<br>
	<div class="text-center">
		<c:if test="${tag >1 }">
			<a class="btn btn-outline-secondary btn-rounded"
				href="doanhthu?index=${tag-1}">&laquo;</a>
		</c:if>

		<c:forEach begin="1" end="${andPag}" var="i">

			<a
				class="${tag == i?'active':''} btn btn-outline-secondary btn-rounded"
				href="doanhthu?index=${i}">${i}</a>
		</c:forEach>
		<c:if test="${tag < andPag }">
			<a class="btn btn-outline-secondary btn-rounded "
				href="doanhthu?index=${tag+1}">&raquo;</a>
		</c:if>
	</div>
</div>
<div class="modal fade" id="dialog1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div id="chart_div"></div>

		</div>
	</div>
</div>

<script type="text/javascript">
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Năm');
		data.addColumn('number', 'Tổng');
		<%
		for (Statistic rv : statistic.getStatisticYear()) {
		%>
		data.addRows([ [ 'Năm <%=rv.getYear()%>',<%=rv.getTotals()%>] ]);
		<%
		}
		%>
	var options = {
			'title' : 'DOANH THU TỪNG NĂM',
			'width' : 700,
			'height' : 300
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart'));
		chart.draw(data, options);
	}
</script>
<div class="modal fade" id="dialog2" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div id="chart"></div>
		</div>
	</div>
</div>
