$(document).ready(function() {
	$("#customerForm").submit(function(event) {
		event.preventDefault();
		postCustomer();
	});
	function postCustomer() {
		var customer = {
			customerName: $("#customerName").val(),
			city: $("#city").val()
		}
		console.log(customer);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/customer/addCustomer",
			data: JSON.stringify(customer),
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
		$("#customerName").val("");
		$("#city").val("");
	}
})