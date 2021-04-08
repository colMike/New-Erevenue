package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.DeviceReg;
import com.revenue.revenueCollection.Models.Device_linking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRegDao extends JpaRepository<DeviceReg,Integer> {
}
