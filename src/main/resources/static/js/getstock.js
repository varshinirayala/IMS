$(document).ready(function() {
	$("#submit").click(function(event) {
		event.preventDefault();
		ajaxGet();
	});
	function ajaxGet() {
		var stockName = $("#stockName").val();
		$.ajax({
			type: "GET",
			url: "/stock/getStockByName/" + stockName,
			success: function(stock) {
				$('#resultDiv').empty();
				$("#resultDiv").append(" ----> { Stock with stockId = " + stock.stockId +
					", Stock Name = " + stock.stockName + " , price = " + stock.price + " , quantity = " +
					stock.availableQuantity + " } <----");
			},
			error: function(e) {
				$("#resultDiv").append("No Stock Found");
				alert("error");
				console.log("error: " + e);
			}
		});
	}
})