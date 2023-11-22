package com.Sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sales.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{


}
