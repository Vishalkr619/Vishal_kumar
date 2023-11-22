package com.Sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sales.model.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer>{

}
