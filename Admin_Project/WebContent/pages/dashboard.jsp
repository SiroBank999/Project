<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="content-wrapper">
	<div class="row">
		<div class="col-md-12 grid-margin">
			<div class="d-flex justify-content-between align-items-center">
				<div>
					<h4 class="font-weight-bold mb-0">F5 Dashboard</h4>
				</div>

			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title text-md-center text-xl-left">Doanh thu</p>
					<div
						class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
						<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0"><%=request.getAttribute("totals")%></h3>
						<i class="ti-calendar icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
					</div>
					<p class="mb-0 mt-2 text-danger">
					<center>(1 Tháng )</center>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-3 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title text-md-center text-xl-left">Khách hàng</p>
					<div
						class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
						<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0"><%=request.getAttribute("customers")%></h3>
						<i class="ti-user icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
					</div>
					<p class="mb-0 mt-2 text-danger"></p>
				</div>
			</div>
		</div>
		<div class="col-md-3 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title text-md-center text-xl-left">Đơn hàng</p>
					<div
						class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
						<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0"><%=request.getAttribute("order")%></h3>
						<i class="ti-agenda icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
					</div>
					<p class="mb-0 mt-2 text-success">
					<center>(Đơn hàng mới)</center>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-3 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title text-md-center text-xl-left">Lợi nhuận</p>
					<div
						class="d-flex flex-wrap justify-content-between justify-content-md-center justify-content-xl-between align-items-center">
						<h3 class="mb-0 mb-md-2 mb-xl-0 order-md-1 order-xl-0">61344</h3>
						<i class="ti-layers-alt icon-md text-muted mb-0 mb-md-3 mb-xl-0"></i>
					</div>
					<p class="mb-0 mt-2 text-success">
						23.00%<span class="text-black ml-1"><small>(1 Tháng
								)</small></span>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<p class="card-title">Chi tiết bán hàng</p>
					<div id="sales-legend" class="chartjs-legend mt-4 mb-2"></div>
					<canvas id="sales-chart"></canvas>
				</div>
				<div class="card border-right-0 border-left-0 border-bottom-0">
					<div class="d-flex justify-content-center justify-content-md-end">
						<div class="dropdown flex-md-grow-1 flex-xl-grow-0">
							<button
								class="btn btn-lg btn-outline-light dropdown-toggle rounded-0 border-top-0 border-bottom-0"
								type="button" id="dropdownMenuDate2" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="true">Hôm nay</button>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="dropdownMenuDate2">
								<a class="dropdown-item" href="#">January - March</a> <a
									class="dropdown-item" href="#">March - June</a> <a
									class="dropdown-item" href="#">June - August</a> <a
									class="dropdown-item" href="#">August - November</a>
							</div>
						</div>
						<button
							class="btn btn-lg btn-outline-light text-primary rounded-0 border-0 d-none d-md-block"
							type="button">Xem tất cả</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6 grid-margin stretch-card">
			<div class="card border-bottom-0">
				<div class="card-body pb-0">
					<p class="card-title">Mua hàng</p>
					<div class="d-flex flex-wrap mb-5">
						<div class="mr-5 mt-3">
							<p class="text-muted">Trạng thái</p>
							<h3>62</h3>
						</div>
						<div class="mr-5 mt-3">
							<p class="text-muted">Người dùng mới</p>
							<h3><%=request.getAttribute("user")%></h3>
						</div>
						<div class="mr-5 mt-3">
							<p class="text-muted">Trò chuyện</p>
							<h3><%=request.getAttribute("contact")%></h3>
						</div>
						<div class="mt-3">
							<p class="text-muted">Phản hồi</p>
							<h3>509</h3>
						</div>
					</div>
				</div>
				<canvas id="order-chart" class="w-100"></canvas>
			</div>
		</div>
	</div>
</div>