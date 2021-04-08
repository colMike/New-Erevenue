package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.Customer_validation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerValidationDao extends JpaRepository<Customer_validation,Integer> {
}
