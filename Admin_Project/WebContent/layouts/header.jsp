<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
		<a class="navbar-brand brand-logo mr-5" href="admin"><img
			src="templates/images/logo.png" class="mr-2" alt="logo" /></a> <a
			class="navbar-brand brand-logo-mini" href="admin"><img
			src="uploads/avt.png"
			alt="logo" /></a>
	</div>
	<div
		class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
		<button class="navbar-toggler navbar-toggler align-self-center"
			type="button" data-toggle="minimize">
			<span class="ti-view-list"></span>
		</button>
		<ul class="navbar-nav navbar-nav-right">
			<li class="nav-item">
				<p class="small-text mb-0">${admin.displayname}</p>
			</li>
			<li class="nav-item nav-profile dropdown"><a
				class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
				id="profileDropdown"> <img
					src="uploads/avt.png" alt="profile" />
			</a>
				<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
					aria-labelledby="profileDropdown">
					<a class="dropdown-item"> <i class="ti-settings text-primary"></i>
						Tùy chỉnh
					</a> <a class="dropdown-item" href="logout"> <i
						class="ti-power-off text-primary"></i> Đăng xuất
					</a>
				</div></li>
		</ul>
		<button
			class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
			type="button" data-toggle="offcanvas">
			<span class="ti-view-list"></span>
		</button>
	</div>
</nav>
