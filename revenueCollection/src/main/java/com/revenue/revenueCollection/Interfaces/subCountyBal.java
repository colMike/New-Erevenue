package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.SubCounty;

import javax.ejb.Local;
import java.util.List;

@Local
public interface subCountyBal {
    ResponseMessage RegisterSubCounty(SubCounty subCounty);
    ResponseMessage UpdateSubCounty(SubCounty subCounty);

    List<SubCounty> GetAllSubCounties();
}
