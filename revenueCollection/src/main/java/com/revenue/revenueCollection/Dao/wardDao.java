package com.revenue.revenueCollection.Dao;

import com.revenue.revenueCollection.Models.SubCounty;
import com.revenue.revenueCollection.Models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface wardDao extends JpaRepository<Ward,Integer> {
    @Query("select w from Ward w where w.subCountyId=?1")
    List<Ward> GetWardsBySubCounty(SubCounty subCountyId);
}
