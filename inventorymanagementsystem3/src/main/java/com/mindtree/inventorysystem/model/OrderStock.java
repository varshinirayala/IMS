package com.mindtree.inventorysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderStockId;
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private OrderDetails order;
	private String stockName;
	private int orderedQuantity;

}
