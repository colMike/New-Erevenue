package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.LandRate;

import com.revenue.revenueCollection.Models.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LandRateDao extends JpaRepository<LandRate,Integer> {
    @Query("select p from LandRate p  where p.approved='N'")
    List<LandRate> getPermitToApprove();
    @Query("select p from LandRate p  where p.approved='V'")
    List<LandRate> findAll();
    @Query( "SELECT u FROM LandRate u WHERE u.validity <> YEAR(getdate())")
    List<LandRate> findAllToRenew();
}
