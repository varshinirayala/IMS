$(document).ready(function() {
	var i = 0;
	$("#addstock").click(function() {

		$("#fig").append("<div>Stock Name:<input type='text' id='sname" + i + "'> Quantity to Order: <input type='number' id='quantity" + i + "'></div><br>");
		i++;
	});
	$("#submit").on("click", function() {
		var stocks = [];
		var stock = {};
		for (var j=  0; j < i; j++) {
			sname = "sname" +  j;
			quantity = "quantity" + j;
			var stockName = document.getElementById(sname).value;
			var orderedQuantity = document.getElementById(quantity).value;
			stock = { stockName, orderedQuantity };
			stocks.push(stock);
			console.log(stocks);
		}

		orderDetails = {
			customer: $("#customerName").val(),
			orderedStocks: stocks
		}
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/customer/orderStock",
			data: JSON.stringify(orderDetails),
			dataType: "json",
			success: function(response) {
				alert("posted");
			},
			error: function(error) {
				alert("error:" + error);
			}
		});
		resetData();
	});
	function resetData() {
		$("#fig").empty();
		$("#customerName").val("");
	}
})