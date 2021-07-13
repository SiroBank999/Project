function delete_cate(id) {
	var option = confirm("Bạn có muốn xóa danh mục này không?");
	if (option === true) {
		window.location.href = 'Category_delete?id=' + id;
	}

}