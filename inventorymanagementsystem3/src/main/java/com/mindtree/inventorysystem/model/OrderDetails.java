package com.mindtree.inventorysystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Customer customer;
	private double totalPrice;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderStock> orderedStocks = new ArrayList<>();

	public void setOrderedStocks(List<OrderStock> orderedStocks) {
		this.orderedStocks = orderedStocks;
		for (OrderStock orderStock : orderedStocks) {
			orderStock.setOrder(this);
		}
	}

}
