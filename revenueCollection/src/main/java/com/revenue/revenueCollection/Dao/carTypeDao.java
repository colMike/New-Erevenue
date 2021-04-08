package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.Agent;
import com.revenue.revenueCollection.Models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carTypeDao  extends JpaRepository<CarType,Integer> {
}
