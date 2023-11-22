package com.Sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sales.model.Subscriptions;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer>{

}
