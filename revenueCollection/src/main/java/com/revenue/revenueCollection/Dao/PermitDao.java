package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.Device_linking;
import com.revenue.revenueCollection.Models.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PermitDao extends JpaRepository<Permit,Integer> {
    @Query("select p from Permit p  where p.approved='N'")
    List<Permit> getPermitToApprove();
    @Query("select p from Permit p where p.approved='V'")
    List<Permit> findAll();
   @Query("select p from Permit  p where p.regNo=?1 and p.status='RW'")
    List<Permit> findByRegNo(int businessId);
    @Query( "SELECT u FROM Permit u WHERE u.validity <> YEAR(getdate())")
    List<Permit> findAllToRenew();
}
