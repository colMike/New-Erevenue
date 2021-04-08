package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.RightMaster;

import javax.ejb.Local;
import java.util.List;

@Local
public interface rightMasterBal {
    public List<RightMaster> getRights();
}
