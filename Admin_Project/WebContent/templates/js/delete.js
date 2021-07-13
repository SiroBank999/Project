function warning(id) {
	var option = confirm("Bạn có muốn xóa sản phẩm này không?");
	if (option === true) {
		window.location.href = 'product_delete?id=' + id;
	}

}
