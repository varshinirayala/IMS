package com.mindtree.inventorysystem.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/stock")
	public String stock() {
		return "stock";
	}

	@GetMapping("/customer")
	public String customer() {
		return "customer";
	}

	@GetMapping("/allstocks")
	public String allStocks() {
		return "allstocks";
	}

	@GetMapping("/getstockbyname")
	public String getStockByName() {
		return "getstockbyname";
	}

	@GetMapping("/order")
	public String order() {
		return "order";
	}

}
