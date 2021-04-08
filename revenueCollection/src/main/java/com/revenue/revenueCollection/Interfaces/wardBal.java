package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.ResponseMessage;
import com.revenue.revenueCollection.Models.SubCounty;
import com.revenue.revenueCollection.Models.Ward;

import javax.ejb.Local;
import java.util.List;
@Local
public interface wardBal {
    ResponseMessage UpdateWard(Ward ward);

    List<Ward> GetAllWards();

    List<SubCounty> GetActiveSubCounties();

    List<Ward> GetWardsBySubCounty(SubCounty subCountyId);
}
