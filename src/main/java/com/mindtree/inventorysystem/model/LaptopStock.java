package com.mindtree.inventorysystem.model;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaptopStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private String stockName;
	private double price;
	private int availableQuantity;

	public LaptopStock(String stockName) {
		super();
		this.stockName = stockName;
	}

	public static Comparator<LaptopStock> comparator = new Comparator<LaptopStock>() {

		@Override
		public int compare(LaptopStock s1, LaptopStock s2) {
			int result = (int) (s1.price - s2.price);
			if (result == 0) {
				return s1.stockName.compareTo(s2.stockName);
			}
			return result;
		}
	};
}
