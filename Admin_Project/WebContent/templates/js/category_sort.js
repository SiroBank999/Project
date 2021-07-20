$(document).ready(function() {
	$("#sortable").sortable({
		handle: false,
		placeholder: 'ui-state-hightlight',
		update: function(event, ui) {
			var page_array = new Array();
			var token = $('input[name="token"]').val();
			$('#sortable tr').each(function() {
				page_array.push($(this).attr("id"));
			});
			$.ajax({
				url: "/category_manager",
				method: "POST",
				data: {
					page_array: page_array,
					token: token
				},
				success: function(data) {
					
				}
			});
		}

	});
});