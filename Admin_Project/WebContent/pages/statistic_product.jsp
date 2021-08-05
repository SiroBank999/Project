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
		data.addColumn('string', 'Tên sản phẩm');
		data.addColumn('number', 'Số lượng');
		<%for (Statistic rv : statistic.top5Sales()) 
		{%>data.addRows([[ '<%=rv.getNameproduct()%>',<%=rv.getAmount()%>]]);
		<%}%>
	var options = {
			'title' : 'TOP 5 SẢN PHẨM BÁN CHẠY TRONG THÁNG',
			'width' : 950,
			'height' : 400
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
<div style="margin: 20px 10px 20px 20px;">
	<div class="row">
		<div class="col-md-8">
		</div>
		<div class="col-md-2">
			<button class="btn btn-success btn-rounded" data-toggle="modal"
				data-target="#dialog1">Thống kê</button>
		</div>
		<div class="col-md-2">
			<button class="btn btn-success btn-rounded" data-toggle="modal"
				data-target="#dialog2">Theo danh mục</button>
		</div>
	</div>
</div>

<div class="table-responsive">
	<table class="table table-bordered" style="width: 90%;margin-left: 45px;">
		<thead>
			<tr>
				<th style="width: 400px;text-align: center;">Tên sản phẩm</th>
				<th style="width: 180px;text-align: center;">Giá bán</th>
				<th style="width: 130px;text-align: center;">Số lượng</th>
				<th style="text-align: center;">Thành tiền</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items="${listRevPr}" var="pr">
				<tr>
					<td><div class="a">${pr.nameproduct}</div></td>
					<td><div style="float: right;"><fmt:formatNumber type="number" maxFractionDigits="3"
							value="${pr.price}" /> đ</div></td>
					<td><div style="float: right;">${pr.amount}</div></td>
					<td><div style="float: right;"><fmt:formatNumber type="number" maxFractionDigits="3"
							value="${pr.totals}" /> đ</div></td>
				</tr>

			</c:forEach>

		</tbody>
	</table>
	<br>
</div>
<div class="modal fade" id="dialog1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div id="chart_div"></div>

		</div>
	</div>
</div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Tên danh mục');
      data.addColumn('number', 'Tổng');
      <%for (Statistic rv : statistic.totalCate()) 
		{%>
      data.addRows([
        ['<%=rv.getNameproduct()%>',<%=rv.getAmount()%>]
      ]);
<%}%>
      var options = {
    		  position: 'top', 
    		  fontSize: 18,
    		  width : 700,
    			height : 500,
        title: 'Doanh thu sản phẩm theo danh mục',
        sliceVisibilityThreshold: .2
      };

      var chart = new google.visualization.PieChart(document.getElementById('piechart'));
      chart.draw(data, options);
    }
    </script>
<div class="modal fade" id="dialog2" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
    		    <div id="piechart"></div>
		</div>
	</div>
</div>