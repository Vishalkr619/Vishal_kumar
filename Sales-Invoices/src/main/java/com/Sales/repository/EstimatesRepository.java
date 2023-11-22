package com.Sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sales.model.Estimates;

@Repository
public interface EstimatesRepository extends JpaRepository<Estimates, Integer>{

}
