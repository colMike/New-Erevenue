package com.revenue.revenueCollection.Interfaces;

import com.revenue.revenueCollection.Models.PermitType;
import com.revenue.revenueCollection.Models.ResponseMessage;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PermitTypeBal {
    ResponseMessage addPermitType(PermitType permitType);

    List<PermitType> GetAllPermitTypes();
}
