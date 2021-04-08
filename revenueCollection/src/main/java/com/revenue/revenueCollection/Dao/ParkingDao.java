package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.Customer;
import com.revenue.revenueCollection.Models.Parking;
import com.revenue.revenueCollection.Models.priceConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingDao  extends JpaRepository<Parking,Integer> {

}
