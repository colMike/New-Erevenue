package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.RightMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RightsMasterRepository extends JpaRepository<RightMaster, Long> {

}
