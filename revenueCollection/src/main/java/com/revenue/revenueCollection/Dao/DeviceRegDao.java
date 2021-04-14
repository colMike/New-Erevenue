package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.DeviceReg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRegDao extends JpaRepository<DeviceReg, Integer> {
//  DeviceReg findByDevice_imei(String imei);
}
