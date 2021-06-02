package com.mindtree.inventorysystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.inventorysystem.model.LaptopStock;

@Repository
public interface StockRepository extends JpaRepository<LaptopStock, Integer> {

	Optional<LaptopStock> findByStockName(String stockName);

}
