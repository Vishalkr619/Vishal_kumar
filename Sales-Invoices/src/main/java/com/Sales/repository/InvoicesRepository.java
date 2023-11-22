package com.Sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sales.model.Invoices;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Integer> {

	
}
