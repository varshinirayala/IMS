$(document).ready(function() {
	$("#getall").click(function(event) {
		event.preventDefault();
		ajaxGet();
	});
	function ajaxGet() {
		$.ajax({
			type: "GET",
			url: "/stock/getAllStocks",
			success: function(response) {
				$('#resultDiv').empty();
				$.each(response, function(i, stock) {
					$("#resultDiv").append(" ---> { Stock with stockId = " + stock.stockId +
						", Stock Name = " + stock.stockName + " , price = " + stock.price + " , quantity = " +
						stock.availableQuantity + " } <---");
				});
			},
			error: function(e) {
				alert("error");
				console.log("error: " + e);
			}
		});
	}
})