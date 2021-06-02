$(document).ready(function() {
	$("#stockForm").submit(function(event) {
		event.preventDefault();
		postStock();
	});
	function postStock() {
		var stock = {
			stockName: $("#stockName").val(),
			price: $("#price").val(),
			availableQuantity: $("#quantity").val()
		}
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/stock/addStock",
			data: JSON.stringify(stock),
			dataType: "json",
			success: function(response) {
				alert("posted");
			},
			error: function(error) {
				alert("error");
			}
		});
		resetData();
	}
	function resetData() {
		$("#stockName").val("");
		$("#price").val("");
		$("#quantity").val("");
	}
})